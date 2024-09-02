package at.jku.ssw.fp.sect14_2

import java.io.BufferedReader
import java.io.StringReader
import java.util.Scanner

fun parseInt(s: String) : Int? {
  return try {
    Integer.parseInt(s)
  } catch (e: NumberFormatException) {
    null
  }
}

fun main() {
  print("Input integer: ")
  val n = parseInt(readln())
  println(n)
}