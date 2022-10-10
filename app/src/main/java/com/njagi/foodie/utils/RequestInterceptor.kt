package com.njagi.foodie.utils

import okhttp3.Interceptor


class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("x-api-key", CONSTANTS.API_KEY)
            .build()
        return chain.proceed(request)
    }
}

