package com.deeosoft.recipewithcompose.feature.register.domain.usecase

import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse
import com.deeosoft.recipewithcompose.core.usecase.UseCase
import com.deeosoft.recipewithcompose.feature.register.domain.entity.RegisterUserEntity
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRepository
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRequestModel


class RegisterUserWithEmail(var repo: RegisterUserRepository): UseCase<RegisterUserRequestModel, RegisterUserEntity> {
    override suspend fun execute(params: RegisterUserRequestModel): BaseRemoteResponse<RegisterUserEntity> {
        return repo.registerUserWithEmail(params)
    }
}