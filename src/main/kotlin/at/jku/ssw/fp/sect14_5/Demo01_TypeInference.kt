package at.jku.ssw.fp.sect14_5

import at.jku.ssw.fp.person.*

fun main() {
  val p =
    if (readln() == "student") Student("Franz")
    else Professor("Wirth")

  val lst = listOf("Hallo", Student("Franz"), 1, 'a')

  val x = readln().toInt()
  val r = if (x != 0) 1 / x else error("/ by 0")

}

fun error(msg: String) : Nothing {
  throw Exception(msg)
}