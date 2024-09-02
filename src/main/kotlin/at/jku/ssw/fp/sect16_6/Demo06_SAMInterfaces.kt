package at.jku.ssw.fp.sect16_6

import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Stream

fun main() {

  val runnable = Runnable { println("Hi") }
  runnable.run()

  val thread = Thread( { println("Hi") } )

}