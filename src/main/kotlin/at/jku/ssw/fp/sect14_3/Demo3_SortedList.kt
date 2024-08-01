package at.jku.ssw.fp.sect14_3

fun main() {
    val stringList: SortedListWhere<String> = SortedListWhere()
    stringList.add("B")
    stringList.add("A")
    stringList.add("C")
    stringList.add("E")
    stringList.add("D")
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

    val intList: SortedListWhere<Int> = SortedListWhere()
    intList.add(3)
    intList.add(2)
    intList.add(5)
    intList.add(1)
    intList.add(4)
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