package com.example.dokkatestapplication

data class LatLng(
    val latitude: Double,
    val longitude: Double
) {

    companion object {}

    init {
        if (latitude.isNaN()) {
            throw Exception("latitude must not be NaN")
        }

        if (longitude.isNaN()) {
            throw Exception("longitude must not be NaN")
        }
    }
}
