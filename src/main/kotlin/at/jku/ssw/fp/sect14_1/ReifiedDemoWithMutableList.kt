package at.jku.ssw.fp.sect14_1

inline fun <reified T: Any> filterTsWithMutableList(list: MutableList<*>) : MutableList<T> {
    val filtered : MutableList<T> = mutableListOf<T>()
    for (e in list) {
        if (e is T) filtered.add(e)
    }
    return filtered
}

fun main() {
    val list = mutableListOf("A", 2, true, "B")
    val strings = filterTsWithMutableList<String>(list)
    println(strings)
}

