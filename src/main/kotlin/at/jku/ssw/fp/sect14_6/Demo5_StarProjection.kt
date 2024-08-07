package at.jku.ssw.fp.sect14_6

fun main() {

  fun demoStar(someList: List<*>) {
    val fst: Any? = someList.get(0)
    println(fst)
  }

  fun demoAny(someList: List<out Any?>) {
    val fst: Any? = someList.get(0)
    println(fst)
  }

  val stringList: List<String> = List("A", "B")
  val intList: List<Int> = List(1, 2)
  demoStar(stringList)
  demoStar(intList)
  demoAny(stringList)
  demoAny(intList)

}
