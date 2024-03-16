package structural

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class AttackTest {

    private val standardOut = System.out
    private val outContent = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `Enemy attack executes correctly`() {
        val enemy = Enemy()
        enemy.executeAttack(10)
        assertTrue(
            outContent.toString().trim().contains(
                "Attacking with strength 10"
            )
        )
    }

    @Test
    fun `Boss attack doubles the strength`() {
        val enemy = Enemy()
        val boss = Boss(enemy)
        boss.executeAttack(10) // Expecting the strength to be doubled
        assertTrue(
            outContent.toString().trim().contains(
                "Attacking with strength 20"
            )
        )
    }
}
