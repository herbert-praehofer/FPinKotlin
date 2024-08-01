package at.jku.ssw.fp.sect14_3

import at.jku.ssw.fp.sect14_3.person.Person
import at.jku.ssw.fp.sect14_3.person.Student

fun covariantAssignmentNotValid() {
    val students: List<Student> = List<Student>()
    //val persons: List<Person> = students

    val persons: List<Person> = List<Person>()
    //val student: List<Student> = persons
}

fun <T> copy(from: List<out T>, to: List<T>) {
    for (i in 0 .. from.size) {
        to.add(from.get(i))
    }
}

fun <T> copy2(from: kotlin.collections.List<T>, to: List<in T>) {
    for (i in 0 .. from.size) {
        to.add(from.get(i))
    }
}

fun <F, T> copy3(from: List<F>, to: List<T>)
   where F : T {
    for (i in 0 .. from.size) {
        to.add(from.get(i))
    }
}

fun <T, F : T> copy4(from: List<F>, to: List<T>) {
    for (i in 0 .. from.size) {
        to.add(from.get(i))
    }
}


fun main() {
    val students: List<Student> = List<Student>()
    val persons: List<Person> = List<Person>()
    copy(students, persons)
}