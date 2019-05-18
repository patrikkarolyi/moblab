package com.example.mobsoft

import android.content.Context
import com.example.mobsoft.mock.MockCharacterApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {


    @Provides
    @Singleton
    fun provideMockCharacterApi(): MockCharacterApi = MockCharacterApi()


}