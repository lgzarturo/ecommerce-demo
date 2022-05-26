package com.revenatium.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

@Suppress("UNCHECKED_CAST")
@Component
class JwtTokenUtil : java.io.Serializable {
    @Value("\${jwt.secret}")
    private val secret: String? = null

    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }

    private fun <T> getClaimsFromToken(token: String?, claimsResolver: Function<Claims?, T>): T {
        val claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    fun getUsernameByToken(token: String?): String {
        return getClaimsFromToken(token, { obj: Claims -> obj.subject } as (Claims?) -> String)
    }

    private fun getExpirationDateByToken(token: String?): Date {
        return getClaimsFromToken(token, { obj: Claims -> obj.expiration } as (Claims?) -> Date)
    }

    private fun isTokenExpired(token: String?): Boolean {
        val expiration: Date = getExpirationDateByToken(token)
        return expiration.before(Date())
    }

    private fun doGenerateToken(claims: Map<String, Any>, sub: String): String {
        return Jwts.builder().setClaims(claims).setSubject(sub).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .signWith(SignatureAlgorithm.HS512, secret).compact()
    }

    private fun validateToken(token: String?, userDetails: UserDetails): Boolean {
        val username = getUsernameByToken(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    companion object {
        const val JWT_TOKEN_VALIDITY = (5 * 60 * 60).toLong()
        private const val serialVersionUID = -1
    }
}
