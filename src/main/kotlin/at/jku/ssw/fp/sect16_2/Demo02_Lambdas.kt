package at.jku.ssw.fp.sect16_2

import at.jku.ssw.fp.sect14_2.parseInt
import java.util.concurrent.locks.ReentrantLock

fun main() {


  val add1 : (Int, Int) -> Int =
    { x, y ->
      println("Adding $x and $y")
      x + y
    }
  println(add1(1, 2))

  val add2 : () -> Int =
    {
      val x = parseInt(readln())!!
      val y = parseInt(readln())!!
      x + y
    }
  add2()

  val x = parseInt(readln())!!
  val y = parseInt(readln())!!

  runIf(y != 0) {
    val r = x / y
    println("x/y = $r")
  }

  val sharedState : Array<Int> = arrayOf(1, 2, 3)
  val s0 = tryLock(ReentrantLock()) {
    sharedState[0]
  }


  val strings = listOf("A", "B")
  val lenghts = strings.map { it.length }

  val map1 = mapOf(1 to 2, 2 to 3, 3 to 4)
  val filtered1 = map1.map { (k, v) -> k != v }
  val added = map1.map { (k, v) -> k + v }
  println(added)

  val map2 = mapOf("A" to 1, "AB" to 2, "ABC" to 3)
  val filtered2 = map2.map { (k, v) -> k.length == v }
  val correct = map2.map { (k, v) -> k.length == v }
  println(correct)


  val lengths2 = strings.map( String::length )
}

