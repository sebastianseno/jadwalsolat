package com.dodolife.jadwalsholat.network

import com.dodolife.jadwalsholat.BuildConfig
import com.dodolife.jadwalsholat.network.service.PrayerTimesService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesResponseInterceptor(): ResponseInterceptor {
        return ResponseInterceptor()
    }

        @Provides
    @Singleton
    fun retrofitBuilder(
        moshi: Moshi,
        okHttpClient: OkHttpClient,
        responseInterceptor: ResponseInterceptor
        ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(ResponseJsonChecker)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okHttpClient)
            .build().also { response ->
                responseInterceptor.retrofit = response
            }
    }

    @Provides
    @Singleton
    fun moshiBuilder(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun okHttpClient(
        responseInterceptor: ResponseInterceptor
    ): OkHttpClient {
//        val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
//            .tlsVersions(TlsVersion.TLS_1_2)
//            .cipherSuites(
//                CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256,
//                CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA
//            ).build()
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(responseInterceptor)
//            .connectionSpecs(listOf(spec))
        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }

        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun providePrayerTimesServices(retrofit: Retrofit): PrayerTimesService {
        return retrofit.create(PrayerTimesService::class.java)
    }
}