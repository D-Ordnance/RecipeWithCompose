package com.deeosoft.recipewithcompose.feature.register.domain.repository

import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse
import com.deeosoft.recipewithcompose.feature.register.domain.entity.RegisterUserEntity

interface RegisterUserRepository {
    suspend fun registerUserWithEmail(model: RegisterUserRequestModel?): BaseRemoteResponse<RegisterUserEntity>
    suspend fun registerUserWithGoogle(): BaseRemoteResponse<RegisterUserEntity>
    suspend fun registerUserWithFacebook(): BaseRemoteResponse<RegisterUserEntity>
}

data class RegisterUserRequestModel(
    val name: String,
    val email: String,
    val password: String
)