package at.jku.ssw.fp.sect14_5

import at.jku.ssw.fp.person.Student

fun main() {
  val person = Student("Franz")
  if (person is Student) {
    println(person.study)
  }

  var x: Any? = "Hallo"
  val r =
    when (x) {
      is Int -> x + 1
      is String -> x.length + 1
      else -> 1
    }

  x = null
  val s: String? = x as? String

  println(s?.length)

}