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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(number: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, number)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    return addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.number)
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var current = start

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

            override fun next(): MyDate {
                if (hasNext()) {
                    val old = current
                    current = current.nextDay()
                    return old
                } else {
                    throw NoSuchElementException()
                }
            }

        }
    }
}
