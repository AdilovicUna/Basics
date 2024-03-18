package design.patterns.structural

interface ForeignItemInterface {
    val name: String
    val priceInForeignCurrency: Double
    val country: String
}

class GermanItem(override val name: String, override val priceInForeignCurrency: Double) : ForeignItemInterface {
    override val country: String = "Germany"
}

class AmericanItem(override val name: String, override val priceInForeignCurrency: Double) : ForeignItemInterface {
    override val country: String = "America"
}

data class CzechItem(val name: String, val price: Double)

class CzechItemAdapter(private val foreignItem: ForeignItemInterface) {

    companion object {
        const val EURO_CONVERSION = 25.18
        const val USD_CONVERSION = 23.01
    }

    fun convertToCzechItem(): CzechItem {
        val priceInCzk = when(foreignItem.country) {
            "Germany" -> foreignItem.priceInForeignCurrency * EURO_CONVERSION
            "America" -> foreignItem.priceInForeignCurrency * USD_CONVERSION
            else -> {
                throw Exception("Country ${foreignItem.country} not supported")
            }
        }
        return CzechItem(foreignItem.name, priceInCzk)
    }
}