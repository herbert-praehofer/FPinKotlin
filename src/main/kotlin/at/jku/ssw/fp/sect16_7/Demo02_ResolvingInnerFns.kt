package at.jku.ssw.fp.sect16_7


import at.jku.ssw.fp.coll.FList
import at.jku.ssw.fp.coll.*

fun main() {
  val lst = "A" cons ("BB" cons ("CCC" cons Nil))

  val l0 = lst.map { e -> e.length }

  val l1 = lst.flatMap { e -> FList.of(e.length) }

  val l2 = {
    val r : FList<Int> =
      lst.reduce(FList.of()) {
          lst, e -> FList.of(e.length).reduce(lst) { ll, e2 -> e2 cons ll }
      }
    r.reversed()
  }()

  val l3 = {
    val r : FList<Int> =
      lst.reduce(FList.of()) {
          lst, e -> FList.of(e.length).reduce(lst) { sl, x -> x cons sl }
      }
    r.reduce(FList.of<Int>()) { lst, e -> e cons lst }
  }()

  val l5 = {
    val r : FList<Int> =
      lst.reduce(FList.of()) {
          lst, e -> FList.of(e.length).reduce(lst) { sl, x -> x cons sl }
      };
    {
      var result = FList.of<Int>()
      for (e in r)
        result = e cons result
      result
    }
  }()

  //


}
