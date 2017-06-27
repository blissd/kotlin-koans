package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val y = year.compareTo(other.year)
        val m = month.compareTo(other.month)
        val d = dayOfMonth.compareTo(other.dayOfMonth)
        if (y != 0) return y
        if (m != 0) return m
        return d
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>
