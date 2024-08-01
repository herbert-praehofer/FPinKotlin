package at.jku.ssw.fp.sect14_3

class SortedList<E: Comparable<E>> : Iterable<E> {

    constructor(vararg es: E) {
        for (e in es) add(e)
    }

    var elems : Array<E?> = arrayOfNulls<Comparable<E>>(16) as Array<E?>
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