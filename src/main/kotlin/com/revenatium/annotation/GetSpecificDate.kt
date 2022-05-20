package com.revenatium.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class GetSpecificDate(val date: String = "2021-06-06")
