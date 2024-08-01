package at.jku.ssw.fp.sect14_1

import at.jku.ssw.fp.sect14_3.List
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

class ListTest {

    private var list: List<String> = List()

    @BeforeEach
    fun setUp() {
        list = List()
    }

    @Test
    fun testConstructor() {
        assertEquals(0, list.size)
        assertThrows<ArrayIndexOutOfBoundsException> { list.get(0) }
    }

}