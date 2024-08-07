package at.jku.ssw.fp.sect14_3

@JvmInline
value class Temperature(val degreesCelsius: Double) {

  fun toFahrenheit(): Double = degreesCelsius * 9 / 5 + 32

  operator fun plus(other: Temperature): Temperature {
    return Temperature(this.degreesCelsius + other.degreesCelsius)
  }

  override fun toString(): String {
    return "$degreesCelsius°C"
  }
}

fun main() {
  val temp1 = Temperature(25.0)
  val temp2 = Temperature(10.0)

  println("Temp1 in Fahrenheit: ${temp1.toFahrenheit()}°F")
  println("Temp1 + Temp2: ${temp1 + temp2}")
}
