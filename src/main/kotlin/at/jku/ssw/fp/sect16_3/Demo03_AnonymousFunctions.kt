package at.jku.ssw.fp.sect16_3

fun main() {
  val add : (Int, Int) -> Int = fun (x: Int, y: Int): Int = x + y

  val xy = add(1, 2)
}