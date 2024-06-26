package com.jesusdmedinac.generative.ai.kmp

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.GenerateContentResponse
import com.google.ai.client.generativeai.type.GoogleGenerativeAIException

actual class CommonGenerativeModel(
    private val generativeModel: GenerativeModel
) {
    /**
     * Generates a response from the backend with the provided [Content]s.
     *
     * @param prompt A group of [Content]s to send to the model.
     * @return A [GenerateContentResponse] after some delay. Function should be called within a
     *   suspend context to properly manage concurrency.
     */
    suspend fun generateContent(vararg prompt: Content): GenerateContentResponse =
        with(generativeModel) {
            try {
                generateContent(*prompt)
            } catch (e: Throwable) {
                throw GoogleGenerativeAIException.from(e)
            }
        }
}