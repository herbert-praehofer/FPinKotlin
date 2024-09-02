package at.jku.ssw.fp.sect16_4

fun main() {
  val numbers = listOf(1, 2, 3)

  var sum : Int = 0
  numbers.forEach {
    x -> sum = sum + x
  }

  fun createCounter() : () -> Int {
    var count = 0;
    return {
      ++count
    }
  }

  val counter1 = createCounter()
  val counter2 = createCounter()
  println(counter1())  // 1
  println(counter2())  // 1
  println(counter1())  // 2
  println(counter2())  // 2

  fun createIncrDecr() : (d: Msg) -> Any {
    var count = 0;
    return {
      when (it) {
        Msg.INCR -> count +=1
        Msg.DECR -> count +=-1
        Msg.VALUE -> count
      }
    }
  }

  val counter3 = createIncrDecr()
  counter3(Msg.INCR)
  counter3(Msg.INCR)
  counter3(Msg.DECR)
  println(counter3(Msg.VALUE))

}

enum class Msg { INCR, DECR, VALUE }