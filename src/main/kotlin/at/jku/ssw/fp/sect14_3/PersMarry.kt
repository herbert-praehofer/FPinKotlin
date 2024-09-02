package at.jku.ssw.fp.sect14_3

class Pers(val name: String) {

  var spouse: Pers? = null

  infix fun marry(spouse: Pers) {
    this.spouse = spouse
    this.spouse?.spouse = this
  }

  operator fun plus(spouse: Pers) {
    this.spouse = spouse
    this.spouse?.spouse = this
  }

}

fun main() {
  val hans = Pers("Hans")
  val mary = Pers("Mary")
  mary.marry(hans)
  mary marry hans
  mary + hans
  mary.plus(hans)
}