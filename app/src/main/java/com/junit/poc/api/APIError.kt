package com.junit.poc.api

import retrofit2.HttpException

class APIError(message: String, val statusCode: Int? = null, cause: Throwable? = null) : Throwable(message, cause) {
    constructor(cause: HttpException) : this(cause.message(), cause.code(), cause)
}
