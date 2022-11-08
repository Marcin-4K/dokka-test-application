package com.example.dokkatestapplication.units

data class Speed private constructor(
    private val metersPerSecond: Double
) {

    init {
        if (this.metersPerSecond < 0) {
            throw IllegalStateException("Speed is not allowed to be below zero")
        }
    }

    companion object {
        const val KMH_TO_MS = 1000.0 / 3600.0

        const val MS_TO_MPH = 2.237

        fun fromMs(ms: Double): Speed = Speed(ms)

        fun fromKmh(kmh: Double): Speed = Speed(kmh * KMH_TO_MS)

        val ZERO: Speed = Speed(0.0)
    }

    fun kmh(): Double = metersPerSecond / KMH_TO_MS

    fun mph(): Double = metersPerSecond * MS_TO_MPH

    fun ms(): Double = metersPerSecond

    operator fun compareTo(other: Speed): Int =
        this.metersPerSecond.compareTo(other.metersPerSecond)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Speed
        return metersPerSecond.equals(other.metersPerSecond)
    }

    override fun hashCode(): Int = metersPerSecond.hashCode()
}
