package at.jku.ssw.fp.persons

interface Person {
    val name: String
}

data class Student(override val name: String, val study: String) : Person {

}
data class Professor(override val name: String, val research: String) : Person {

}