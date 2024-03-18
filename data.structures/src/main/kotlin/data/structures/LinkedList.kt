package data.structures

/*
* addFirst(value: E): Add an element to the beginning of the list.
addLast(value: E): Add an element to the end of the list.
removeFirst(): Remove and return the element at the beginning of the list.
removeLast(): Remove and return the element at the end of the list.
get(index: Int): E: Retrieve the element at a specified position in the list.
removeAt(index: Int): Remove the element at a specified position in the list.
size(): Int: Return the number of elements in the list.
isEmpty(): Boolean: Check if the list has no elements.
* */

data class Node<T>(
    var next: Node<T>?,
    var value: T?
)

class LinkedList<T>{
    private var tail: Node<T>? = Node(null, null)
    private var head: Node<T>? = Node(tail, null)
    private var size = 0

    fun size() = size

    fun isEmpty() = size == 0

    fun prepend(element: T) {
        if (head == null) {
            head?.next = tail
            head.value = element
        }
        else if (tail == null)
    }
    fun append(element: T) {

    }

    fun removeFirst() {

    }
    fun removeLast() {

    }

    fun removeAt(index: Int) {

    }

    fun get(index: Int): T {

    }

    private fun isValidIndex(index: Int) = index in 0 ..< size

}