package com.example.artspaceapp.data

import com.example.artspaceapp.model.ArtData
import com.example.artspaceapp.R

object ArtRepository {
    val artworks = listOf(
        ArtData(
            image = R.drawable.abstract_art,
            title = "Abstract Art",
            author = "John Doe",
            year = "2020"
        ),

        ArtData(
            image = R.drawable.the_starry_night,
            title = "The Starry Night",
            author = "Vincent van Gogh",
            year = "1889"
        ),

        ArtData(
            image = R.drawable.morning_by_the_lake,
            title = "Morning by the Lake",
            author = "Jane Doe",
            year = "2018"
        ),

        ArtData(
            image = R.drawable.the_great_wave_off_kanagawa,
            title = "The Great Wave off Kanagawa",
            author = "Katsushika Hokusai",
            year = "1831"
        ),
    )
}