package at.jku.ssw.fp.sect16_7


import at.jku.ssw.fp.coll.FList
import at.jku.ssw.fp.coll.*

fun main() {
  val lst = "A" cons ("BB" cons ("CCC" cons Nil))

  val reversed0 = lst.reversed()
  println(reversed0)

  val reversed1 = lst.reduce(FList.of<String>()) { l, e -> e cons l }
  println(reversed1)

  var reversed2 = FList.of<String>()
  lst.forEach { e -> reversed2 = e cons reversed2 }
  println(reversed2)

  var reversed3 = FList.of<String>()
  var l = lst
  while (!l.isEmpty) {
    val (head, tail) = l as Cons<String>
    reversed3 = head cons reversed3
    l = tail
  }
}
