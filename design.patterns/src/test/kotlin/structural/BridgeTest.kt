package structural

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SaladTest {

    @Test
    fun `makeSalad uses correct chopping methods for vegetables`() {
        // Redirect stdout to capture print statements
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        // Prepare the vegetables and salad
        val vegetables = listOf(Peper(), Carrot())
        val salad = BasicSalad(vegetables)

        // Make the salad
        salad.makeSalad()

        // Convert the output stream to a String
        val output = outContent.toString()
        // Check that the output contains the expected chopping methods
        assertTrue(output.contains("Chopping peper"))
        assertTrue(output.contains("Chopping in slices"))
        assertTrue(output.contains("Chopping carrot"))
        assertTrue(output.contains("Chopping in dices"))

        // Reset System.out to its original state
        System.setOut(System.out)
    }
}
