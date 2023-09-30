package com.regolia.myrent.http

import android.app.Application
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.Executors

class HttpModule {
    companion object {
        private var _instance: HttpModule? = null
         private var _retrofit: Retrofit? = null


        fun create(application: Application) {
            if(_instance == null){
                _instance = HttpModule()
            }
        }

        fun instance():HttpModule {
            return _instance!!
        }


    }

    constructor() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        val okHttpClient = OkHttpClient()
            .newBuilder() // .addInterceptor(new BearerTokenInterceptor(accessToken))
            .addInterceptor(logging)
            .build()

        val timeModule = JavaTimeModule()
        timeModule.addDeserializer(
            LocalDateTime::class.java, LocalDateTimeDeserializer(
                DateTimeFormatter.ISO_DATE_TIME
            )
        )

        val mapper = ObjectMapper()
        mapper.registerModules(timeModule)
        mapper.configure(SerializationFeature.WRITE_DATES_WITH_CONTEXT_TIME_ZONE, true)
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.dateFormat = StdDateFormat().withColonInTimeZone(true)

//        StdDateFormat df = new StdDateFormat().withColonInTimeZone(true);
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        mapper.setDateFormat(df);


//        StdDateFormat df = new StdDateFormat().withColonInTimeZone(true);
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        mapper.setDateFormat(df);
        _retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://192.168.43.24:5216/api/")
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
    }

    fun retrofit(): Retrofit {
        return _retrofit!!
    }
}