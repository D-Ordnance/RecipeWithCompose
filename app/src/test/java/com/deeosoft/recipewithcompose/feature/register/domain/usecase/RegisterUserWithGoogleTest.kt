package com.deeosoft.recipewithcompose.feature.register.domain.usecase

import com.deeosoft.recipewithcompose.core.failure.ServerFailure
import com.deeosoft.recipewithcompose.core.response.BaseRemoteResponse
import com.deeosoft.recipewithcompose.feature.register.domain.entity.RegisterUserEntity
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRepository
import com.deeosoft.recipewithcompose.feature.register.domain.repository.RegisterUserRequestModel
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class RegisterUserWithGoogleTest {
    private lateinit var mockRegisterUserRepository: RegisterUserRepository
    private lateinit var useCase: RegisterUserWithGoogle
    private lateinit var response: RegisterUserEntity
    private val errorMessage = "An error occurred"
    private val serverFailure = ServerFailure(errorMessage)

    @BeforeEach
    fun setUp() {
        mockRegisterUserRepository = Mockito.mock()
        response = RegisterUserEntity(name = "Dolapo Olakanmi", message = "Successful")
        useCase = RegisterUserWithGoogle(repo = mockRegisterUserRepository)
    }

    @DisplayName("should return a [RegisterUserEntity] when register with email use case is called")
    @Test
    fun should_return_RegisterUserEntity() = runBlocking {
        testUseCases(BaseRemoteResponse.Success(response)) { actual ->
            Assertions.assertEquals(actual.data, response)
        }
    }

    @DisplayName("should return a [Failure] when register with email use case is called")
    @Test
    fun should_return_Failure() = runBlocking {
        testUseCases(BaseRemoteResponse.Error(failure = serverFailure)) { actual ->
            Assertions.assertEquals(actual.failure?.message, errorMessage)
            Assertions.assertTrue(actual is BaseRemoteResponse.Error)
        }
    }

    private fun testUseCases(remoteResponse: BaseRemoteResponse<RegisterUserEntity>, assertions: (BaseRemoteResponse<RegisterUserEntity>) -> Unit) = runBlocking {
        //Arrange
        Mockito.`when`(mockRegisterUserRepository.registerUserWithGoogle()).thenAnswer {
            remoteResponse
        }
        //Act
        val actual = useCase.execute(NoParams())
        //Assert
        Mockito.verify(mockRegisterUserRepository).registerUserWithGoogle()
        assertions(actual)
    }
}