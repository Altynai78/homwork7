package com.example.youtubeparccer.core.network

import java.lang.reflect.Array.get
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRetrofit(okHttpClient = get()) }
    factory { provideApi(retrofit = get()) }
    factory { RemoteDataSource(apiService = get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

private fun provideApi(retrofit: Retrofit) = retrofit.create(ApiService::class.java)