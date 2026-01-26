package com.example.apisomething.data

import com.squareup.moshi.Json

data class UserDto(
    val id : Long,
    @Json(name = "Name") val name: String,
    @Json(name = "Email") val email: String,
    @Json(name = "Password") val password: String,
    @Json(name = "BirthDate") val birthDate: String
)

data class CreateUserRequest(
    @Json(name = "Name") val name: String,
    @Json(name = "Email") val email: String,
    @Json(name = "Password") val password: String,
    @Json(name = "BirthDate") val birthDate: String
)