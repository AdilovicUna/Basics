package design.patterns.structural

import design.patterns.structural.AmericanItem
import design.patterns.structural.CzechItemAdapter
import design.patterns.structural.ForeignItemInterface
import design.patterns.structural.GermanItem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CzechItemAdapterTest {

    @Test
    fun `convert GermanItem to CzechItem successfully`() {
        val germanItem = GermanItem("Bier", 3.0) // Assuming 3.0 Euros
        val adapter = CzechItemAdapter(germanItem)
        val czechItem = adapter.convertToCzechItem()

        assertEquals("Bier", czechItem.name)
        assertEquals(3.0 * CzechItemAdapter.EURO_CONVERSION, czechItem.price)
    }

    @Test
    fun `convert AmericanItem to CzechItem successfully`() {
        val americanItem = AmericanItem("Jeans", 20.0) // Assuming 20.0 USD
        val adapter = CzechItemAdapter(americanItem)
        val czechItem = adapter.convertToCzechItem()

        assertEquals("Jeans", czechItem.name)
        assertEquals(20.0 * CzechItemAdapter.USD_CONVERSION, czechItem.price)
    }

    @Test
    fun `attempt to convert item from unsupported country throws Exception`() {
        val unsupportedItem = object : ForeignItemInterface {
            override val name: String = "Item"
            override val priceInForeignCurrency: Double = 10.0
            override val country: String = "Mars"
        }
        val adapter = CzechItemAdapter(unsupportedItem)

        assertThrows(Exception::class.java) {
            adapter.convertToCzechItem()
        }
    }
}
