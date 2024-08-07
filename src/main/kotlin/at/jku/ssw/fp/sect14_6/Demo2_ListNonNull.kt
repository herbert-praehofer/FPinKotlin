package at.jku.ssw.fp.sect14_6

fun main() {
  val stringList: ListNonNull<String> = ListNonNull()
  stringList.add("A")
  stringList.add("B")
  stringList.add("C")
  stringList.add("D")
  stringList.add("E")
  println(stringList)
  println(stringList.get(0))
  println(stringList.get(1))
  println(stringList.get(2))
  //println(list.get(5))  // throws exception
  println()
  for (e in stringList) {
    println(e)
  }

  println()

  val intList: ListNonNull<Int> = ListNonNull()
  intList.add(1)
  intList.add(2)
  intList.add(3)
  println(intList)
  val i0: Int = intList.get(0)
  println(i0)
  println(intList.get(1))
  println(intList.get(2))
  //println(list.get(3))  // throws exception

  println()
  for (e in intList) {
    println(e)
  }

}