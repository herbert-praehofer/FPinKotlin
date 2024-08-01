package at.jku.ssw.fp.sect14_3

fun demoStar(someList: SortedList<*>) {
    val fst: Comparable<*> = someList.get(0)
    println(fst)
}

fun demoComparableStar(someList: SortedList<out Comparable<*>>) {
    val fst: Comparable<*> = someList.get(0)
    println(fst)
}

fun demoComparableNothing(someList: SortedList<out Comparable<in Nothing>>) {
    val fst: Comparable<*> = someList.get(0)
    println(fst)
}

fun main() {
    val stringList: SortedList<String> = SortedList("A", "B")
    val intList: SortedList<Int> = SortedList(1, 2)
    demoStar(stringList)
    demoStar(intList)
    demoComparableStar(stringList)
    demoComparableStar(intList)
    demoComparableNothing(stringList)
    demoComparableNothing(intList)
}
