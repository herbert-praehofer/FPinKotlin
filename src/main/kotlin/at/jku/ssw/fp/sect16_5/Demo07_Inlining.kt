package at.jku.ssw.fp.sect16_5

inline fun runIfInlined(condition: Boolean, code: () -> Unit) {
  if (condition) code()
}

inline fun <T, R> List<T>.mapInlined(mapper: (T) -> R): List<R> {
  val result = mutableListOf<R>();
  for (e in this) result.add(mapper.invoke(e))
  return result
}

fun <T, R> List<T>.mapLogged(mapper: (T) -> R): List<R> {  // no inline allowed
  val result = mutableListOf<R>();
  for (e in this) result.add(logCall(e, mapper))  // cannot be inlined
  return result
}

inline fun <T, R> List<T>.mapLoggedInlined(mapper: (T) -> R): List<R> {
  val result = mutableListOf<R>();
  for (e in this) result.add(logCallInlined(e, mapper))
  return result
}

fun List<String>.mapToLength() : List<Int> {
  val result = mutableListOf<Int>();
  for (e in this) result.add(e.length)
  return result
}

inline fun <T, R> logCallInlined(t: T, fn: (T) -> R) : R {
  val r = fn(t)
  println("Returned: $r")
  return r
}

fun <T, R> logCall(t: T, fn: (T) -> R) : R {
  val r = fn(t)
  println("Returned: $r")
  return r
}

fun main() {

  val strings = listOf("A", "AB")
  val lenghts = strings.mapInlined { it.length }
  println(lenghts)

  val lenghts2 = strings.mapLogged { it.length }
  println(lenghts)
}

