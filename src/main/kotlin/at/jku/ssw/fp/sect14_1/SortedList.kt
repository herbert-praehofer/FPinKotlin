package at.jku.ssw.fp.sect14_1

class SortedList<E: Comparable<E>> : Iterable<E> {
    companion object {
        private val CAP = 16
    }

    var elems : Array<E?> = arrayOfNulls<Comparable<E>>(CAP) as Array<E?>
    var size: Int = 0

    fun add(elem: E) {
        if (size == elems.size) {
            resize()
        }
        var i = 0
        while (i < size && elem.compareTo(elems[i]!!) > 0)
            i++
        System.arraycopy(elems, i, elems, i + 1, size - i)
        size++
        elems[i] = elem
    }

    fun get(i: Int): E {
        if (i < 0 || i >= size) {
            throw ArrayIndexOutOfBoundsException(i)
        }
        return elems[i]!!
    }

    override fun iterator(): Iterator<E> {
        return object: Iterator<E> {
            var i = 0
            override fun hasNext(): Boolean {
                return i < size
            }

            override fun next(): E {
                i++
                return elems[i-1]!!
            }

        }
    }

    override fun toString(): String {
        return elems.copyOfRange(0, size).joinToString(", ", "[", "]")
    }

    private fun resize() {
        val newElems = arrayOfNulls<Any>(size * 2) as Array<E?>
        System.arraycopy(elems, 0, newElems, 0, size)
        elems = newElems
    }
}

fun main() {
    val stringList: SortedList<String> = SortedList()
    stringList.add("B")
    stringList.add("A")
    stringList.add("C")
    stringList.add("E")
    stringList.add("D")
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

    val intList: SortedList<Int> = SortedList()
    intList.add(3)
    intList.add(2)
    intList.add(5)
    intList.add(1)
    intList.add(4)
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