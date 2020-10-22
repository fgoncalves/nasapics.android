package com.github.fgoncalves.foundation.commons.interceptors

import com.github.fgoncalves.foundation.commons.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to just add the api key to every call as a query parameter
 */
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .url(
                chain.request().url.newBuilder()
                    .setQueryParameter("api_key", API_KEY)
                    .build()
            )
            .build()

        return chain.proceed(newRequest)
    }
}
