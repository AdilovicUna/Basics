package design.patterns.creational

class Cocktail(
    val alcohol: String,
    val juice: String,
    val garnish: String?,
    val ice: Boolean,
    val lemon: Boolean
)

class CocktailBuilder {
    private var alcohol: String = "Gin"
    private var juice: String = "Tonic"
    private var garnish: String? = null
    private var ice: Boolean = true
    private var lemon: Boolean = false

    fun setAlcohol(alcohol: String) = apply { this.alcohol = alcohol }
    fun setJuice(juice: String) = apply { this.juice = juice }
    fun setGarnish(garnish: String?) = apply { this.garnish = garnish }
    fun setIce(ice: Boolean) = apply { this.ice = ice }
    fun setLemon(lemon: Boolean) = apply { this.lemon = lemon }

    fun build() = Cocktail(alcohol, juice, garnish, ice, lemon)
}


