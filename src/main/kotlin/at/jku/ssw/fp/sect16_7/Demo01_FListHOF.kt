package at.jku.ssw.fp.sect16_7

import at.jku.ssw.fp.coll.FList
import at.jku.ssw.fp.coll.*

fun main() {
  val lst = "A" cons ("BB" cons ("CCC" cons Nil))
  lst.forEach { println(it) }

  val concatenated = lst.reduce("") {
      c, s -> c + s
  }
  println(concatenated)

  val reversed = lst.reversed()
  println(reversed)

  val totalLength =
    lst.reduce(0) {
        sum, w -> sum + w.length
    }
  println(totalLength)

  val cs = lst.flatMap {
    FList.of(it.chars().mapToObj {it.toChar() }.toList())
  }
  println(cs)

  val lengths = lst.map { it.length }
  println(lengths)

  val filtered = lst.filter { it.length > 1 }
  println(filtered)

}