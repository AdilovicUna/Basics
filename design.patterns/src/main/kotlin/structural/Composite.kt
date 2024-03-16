package structural

interface Box { fun openBox() }

class Gift: Box { override fun openBox() = println("Opening a gift") }

class Package: Box {
    private val containsBoxes = mutableListOf<Box>()
    fun addBox(box: Box) = containsBoxes.add(box)
    fun removeBox(box: Box) = containsBoxes.remove(box)

    override fun openBox() {
        println("Opening a box")
        containsBoxes.forEach {
            it.openBox()
        }
    }
}