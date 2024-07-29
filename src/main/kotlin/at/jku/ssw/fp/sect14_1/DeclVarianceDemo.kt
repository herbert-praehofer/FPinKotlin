package at.jku.ssw.fp.sect14_1

import at.jku.ssw.fp.persons.Student

fun main() {

    val toStringFn: Function1<Any, String> = { obj: Any -> obj.toString() }
    val someInfo: Any = applyFunction(toStringFn, Student("Hans", "CS"))
    println(someInfo)

}

fun <A:Any, B:Any> applyFunction(fn: Function1<A, B>, obj: A): B {
    return fn.invoke(obj)
}