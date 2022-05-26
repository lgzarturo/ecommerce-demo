package com.revenatium.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtRequestFilter : OncePerRequestFilter() {

    @Autowired
    private val jwtTokenUtil: JwtTokenUtil? = null

    @kotlin.jvm.Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val requestTokenHeader = request.getHeader("Authorization")
        var username: String? = null
        var jwtToken: String? = null

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            //validar el token
            jwtToken = requestTokenHeader.substring(7)
            try {
                username = jwtTokenUtil!!.getUsernameByToken(jwtToken)
            } catch (e: Exception) {
                throw java.lang.RuntimeException("Token invalido porque no empieza con Bearer")
            }
        } else {
            throw java.lang.RuntimeException("Token invalido porque no empieza con Bearer")
        }

        if (SecurityContextHolder.getContext().authentication == null) {

            //UsernamePasswordAuthenticationToken(userDa)

            SecurityContextHolder.getContext().authentication = null
        }

        chain.doFilter(request, response)
    }
}
