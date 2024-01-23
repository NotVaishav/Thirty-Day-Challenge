package com.example.thirty_day_challenge.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirty_day_challenge.R

/**
 * A data class to represent the information presented in the dog card
 */
data class Wellness(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    val day: Int,
    @StringRes val content: Int
)

val wellnessItems = listOf(
    Wellness(R.drawable.beach, R.string.beach_title, 1, R.string.beach_content),
    Wellness(R.drawable.vapour, R.string.vapour_title, 2, R.string.beach_content),
    Wellness(R.drawable.work, R.string.work_title, 2, R.string.beach_content),

    )
