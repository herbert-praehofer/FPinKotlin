package at.jku.ssw.fp.sect14_6

class List<E> : Iterable<E> {

  constructor(vararg es: E) {
    for (e in es) add(e)
  }

  var elems: Array<E> = arrayOfNulls<Any?>(16) as Array<E>
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
