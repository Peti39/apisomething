package com.example.apisomething.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsersApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id : Long): UserDto

    @POST("users")
    suspend fun createUser(@Body req : CreateUserRequest): UserDto

}