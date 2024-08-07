package at.jku.ssw.fp.sect14_2

fun max(x: Int, y: Int) = if (x >= y) x else y

fun pos(x: Int): Any {
  return if (x > 0) x else Unit
}

fun signIf(x: Int) =
  if (x < 0) -1 else if (x > 0) 1 else 0

fun signWhen(x: Int): Int =
  when {
    x < 0 -> -1
    x > 0 -> +1
    else -> 0
  }

fun main() {
  val a = 3;
  val b = 5;
  val m = max(a, b)
  println(m)

  val s1 = signIf(a)
  println(s1)
  val s2 = signWhen(a)
  println(s1)

  when (signWhen(a)) {
    -1 -> println("negative")
    1 -> println("positive")
    0 -> println("zero")
  }
}
