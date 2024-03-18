package data.structures

class ListWithArray<T>(
    val capacity: Int = 0
){
    private val values = arrayOfNulls<Any?>(capacity)
    private var size = 0

    fun size() = size

    fun isEmpty() = size == 0

    fun add(element: T) {
        if (size != capacity)
        values[size++] = element
    }

    fun removeAt(index: Int) {
        if (!isValidIndex(index))
            throw IndexOutOfBoundsException("Invalid index: $index")

        val oldValue = values[index] as T
        for (i in index..size - 1) {
            values[i] = values[i + 1]
        }
        values[--size] = null
    }

    fun get(index: Int): T {
        if (!isValidIndex(index))
            throw IndexOutOfBoundsException("Invalid index: $index")

        return values[index] as T
    }

    private fun isValidIndex(index: Int) = index in 0 ..< size
}