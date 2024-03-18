package design.patterns.creational

interface Attack {
    fun attack(strength: Int)
}

interface Defend {
    fun defend(strength: Int)
}

interface CharacterActions {
    fun createAttack(): Attack
    fun createDefense(): Defend
}

class PlayerAttack: Attack {
    override fun attack(strength: Int) {
        println("Player attacking with strength $strength")
    }
}

class PlayerDefense: Defend {
    override fun defend(strength: Int) {
        println("Player defending with strength $strength")
    }
}
class PlayerActionsFactory: CharacterActions {
    override fun createAttack(): Attack = PlayerAttack()
    override fun createDefense(): Defend = PlayerDefense()
}

class EnemyAttack: Attack {
    override fun attack(strength: Int) {
        println("Enemy attacking with strength $strength")
    }
}

class EnemyDefense: Defend {
    override fun defend(strength: Int) {
        println("Enemy defending with strength $strength")
    }
}

class EnemyActionsFactory: CharacterActions {
    override fun createAttack(): Attack = EnemyAttack()
    override fun createDefense(): Defend = EnemyDefense()
}