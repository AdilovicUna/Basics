package design.patterns.structural

import design.patterns.structural.Gift
import design.patterns.structural.Package
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class BoxTest {

    private val standardOut = System.out
    private val outContent = ByteArrayOutputStream()
    private val lineSeparator = System.lineSeparator()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `test opening a gift prints the correct message`() {
        val gift = Gift()
        gift.openBox()
        assertEquals("Opening a gift${lineSeparator}", outContent.toString())
    }

    @Test
    fun `test opening a package with one gift prints the correct messages`() {
        val gift = Gift()
        val packageBox = Package()
        packageBox.addBox(gift)
        packageBox.openBox()
        assertEquals("Opening a box${lineSeparator}Opening a gift${lineSeparator}", outContent.toString())
    }

    @Test
    fun `test opening a package with multiple gifts prints the correct messages`() {
        val gift1 = Gift()
        val gift2 = Gift()
        val packageBox = Package()
        packageBox.addBox(gift1)
        packageBox.addBox(gift2)
        packageBox.openBox()
        assertEquals("Opening a box${lineSeparator}Opening a gift${lineSeparator}Opening a gift${lineSeparator}", outContent.toString())
    }
}
