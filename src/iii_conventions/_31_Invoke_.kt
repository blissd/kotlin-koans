package iii_conventions

import util.TODO


class Invokable(val count: Int = 0)


operator fun Invokable.invoke(): Invokable = Invokable(this.count + 1)


fun Invokable.getNumberOfInvocations(): Int = this.count

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
