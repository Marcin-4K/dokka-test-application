package com.example.dokkatestapplication.units

data class Duration private constructor(
    private val milliseconds: Long
) : Comparable<Duration> {
    companion object {
        val ZERO: Duration = fromMilliseconds(0)

        fun fromMilliseconds(milliseconds: Long): Duration =
            Duration(milliseconds)

        fun fromSeconds(seconds: Long): Duration = Duration(seconds * 1000)

        fun fromMinutes(minutes: Long): Duration = Duration(minutes * 60 * 1000)

        fun fromHours(hours: Long): Duration = Duration(hours * 60 * 60 * 1000)

        fun add(first: Duration, second: Duration) = first + second

        fun subtract(first: Duration, second: Duration) = first - second
    }

    fun milliseconds(): Long = milliseconds

    fun seconds(): Long = milliseconds / 1000

    fun minutes(): Long = milliseconds / 1000 / 60

    fun hours(): Long = milliseconds / 1000 / 60 / 60

    operator fun plus(other: Duration): Duration = Duration(this.milliseconds + other.milliseconds)

    operator fun minus(other: Duration): Duration = Duration(this.milliseconds - other.milliseconds)

    override operator fun compareTo(other: Duration): Int = this.milliseconds.compareTo(other.milliseconds)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Duration

        if (milliseconds != other.milliseconds) return false

        return true
    }

    override fun hashCode(): Int = milliseconds.hashCode()
}
