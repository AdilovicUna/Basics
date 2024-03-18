package design.patterns.creational

import design.patterns.creational.CocktailBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CocktailBuilderTest {

    @Test
    fun `build cocktail with default values`() {
        val cocktail = CocktailBuilder().build()

        assertEquals("Gin", cocktail.alcohol)
        assertEquals("Tonic", cocktail.juice)
        assertEquals(null, cocktail.garnish)
        assertEquals(true, cocktail.ice)
        assertEquals(false, cocktail.lemon)
    }

    @Test
    fun `build cocktail with custom values`() {
        val cocktail = CocktailBuilder()
            .setAlcohol("Vodka")
            .setJuice("Orange Juice")
            .setGarnish("Mint")
            .setIce(false)
            .setLemon(true)
            .build()

        assertEquals("Vodka", cocktail.alcohol)
        assertEquals("Orange Juice", cocktail.juice)
        assertEquals("Mint", cocktail.garnish)
        assertEquals(false, cocktail.ice)
        assertEquals(true, cocktail.lemon)
    }
}
