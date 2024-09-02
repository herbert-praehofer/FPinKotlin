package at.jku.ssw.fp.sect14_1

fun main() {
  val stringArray: Array<String> = arrayOf("A", "B", "C")
  println(stringArray[0])
  stringArray[2] = "X"

  val stringArray2: Array<String?> = arrayOfNulls(5)
  val stringArray3: Array<String> = Array(5, {i -> ""})

  val integerArray : Array<Int?> = arrayOfNulls(5)

  val intArray : IntArray = intArrayOf(1, 2, 3)
  val intArray2 : IntArray = IntArray(5, {i -> i * i})
  for (x in intArray2) println("$x ")

  for (i in 1..5 step 2) println(i)
  for (i in 5 downTo 1 step 2) println(i)

  val range : IntRange = 1 .. 5

  val indices : IntProgression = intArray.indices.reversed()

  for (i in 5 downTo 1) println(i)
  for (i in 1 ..< 5) println(i)



}