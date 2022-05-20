package com.revenatium.business.component

import com.revenatium.annotation.GetSpecificDate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.time.LocalDate

@Component
class ConvertDate {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetSpecificDate("2001-01-01")
    fun createDateFromString(dateString: String?): LocalDate {
        var date: LocalDate = LocalDate.now()
        if (StringUtils.hasText(dateString)) {
            try {
                date = LocalDate.parse(dateString)
            } catch (e: Exception) {
                log.error("Error al convertir la fecha $dateString", e)
            }
        }
        return date
    }

    @GetSpecificDate()
    fun createDateFromString2(dateString: String?): LocalDate {
        var date: LocalDate = LocalDate.now()
        if (StringUtils.hasText(dateString)) {
            try {
                date = LocalDate.parse(dateString)
            } catch (e: Exception) {
                log.error("Error al convertir la fecha $dateString", e)
            }
        }
        return date
    }
}
