package at.jku.ssw.fp.sect14_6

import at.jku.ssw.fp.person.Student
import at.jku.ssw.fp.person.Study

fun main() {

  val toStringFn: Function1<Any, String> = { obj: Any -> obj.toString() }

  val someInfo: Any = applyFunction(toStringFn,
    Student(
      "Hans",
      23,
      Study.ComputerScience
    )
  )
  println(someInfo)

}

fun <A : Any, B : Any> applyFunction(fn: Function1<A, B>, obj: A): B {
  return fn.invoke(obj)
}