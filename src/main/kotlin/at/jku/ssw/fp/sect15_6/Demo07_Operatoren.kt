package at.jku.ssw.fp.sect15_6

fun main() {

  val ab = listOf("A", "B")
  println("ab = $ab")

  println()

  val abc = ab + "C"
  println("ab = $ab")
  println("abc = $abc")

  println()

  val ac = abc - "B"
  println("ab = $ab")
  println("abc = $abc")
  println("ac = $ac")

  println()

  val mAbc = abc as MutableList<String>
  val mAc = ac as MutableList<String>
  mAbc.add("D")
  mAc.add("D")

  println("ab = $ab")
  println("abc = $abc")
  println("ac = $ac")
  println("mAbc = $mAbc")
  println("mAc = $mAc")

  val mAb : MutableList<String> = ab as MutableList<String>
  mAb.add("X")

  val s1 = setOf("A", "B")
  val mS1 : MutableSet<String> = s1 as MutableSet<String>
  mS1.add("X") // throws exception:

  val sorted = abc.sorted()

}