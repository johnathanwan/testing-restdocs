package com.example.testingrestdocs

import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest(HomeController::class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
class WebLayerTest {

    @Autowired
    val mockMvc: MockMvc? = null

    @Test
    fun `should return default message`() {
        mockMvc!!.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello, World")))
            .andDo(document("home", responseFields(
                fieldWithPath("message").description("The welcome message for the user."))))
    }
}