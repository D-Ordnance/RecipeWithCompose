package com.deeosoft.recipewithcompose.feature.register.domain.usecase

import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse
import com.deeosoft.recipewithcompose.feature.register.domain.entity.RegisterUserEntity
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRepository
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRequestModel
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class RegisterUserWithEmailTest {
    private lateinit var mockRegisterUserRepository: RegisterUserRepository
    private lateinit var useCase: RegisterUserWithEmail
    private lateinit var userModel: RegisterUserRequestModel
    private lateinit var response: RegisterUserEntity

    @BeforeEach
    fun setUp() {
        mockRegisterUserRepository = mock()
        userModel = RegisterUserRequestModel(
            name = "Dolapo Olakanmi",
            email = "dolapoolakanmi@gmail.com",
            password = "password"
        )
        response = RegisterUserEntity(name = "Dolapo Olakanmi", message = "Successful")
        useCase = RegisterUserWithEmail(repo = mockRegisterUserRepository)
    }

    @DisplayName("should return a [RegisterUserEntity] when register with email use case is called")
    @Test
    fun should_return_RegisterUserEntity() = runBlocking {
        //Arrange
        `when`(mockRegisterUserRepository.registerUserWithEmail(any())).thenAnswer { BaseRemoteResponse.Success(response) }
        //Act
        val actual = useCase.execute(params = userModel)
        //Assert
        verify(mockRegisterUserRepository).registerUserWithEmail(userModel)
        assertEquals(actual, BaseRemoteResponse.Success(response))
    }
}