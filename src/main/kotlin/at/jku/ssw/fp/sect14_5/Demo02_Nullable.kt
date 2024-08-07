package at.jku.ssw.fp.sect14_5

import at.jku.ssw.fp.person.Student

fun main() {
  var s: String?
  s = "Kotlin"
  s = null

  var s2: String
  s2 = "Kotlin"
  //  s2 = null  // type error, null not allowed

  var s1 : String
  s1 = "Hallo"
  var s3 : String?
  s3 = s1

  if (s != null) {
    println(s.length)
  }

  println(s?.length)

  var stdt: Student? = Student("Franz")
  println(stdt?.study?.name?.length)

  val name: String = (stdt ?: Student("NN")).name

  val stdt2: Student = stdt!!

  val name2: String = stdt!!.name

}