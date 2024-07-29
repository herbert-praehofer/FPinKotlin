package at.jku.ssw.fp.sect14_1

class List<E> : Iterable<E> {

    companion object {
        private val CAP = 3
    }

    var elems : Array<E> = arrayOfNulls<Any?>(CAP) as Array<E>
    var size: Int = 0

    fun add(elem: E) {
        if (size == elems.size) {
            resize()
        }
        elems[size] = elem
        size++
    }

    private fun resize() {
        val newElems = arrayOfNulls<Any>(size * 2) as Array<E>
        System.arraycopy(elems, 0, newElems, 0, size)
        elems = newElems
    }

    fun get(i: Int): E {
        if (i < 0 || i >= size) {
            throw ArrayIndexOutOfBoundsException(i)
        }
        return elems[i]!!
    }

    override fun iterator(): Iterator<E> {
        return object : Iterator<E> {
            var i = 0
            override fun hasNext(): Boolean {
                return i < size
            }

            override fun next(): E {
                i++
                return elems[i - 1]!!
            }

        }
    }

    override fun toString(): String {
        return elems.copyOfRange(0, size).joinToString(", ", "[", "]")

    }
}

fun main() {
    val stringList: List<String?> = List()
    stringList.add("A")
    stringList.add("B")
    stringList.add("C")
    stringList.add("D")
    stringList.add("E")
    println(stringList)
    println(stringList.get(0))
    println(stringList.get(1))
    println(stringList.get(2))
    //println(list.get(5))  // throws exception
    println()
    for (e in stringList) {
        println(e)
    }

    println()

    val intList: List<Int> = List()
    intList.add(1)
    intList.add(2)
    intList.add(3)
    println(intList)
    val i0: Int = intList.get(0)
    println(i0)
    println(intList.get(1))
    println(intList.get(2))
    //println(list.get(3))  // throws exception

    println()
    for (e in intList) {
        println(e)
    }

}