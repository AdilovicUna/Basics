package design.patterns.creational

import design.patterns.creational.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CharacterActionsTest {

    @Test
    fun `test PlayerActionsFactory`() {
        val playerActionsFactory = PlayerActionsFactory()
        val attack = playerActionsFactory.createAttack()
        val defense = playerActionsFactory.createDefense()

        assertTrue(attack is PlayerAttack)
        assertTrue(defense is PlayerDefense)
    }

    @Test
    fun `test EnemyActionsFactory`() {
        val enemyActionsFactory = EnemyActionsFactory()
        val attack = enemyActionsFactory.createAttack()
        val defense = enemyActionsFactory.createDefense()

        assertTrue(attack is EnemyAttack)
        assertTrue(defense is EnemyDefense)
    }
}
