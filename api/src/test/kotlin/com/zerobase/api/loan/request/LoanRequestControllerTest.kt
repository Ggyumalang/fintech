package com.zerobase.api.loan.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(LoanRequestController::class)
internal class LoanRequestControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var loanRequestController: LoanRequestController

    private lateinit var generateKey: GenerateKey

    private lateinit var encryptComponent: EncryptComponent

    private lateinit var mapper : ObjectMapper

    //Mock처리
    private val userInfoRepository: UserInfoRepository = mockk()

    @MockBean
    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl

    companion object {
        private const val baseUrl = "/fintech/api/v1"
    }

    @BeforeEach
    fun init() {
        generateKey = GenerateKey()

        encryptComponent = EncryptComponent()

        loanRequestServiceImpl = LoanRequestServiceImpl(
                generateKey, userInfoRepository, encryptComponent
        )

        loanRequestController = LoanRequestController(loanRequestServiceImpl)

        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()

        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

    @Test
    fun success_loanRequest() {
        //given
        val loanRequestInfoDto : LoanRequestDto.LoanRequestInputDto
            = LoanRequestDto.LoanRequestInputDto(
                userName = "TEST",
                userIncomeAmount = 10000 ,
                userRegistrationNumber = "000101-1234567"
            )

        every { userInfoRepository.save(any()) } returns UserInfo("", "" , "" , 1)

        //when
        //then
        mockMvc.post(
                "$baseUrl/request"
        ){
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loanRequestInfoDto)
        }.andExpect {
            status { isOk() }
        }
    }
}