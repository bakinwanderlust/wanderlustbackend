package de.wanderlustapps.core

@kotlinx.serialization.Serializable
data class ResponseWrapper<T>(
    val status: String,
    val message: String?,
    val data: T?
) {
    companion object {
        fun <T> successResponse(data: T): ResponseWrapper<T> {
            return ResponseWrapper(
                status = "SUCCESS",
                message = null,
                data = data
            )
        }

        fun errorResponse(errorMessage: String): ResponseWrapper<Unit> {
            return ResponseWrapper(
                status = "ERROR",
                message = errorMessage,
                data = null
            )
        }
    }
}

