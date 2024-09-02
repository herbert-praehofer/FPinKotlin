package at.jku.ssw.fp.sect16_6

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.stream.Collectors

const val TEXT_FILE = "files/faust_1.txt"

fun main() {
  val lines = Files.lines(Paths.get(TEXT_FILE))
  val index =
    StreamUtil.number(lines)
      .flatMap { numLine ->
        val words = numLine.value.split("[ .,;?!.:()]".toRegex())
        words.stream()
          .map { it.lowercase()}
          .filter {it.isNotEmpty() && it[0].isLetter()}
          .map { Numbered.of(numLine.n, it) }
      }
      .collect(Collectors.groupingBy(
        { it.value },
        ::TreeMap,
        Collectors.toCollection(::TreeSet)
      ))

  for ((key, value) in index) {
    println(
      "$key ${value.stream()
                .map { it.n.toString() }
                .collect(Collectors.joining(", ", "[", "]"))}")
  }

}