package at.jku.ssw.fp.sect15_1

import javax.lang.model.element.UnknownElementException

sealed interface Expr
data class Val(val value: Double) : Expr
data class Vbl(val name: String) : Expr
sealed interface BinExpr: Expr {
  val left: Expr
  val right: Expr
}
data class Add(override val left: Expr, override val right: Expr) : BinExpr
data class  Mult(override val left: Expr, override val right: Expr) : BinExpr
sealed interface UnyExpr : Expr {
  val sub: Expr
}
data class  Minus(override val sub: Expr) : UnyExpr
data class  Recip(override val sub: Expr) : UnyExpr

fun eval(expr: Expr, bds: Map<String, Double>) : Double =
  if (expr is Val) expr.value
  else if (expr is Vbl && bds.containsKey(expr.name)) bds[expr.name]!!
  else if (expr is Vbl) throw NoSuchElementException(expr.name)
  else if (expr is Add) eval(expr.left, bds) + eval(expr.right, bds)
  else if (expr is Mult) eval(expr.left, bds) * eval(expr.right, bds)
  else if (expr is Minus) -eval(expr.sub, bds)
  else if (expr is Recip) {
    val sResult : Double = eval(expr.sub, bds)
    if (sResult == 0.0) throw ArithmeticException("/ by zero")
    sResult
  } else throw UnsupportedOperationException("no valid expr")

fun evalWhen(expr: Expr, bds: Map<String, Double>) : Double =
  when (expr) {
    is Val -> expr.value
    is Vbl -> if (bds.containsKey(expr.name))  bds[expr.name]!!
              else throw NoSuchElementException(expr.name)
    is Add -> evalWhen(expr.left, bds) + evalWhen(expr.right, bds)
    is Mult -> evalWhen(expr.left, bds) * evalWhen(expr.right, bds)
    is Minus -> -evalWhen(expr.sub, bds)
    is Recip -> {
      val sResult: Double = evalWhen(expr.sub, bds)
      if (sResult == 0.0) throw ArithmeticException("/ by zero")
      sResult
    }
  }

fun evalWhen2(expr: Expr, bds: Map<String, Double>) : Double =
  when (expr) {
    is Val -> expr.value
    is Vbl -> if (bds.containsKey(expr.name))  bds[expr.name]!!
              else throw NoSuchElementException(expr.name)
    is Add -> {
      val (l, r) = expr
      evalWhen2(l, bds) + evalWhen2(r, bds)
    }
    is Mult -> {
      val (left, right) = expr
      evalWhen2(left, bds) * evalWhen2(right, bds)
    }
    is Minus -> -evalWhen2(expr.sub, bds)
    is Recip -> {
      val sResult: Double = evalWhen2(expr.sub, bds)
      if (sResult == 0.0) throw ArithmeticException("/ by zero")
      sResult
    }
  }
/*
sealed interface Expr {
  fun eval(bds: Map<String, Double>) : Double
}

data class Val(val value: Double) : Expr {
  override fun eval(bds: Map<String, Double>) =
    value
}

data class Vbl(val name: String) : Expr {
  override fun eval(bds: Map<String, Double>) =
    bds[name]!!
}

sealed interface BinExpr : Expr {
  val left: Expr
  val right: Expr
}

data class  Add(override val left: Expr, override val right: Expr) : BinExpr {
  override fun eval(bds: Map<String, Double>) =
    left.eval(bds) + right.eval(bds)
}

data class  Mult(override val left: Expr, override val right: Expr) : BinExpr {
  override fun eval(bds: Map<String, Double>) =
    left.eval(bds) * right.eval(bds)
}

interface UnyExpr : Expr {
  val sub: Expr
}

data class  Minus(override val sub: Expr) : UnyExpr {
  override fun eval(bds: Map<String, Double>) =
    - sub.eval(bds)
}

data class  Recip(override val sub: Expr) : UnyExpr {
  override fun eval(bds: Map<String, Double>) =
    1.0 / sub.eval(bds)
}

 */


