package creational

enum class Element {
    FIRE,
    AIR,
    WATER,
    EARTH,
}
interface IBender {
    val name: String
    fun getElement(): Element
}

class FireBender( override val name: String ): IBender { override fun getElement() = Element.FIRE }
class AirBender( override val name: String ): IBender { override fun getElement() = Element.AIR }
class WaterBender( override val name: String ): IBender { override fun getElement() = Element.WATER }
class EarthBender( override val name: String ): IBender { override fun getElement() = Element.EARTH }

class BenderFactory {
    fun createBender(name: String, element: Element): IBender {
        return when(element) {
            Element.FIRE -> FireBender(name)
            Element.AIR -> AirBender(name)
            Element.WATER -> WaterBender(name)
            Element.EARTH -> EarthBender(name)
        }
    }
}