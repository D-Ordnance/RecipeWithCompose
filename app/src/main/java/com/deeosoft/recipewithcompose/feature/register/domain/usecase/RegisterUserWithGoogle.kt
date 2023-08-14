package com.deeosoft.recipewithcompose.feature.register.domain.usecase

import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse
import com.deeosoft.recipewithcompose.core.usecase.UseCase
import com.deeosoft.recipewithcompose.feature.register.domain.entity.RegisterUserEntity
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRepository
import org.jetbrains.annotations.Nullable

class RegisterUserWithGoogle(private var repo: RegisterUserRepository): UseCase<NoParams, RegisterUserEntity> {
    override suspend fun execute(params: NoParams): BaseRemoteResponse<RegisterUserEntity> {
        return repo.registerUserWithGoogle()
    }

}

class NoParams()