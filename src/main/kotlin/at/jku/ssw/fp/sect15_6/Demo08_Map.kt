package at.jku.ssw.fp.sect15_6


fun main() {

  val personAge = mutableMapOf<String, Int>()

  personAge["Hans"] = 23
  personAge["Fritz"] = 22

  personAge.putAll(listOf("Josef" to 32, "Alois" to 31))

  for ((name, age) in personAge) {
    println("$name is age $age")
  }

  println(personAge["Hans"])
}