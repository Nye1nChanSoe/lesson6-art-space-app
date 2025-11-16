package com.example.artspaceapp.model

import androidx.annotation.DrawableRes

data class ArtData(
    @DrawableRes val image: Int,
    val title: String,
    val author: String,
    val year: String,
)

