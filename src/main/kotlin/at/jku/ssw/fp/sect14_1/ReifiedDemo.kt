package at.jku.ssw.fp.sect14_1

inline fun <reified T: Any> filterTs(list: List<*>) : List<T> {
    val filtered : List<T> = List<T>()
    for (e in list) {
        if (e is T) filtered.add(e)
    }
    return filtered
}

fun main() {
    val list = List<Any>()
    list.add("A"); list.add(2); list.add(true); list.add("B")
    val strings = filterTs<String>(list)
    println(strings)
}

