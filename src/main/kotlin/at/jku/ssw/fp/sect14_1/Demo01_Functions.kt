package at.jku.ssw.fp.sect14_1

fun multiple(x: Double, m: Int): Double {
  return x * m
}

fun multipleExpr(x: Double, m: Int) = x * m

fun multipleDefault(x: Double, m: Int = 2) = x * m

fun printWords(vararg words: String) {
  for (w in words) println(w)
}

fun main() {
  val y1 = multiple(3.0, 2)
  println(y1)

  val y2 = multipleExpr(3.0, 2)
  println(y2)

  val y3 = multipleDefault(3.0)
  println(y3)

  val y4 = multipleDefault(m = 2, x = 3.0)
  val u = println(y4)
  println(u)

  printWords("Hallo", "Kotlin")
}