package at.jku.ssw.fp.sect14_3

inline fun <reified T: Any> filterTs(list: List<out Any>) : List<T> {
    val filtered : List<T> = List<T>()
    for (e in list) {
        if (e is T) filtered.add(e)
    }
    return filtered
}

fun main() {
    val list : List<Any> = List<Any>("A", 2, true, "B")
    val strings = filterTs<String>(list)
    println(strings)
}

