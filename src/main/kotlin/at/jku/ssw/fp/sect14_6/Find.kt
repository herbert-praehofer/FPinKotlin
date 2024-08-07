package at.jku.ssw.fp.sect14_6

import java.util.Optional

fun <T> find(list: kotlin.collections.List<T>, item: T & Any): Optional<T> {
  for (i in 0..list.size) {
    if (list.get(i) == item) {
      return Optional.of(item) as Optional<T>
    }
  }
  return Optional.empty<T>() as Optional<T>
}

fun <T> findAny(list: kotlin.collections.List<T>, item: T & Any): Optional<T> {
  for (i in 0..list.size) {
    if (list.get(i) == item) {
      return Optional.of(item) as Optional<T>
    }
  }
  return Optional.empty<T>() as Optional<T>
}


fun <T : Any> findNonNull(list: List<T>, item: T): Optional<T> {
  for (i in 0..list.size) {
    if (list.get(i) == item) {
      return Optional.of(item) as Optional<T>
    }
  }
  return Optional.empty<T>()
}