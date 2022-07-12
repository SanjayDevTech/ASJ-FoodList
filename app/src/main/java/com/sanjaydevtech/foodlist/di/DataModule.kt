package com.sanjaydevtech.foodlist.di

import com.sanjaydevtech.foodlist.Food
import com.sanjaydevtech.foodlist.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesListOfFoods(): List<Food> {
        return listOf(
            Food(name = "Rice", imageId = R.drawable.rice),
            Food(name = "Idli", imageId = R.drawable.idli),
            Food(name = "Biryani", imageId = R.drawable.biriyani),
            Food(name = "Masala Dosa", imageId = R.drawable.masala_dosa),
            Food(name = "Vada", imageId = R.drawable.vada),
            Food(name = "Chapathi", imageId = R.drawable.chapathi),
        )
    }
}