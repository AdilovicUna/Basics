package design.patterns.structural

interface Attack {
    fun executeAttack(strength: Int) = println("Attacking with strength $strength")
}

class Enemy: Attack
abstract class AttackDecorator(
    private val attack: Attack
): Attack {
    override fun executeAttack(strength: Int) = attack.executeAttack(strength)
}

class Boss(attack: Attack) : AttackDecorator(attack) {
    override fun executeAttack(strength: Int) {
        super.executeAttack(strength * 2)
    }
}