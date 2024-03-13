package creational

class Toy(
    val name: String,
    val color: String,
    val height: Double,
    val width: Double,
) {
    fun clone(
    name: String = this.name,
    color: String = this.color,
    height: Double = this.height,
    width: Double = this.width
    ): Toy = Toy(name, color, height, width)
}
