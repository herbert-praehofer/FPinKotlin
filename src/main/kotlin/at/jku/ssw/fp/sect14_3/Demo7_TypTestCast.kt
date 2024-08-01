package at.jku.ssw.fp.sect14_3

fun main() {

    var obj : Any
    if (Math.random() < 0.5) {
        obj = List("A", "B")
    } else {
        obj = List(1, 2)
    }

    if (obj is List<*>) {
        println("It's a list")
    }

    val list : List<*> = obj as List<*>

    val listOrNull : List<*>? = obj as? List<*>

    val stringList: List<String> = obj as List<String>

    val s: String = stringList.get(0)   // possible ClassCastExcption
    println(s)
}