package creational

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BenderTests {
    @Test
    fun `BenderFactory creates benders with correct names and types`() {
        val factory = BenderFactory()

        val fireBender = factory.createBender("Zuko", Element.FIRE)
        val airBender = factory.createBender("Aang", Element.AIR)
        val waterBender = factory.createBender("Katara", Element.WATER)
        val earthBender = factory.createBender("Toph", Element.EARTH)

        assertEquals("Zuko", fireBender.name)
        assertEquals(Element.FIRE, fireBender.getElement())

        assertEquals("Aang", airBender.name)
        assertEquals(Element.AIR, airBender.getElement())

        assertEquals("Katara", waterBender.name)
        assertEquals(Element.WATER, waterBender.getElement())

        assertEquals("Toph", earthBender.name)
        assertEquals(Element.EARTH, earthBender.getElement())
    }
}
