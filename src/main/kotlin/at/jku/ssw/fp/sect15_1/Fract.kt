package at.jku.ssw.fp.sect15_1

import kotlin.math.abs

data class Fract(private val n: Int, private val d: Int) : Comparable<Fract> {

  constructor(n: Int) : this(n, 1)

  private val gcd = gcd(n, d)

  val num : Int = n / gcd
  val denom : Int = n / gcd

  override fun toString(): String {
    return String.format("%d/%d", num, denom)
  }

  operator fun plus(that: Fract): Fract {
    return Fract(this.num * that.denom + that.num * this.denom, this.denom * that.denom)
  }

  operator fun times(that: Fract): Fract {
    return Fract(this.num * that.num, this.denom * that.denom)
  }

  operator fun unaryMinus(): Fract {
    return Fract(-num, denom)
  }

  fun recip(): Fract {
    return Fract(denom, num)
  }

  override fun compareTo(other: Fract): Int {
    val p = this.num * other.denom
    val q = other.num * this.denom
    return if (p < q) -1
    else if (p > q) 1
    else 0
  }

  companion object {
    // private
    private fun gcd(x: Int, y: Int): Int {
      var x = x
      var y = y
      x = abs(x.toDouble()).toInt()
      y = abs(y.toDouble()).toInt()
      if (y > x) return gcd(y, x)
      else {
        while (y != 0) {
          x = y
          y = x % y
        }
        return x
      }
    }
  }
}

