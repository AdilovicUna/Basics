package design.patterns.structural

interface ChoppingMethod {
    fun chop()
}

class Diced: ChoppingMethod {
    override fun chop() = println("Chopping in dices")
}

class Sliced: ChoppingMethod {
    override fun chop() = println("Chopping in slices")
}
interface Vegetable {
    val name: String
    val choppingMethod: ChoppingMethod
}

class Peper: Vegetable {
    override val name: String = "peper"
    override val choppingMethod: ChoppingMethod = Sliced()
}

class Carrot: Vegetable {
    override val name: String = "carrot"
    override val choppingMethod: ChoppingMethod = Diced()
}
abstract class Salad(private val vegetables: List<Vegetable>) {
    abstract fun makeSalad()
}

class BasicSalad(private val vegetables: List<Vegetable>): Salad(vegetables) {
    override fun makeSalad() {
        println("Making salad")
        vegetables.forEach {
            println("Chopping ${it.name}")
            it.choppingMethod.chop()
        }
    }
}