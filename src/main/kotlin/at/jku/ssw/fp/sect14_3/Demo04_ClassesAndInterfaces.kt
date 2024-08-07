package at.jku.ssw.fp.sect14_3

import java.io.Serializable

enum class Study { ComputerSience, Business, Law, Mathematics }

interface Worker {
  fun work() : Unit
}

interface WithName {
  object Test { val test = "hallo"}
  val firstName: String
  val lastName: String
  val name: String
    get() = "$firstName $lastName"
}

abstract class Person
  protected constructor (override val firstName: String, override val lastName: String)
  : Comparable<Person>, Serializable, WithName {

  abstract val profession: String

  init {
    println("constructed person with primary constructor")
  }

  abstract fun work(): Unit

  override fun compareTo(other: Person): Int {
    var c = lastName.compareTo(other.lastName)
    if (c != 0) return c
    return firstName.compareTo(other.firstName)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false
    other as Person
    if (firstName != other.firstName) return false
    if (lastName != other.lastName) return false
    return true
  }

  override fun hashCode(): Int {
    var result = firstName.hashCode()
    result = 31 * result + lastName.hashCode()
    return result
  }

  override fun toString(): String {
    return "Person(firstName='$firstName', lastName='$lastName')"
  }

}

open class Student(firstName: String, lastName: String, val study: Study) : Person(firstName, lastName) {

  constructor(firstName: String, lastName: String) :
          this(firstName, lastName, Study.ComputerSience) {
    println("constructed person with secondary constructor")
  }

  override val profession: String = "Student"

  override fun work() {
    println("I am a $profession and I am studying $study")
  }

  companion object {
    fun create(firstName: String, lastName: String, study: Study) =
      Student(firstName, lastName, study)
  }

}

open class Student2
  private constructor(firstName: String, lastName: String, val study: Study)
  : Person(firstName, lastName) {

  override val profession: String = "Student"

  override fun work() {
    println("I am a $profession and I am studying $study")
  }

  companion object {
    val students: MutableSet<Student2> = mutableSetOf()

    fun create(firstName: String, lastName: String, study: Study): Student2 {
      val stdt = Student2(firstName, lastName, study)
      students.add(stdt)
      return stdt
    }

    fun create(firstName: String, lastName: String) =
      create(firstName, lastName, Study.ComputerSience)
  }
}

fun main() {
  val stdt = Student("Harald", "Berger", Study.Law)
  stdt.work()

  val stdt2 = Student2.create("Harald", "Berger", Study.Law)
  for (stdt in Student2.students) {
    println(stdt)
  }
}