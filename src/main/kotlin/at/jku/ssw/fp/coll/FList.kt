package at.jku.ssw.fp.coll

sealed abstract class FList<out E> : Iterable<E> {
  abstract val size: Int
  val isEmpty
    get() = size == 0

  override fun iterator(): Iterator<E> {
    return object : Iterator<E> {
      var curr: FList<*> = this@FList
      override fun hasNext(): Boolean = curr != Nil
      override fun next() : E {
        if (hasNext()) {
          val (head , tail) = curr as Cons<E>
          curr = tail
          return head
        } else {
          throw NoSuchElementException("No next")
        }
      }
    }
  }

  companion object {
    fun <E: Any> of(es: Iterable<E>): FList<E> {
      var l : FList<E> = Nil
      for (e in es.reversed()) {
        l = e cons l
      }
      return l
    }

    fun <E: Any> of(vararg es: E): FList<E> {
      var l : FList<E> = Nil
      for (e in es.reversed()) {
        l = e cons l
      }
      return l
    }
  }
}
object Nil : FList<Nothing>() {
  override val size: Int = 0
  override fun toString() = "[]"
}
data class Cons<out E>(val head: E, val tail: FList<E>) : FList<E>() {
  override val size = 1 + tail.size
  override fun toString() = "[${this.elemsToString()}]"
}

// Extension functions

inline infix fun <E : Any> E.cons(lst: FList<E>) : FList<E> = Cons(this, lst)
infix fun <E> FList<E>.rem(x: E) : FList<E> =
  when (this) {
    is Nil -> Nil
    is Cons<E> ->
      if (this.head == x) this.tail
      else Cons<E>(this.head, this.tail rem x)
  }

operator fun <E : Any> FList<E>.plus(x: E) : FList<E> = Cons<E>(x, this)
operator fun <E> FList<E>.minus(x: E) : FList<E> =
  when (this) {
    is Nil -> Nil
    is Cons<E> ->
      if (this.head == x) this.tail
      else Cons<E>(this.head, this.tail - x)
  }
fun <E> FList<E>.contains(x: Any?) : Boolean =
  when (this) {
    is Nil -> false
    is Cons ->
      if (head == x) true
      else tail.contains(x)
  }

fun <E> FList<E>.elemsToString() : String =
      when (this) {
        is Nil -> ""
        is Cons<E> ->
          if (this.tail == Nil) this.head.toString()
          else "${this.head.toString()}, ${this.tail.elemsToString()}"
    }

fun main() {
  var l : FList<String> = Nil + "C" + "B" + "A"
  println(l.toString())

  l = l - "B"
  println(l.toString())

  l = l - "B"
  println(l.toString())

  l = l - "A"
  println(l.toString())

  l = l - "C"
  println(l.toString())

  l = l - "A"
  println(l.toString())

  val l2 = FList.of("A", "B", "C")
  println(l2)

  val l3 = FList.of("A", 1, true)
  println(l3)

  for (e in l3) {
    println(e)
  }

  l = Nil
  l = "A" cons ("B" cons ("C" cons Nil))
  println(l)

  l = l rem "B"

  println(l)

}