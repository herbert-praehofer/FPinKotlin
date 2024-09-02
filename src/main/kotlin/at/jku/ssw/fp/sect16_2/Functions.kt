package at.jku.ssw.fp.sect16_2

import java.util.concurrent.locks.Lock

fun <T, R> List<T>.map(mapper: (T) -> R): List<R> {
  val result = mutableListOf<R>();
  for (e in this) result.add(mapper.invoke(e))
  return result
}

fun <K, V> Map<K, V>.filter(pred: (Map.Entry<K, V>) -> Boolean) : Map<K, V> {
  val result = mutableMapOf<K, V>()
  for (kv in this) {
    if (pred(kv)) result.put(kv.key, kv.value)
  }
  return result
}

fun <K, V, R> Map<K, V>.map(mapper: (Map.Entry<K, V>) -> R) : List<R> {
  val result = mutableListOf<R>()
  for (entry in this) result.add(mapper(entry))
  return result
}

fun <A> tryLock(lock: Lock, code: () -> A) : A {
  lock.lock()
  try {
    return code()
  } finally {
    lock.unlock()
  }
}

fun runIf(condition: Boolean, code: () -> Unit) {
  if (condition) code()
}
