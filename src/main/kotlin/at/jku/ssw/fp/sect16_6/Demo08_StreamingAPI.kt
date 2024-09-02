package at.jku.ssw.fp.sect16_6

import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Stream

data class Article(val name: String, val price: Double)

fun main() {

  val notEmpty = Predicate<String> { s -> s.isNotEmpty() }

  val list: List<String> = listOf("Hallo", "Kotlin")
  val stream: Stream<String> = list.stream()

  val r1: Stream<Char> =
    list.stream()
      .filter (Predicate<String> { it.isNotEmpty() })
      .map(Function<String, Char> { it[0] })
      .map(Function<Char, Char> { it.lowercaseChar() })
      .distinct()
      .sorted()

  val r2: Stream<Char> =
    list.stream()
      .filter { it.isNotEmpty() }
      .map { it[0] }
      .map { it.lowercaseChar() }
      .distinct()
      .sorted()

  val articles = listOf(
    Article("A", 1500.0), Article("B", 700.0), Article("C", 1200.0),
    Article("D", 500.0), Article("E", 600.0), Article("F", 1100.0)
  )

  val cheapArticleNames =
    articles.stream()
      .filter { it.price < 1000.0 }
      .sorted(Comparator.comparingDouble({ it.price}))
      .map { it.name }
      .toList()


}