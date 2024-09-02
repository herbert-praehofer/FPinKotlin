package at.jku.ssw.fp.sect15_6

import at.jku.ssw.fp.person.Person
import at.jku.ssw.fp.person.Student
import java.util.LinkedList

fun main() {
  var list : List<String> = listOf("A", "B")

  var ml : MutableList<String> = mutableListOf("A", "B")
  ml = ArrayList<String>()

  val x = list[0]

  var m : Map<Char, Int> = mapOf('A' to 1, 'B' to 2)

  var mm : MutableMap<Char, Int> = mutableMapOf('A' to 1, 'B' to 2)

  val students = listOf<Student>(Student("Hans"))
  val persons = mutableListOf<Person>()

  val s = setOf("A", "B")
  val ms = mutableSetOf("A", "B")

  val ss : MutableSet<String> = sortedSetOf("A", "B")

  copy(students, persons)
  println(persons)

  val hans = students[0]
  persons[0] = Student("Fritz", 22)

}

fun <T> copy(from: List<T>, to: MutableList<T>) {
  for (i in 0 ..< from.size) {
    to.add(from.get(i))
  }
}
