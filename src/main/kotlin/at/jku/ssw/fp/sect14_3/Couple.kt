package at.jku.ssw.fp.sect14_3

class Couple(var first: Pers, var second: Pers) {

  operator fun get(i : Int) : Pers =
    when (i) {
        1 -> first
        2 -> second
        else -> throw IndexOutOfBoundsException(i)
      }

  operator fun set(i : Int, p: Pers) {
    when (i) {
      1 -> first = p
      2 -> second = p
      else -> throw IndexOutOfBoundsException(i)
    }
  }

}

fun main() {
  val couple = Couple(Pers("Maria"), Pers("Hans"))
  val wife = couple[1]
  val husband = couple[2]

  couple[2] = Pers("Peter")
}
