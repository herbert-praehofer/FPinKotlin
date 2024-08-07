package at.jku.ssw.fp.sect14_3

class Couple(val first: Pers, second: Pers)

class Pers(val name: String) {

  var spouse: Pers? = null

  infix fun merry(spouse: Pers) {
    this.spouse = spouse
    this.spouse?.spouse = this
  }

  operator fun plus(spouse: Pers): Couple {
    this.spouse = spouse
    this.spouse?.spouse = this
    return Couple(this, spouse)
  }

}

fun main() {
  val hans = Pers("Hans")
  val mary = Pers("Mary")
  //val couple = mary merry hans
  val couple = mary + hans
}