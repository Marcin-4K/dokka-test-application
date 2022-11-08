package com.example.dokkatestapplication.units

data class Length private constructor(
    private val meters: Double
) : Comparable<Length> {
    companion object {
        private const val METERS_TO_KM = 0.001

        private const val METERS_TO_MILE = 0.00062137

        private const val METERS_TO_FEET = 3.28084

        fun fromMeters(meters: Double): Length = Length(meters)

        fun fromKilometers(kilometers: Double): Length =
            Length(kilometers / METERS_TO_KM)

        val ZERO: Length = Length(0.0)

        fun add(first: Length, second: Length) = first + second

        fun subtract(first: Length, second: Length) = first - second
    }

    fun meters(): Double = meters

    fun feet() : Double = meters * METERS_TO_FEET

    fun miles(): Double = meters * METERS_TO_MILE

    fun kilometers(): Double = meters * METERS_TO_KM

    operator fun plus(increment: Length): Length =
        Length(this.meters + increment.meters)

    operator fun minus(decrement: Length): Length =
        Length(this.meters - decrement.meters)

    override operator fun compareTo(other: Length): Int = this.meters.compareTo(other.meters)
}
