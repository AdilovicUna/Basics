package creational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToyTest {

    @Test
    fun `test clone without modifications creates exact copy`() {
        val originalToy = Toy("Teddy Bear", "Brown", 15.0, 10.0)
        val clonedToy = originalToy.clone()

        assertEquals(originalToy.name, clonedToy.name)
        assertEquals(originalToy.color, clonedToy.color)
        assertEquals(originalToy.height, clonedToy.height)
        assertEquals(originalToy.width, clonedToy.width)
    }

    @Test
    fun `test clone with modifications overrides properties`() {
        val originalToy = Toy("Teddy Bear", "Brown", 15.0, 10.0)

        val modifiedClonedToy = originalToy.clone(color = "White", height = 20.0)

        assertEquals("Teddy Bear", modifiedClonedToy.name)
        assertEquals("White", modifiedClonedToy.color)
        assertEquals(20.0, modifiedClonedToy.height)
        assertEquals(10.0, modifiedClonedToy.width)
    }
}
