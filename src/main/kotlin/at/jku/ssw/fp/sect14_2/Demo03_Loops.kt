package at.jku.ssw.fp.sect14_2

fun ggt(a: Int, b: Int) : Int {
  if (b > a) return ggt(b, a)
  var x : Int = a
  var y : Int = b
  var r = x % y
  while (r != 0) {
    x = b
    y = r
    r = x % y
  }
  return y
}

fun main() {
  val n = 10
  for (i in 1..n) {
    println(i)
  }

  println(ggt(12, 9))

  println(ggt(24, 39))

}
