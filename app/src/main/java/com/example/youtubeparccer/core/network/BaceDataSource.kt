package com.example.youtubeparccer.core.network

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            } else {
                return Resource.error(
                    msg = response.message(),
                    data = response.body()
                )
            }
        } catch (e: Exception) {
            return Resource.error(msg = e.message ?: e.toString(), data = null)
        }
        return Resource.error(null, null)
    }
}