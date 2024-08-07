package at.jku.ssw.fp.sect14_3

fun main() {

  val andrey = object : Person("Andrey", "Breslav") {

    val myLanguage = "Kotlin"

    override val profession: String = "language designer"

    override fun work() {
      println("Im am a $profession and I am developing $myLanguage")
    }
  }

  andrey.work()
  println(andrey.myLanguage)

}

object Andrey : Person("Andrey", "Breslav") {

  val myLanguage = "Kotlin"

  override val profession: String = "language designer"

  override fun work() {
    println("Im am a $profession and I am developing $myLanguage")
  }
}