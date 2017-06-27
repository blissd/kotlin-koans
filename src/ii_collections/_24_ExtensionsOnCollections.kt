package ii_collections

import util.TODO
import java.util.*

fun todoTask24(): Nothing = TODO(
    """
        Task 24.
        The function should behave the same as '_24_JavaCode.doSomethingStrangeWithCollection'
        Replace all invocations of 'todoTask24()' with the appropriate code.
    """,
        references = { c: Collection<String> -> _24_JavaCode().doSomethingStrangeWithCollection(c) }
)

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }
    val maximumSizeOfGroup = groupsByLength.values.maxBy { it.size }?.size ?: return null
    return groupsByLength.values.find { it.size == maximumSizeOfGroup }
}

