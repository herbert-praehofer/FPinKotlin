package at.jku.ssw.fp.sect16_7

import at.jku.ssw.fp.coll.FList
import at.jku.ssw.fp.coll.*

inline fun <E> FList<E>.forEach(action : (E) -> Any) : Unit {
  var l = this
  while (l is Cons<E>) {
    val (head, tail) = l
    action(head)
    l = tail
  }
}

inline fun <E: Any, R: Any> FList<E>.reduce(identity: R, acc: (R, E) -> R) : R {
  var result = identity
  this.forEach { result = acc(result, it) }
  return result
}

fun <E:Any> FList<E>.reversed(): FList<E> {
  return reduce (FList.of()) { lst, e -> e cons lst }
}

inline fun <E: Any, R: Any> FList<E>.flatMap(mapper: (E) -> FList<R>) : FList<R> {
  val r : FList<R> =
    reduce(FList.of()) {
        lst, e -> mapper(e).reduce(lst) { sl, x -> x cons sl }
      }
  return r.reversed()
}

inline fun <E: Any> FList<E>.filter(predicate: (E) -> Boolean) : FList<E> {
  return flatMap { if (predicate(it)) FList.of(it) else FList.of() }
}

inline fun <E: Any, R: Any> FList<E>.map(mapper: (E) -> R): FList<R> {
  return flatMap { FList.of(mapper(it)) }
}

inline fun <E: Any> FList<E>.find(test: (E) -> Boolean) : E? {
  this.forEach {
    if (test(it)) return it
  }
  return null
}

// other implementation variants

inline fun <E: Any, R: Any> FList<E>.map1(mapper: (E) -> R): FList<R> {
  val r : FList<R> =
    reduce(FList.of()) {
        lst, e -> mapper(e) cons lst
    }
  return r.reversed()
}

inline fun <E: Any> FList<E>.filter2(predicate: (E) -> Boolean) : FList<E> {
  val r : FList<E> = reduce(FList.of()) {
      lst, e -> if (predicate(e)) e cons lst else lst
  }
  return r.reversed()
}

inline fun <E: Any, R: Any> FList<E>.map2(mapper: (E) -> R) : FList<R> {
  val b: List<R> = mutableListOf()
  this.forEach {
    b.addLast(mapper(it))
  }
  return FList.of(b)
}
