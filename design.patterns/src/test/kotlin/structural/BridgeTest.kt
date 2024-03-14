package structural

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SaladTest {

    @Test
    fun `makeSalad uses correct chopping methods for vegetables`() {
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        val vegetables = listOf(Peper(), Carrot())
        val salad = BasicSalad(vegetables)

        salad.makeSalad()

        val output = outContent.toString()

        assertTrue(output.contains("Chopping peper"))
        assertTrue(output.contains("Chopping in slices"))
        assertTrue(output.contains("Chopping carrot"))
        assertTrue(output.contains("Chopping in dices"))

        System.setOut(System.out)
    }
}
