package at.jku.ssw.fp.sect15_1

open class Item(x: Int)

@JvmRecord
data class Person(val firstName: String, val lastName: String)

fun main() {
  val franzMaier = Person("Franz", "Maier")
  val franzBerger = franzMaier.copy(lastName = "Berger")

  val firstName: String = franzBerger.component1()
  val lastName = franzBerger.component2()
  val (fn, ln) = franzBerger

}