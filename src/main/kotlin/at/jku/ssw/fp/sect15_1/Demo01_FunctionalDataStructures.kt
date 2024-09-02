package at.jku.ssw.fp.sect15_1

fun main() {
  val p1 : Pair<Int, Char> = Pair(1, 'a')
  println(p1)

  val (fst: Int, snd: Char) = p1

  val p2 : Pair<Int, Char> = 2 to 'b'
  println(p2)
  
  val list: List<Comparable<*>> = p1.toList()


}