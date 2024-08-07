package at.jku.ssw.fp.sect14_4

import at.jku.ssw.fp.sect14_3.Person
import at.jku.ssw.fp.sect14_3.Student
import at.jku.ssw.fp.sect14_3.Study
import kotlin.math.absoluteValue
import kotlin.math.roundToInt
import kotlin.math.sign


fun Person.print() {
  println("I am a person. My name is $name and I am a $profession")
}

fun Student.print() {
  println("I am a student. My name is $name and I am studying $study")
}

fun main() {

  val stdt = Student.create("Harald", "Berger", Study.Law)
  stdt.print()
  val person: Person = stdt
  person.print()

  val str = "Hallo"

  str.plus(", World")
  str.replace('a','x')

  val d : Double = -3.34
  val i : Int = d.toInt()
  val ir : Int = d.roundToInt()
  val sign = i.sign
  val d1 = d.inc()
  val a1 = d1.absoluteValue
  println(a1.toString())
}