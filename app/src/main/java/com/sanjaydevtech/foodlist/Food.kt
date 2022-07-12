package com.sanjaydevtech.foodlist

import androidx.annotation.DrawableRes

data class Food(
    val name: String,
    @DrawableRes val imageId: Int,
)
