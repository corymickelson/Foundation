/**
 * Created by cory on 1/9/17.
 */

enum class HeapResize {
    INCREASE, DECREASE
}

class MinHeap<T>(
        var address: MutableList<T?> = mutableListOf(null),
        var position: Int = 1) where T : Comparable<T> {

    fun left(x: Int): Int = 2 * x
    fun right(x: Int): Int = 2 * x + 1
    fun parent(x: Int): Int = x / 2

    fun push(item: T) {
        if (position == 0) address.add(position, item)
        else {
            address.add(position, item)
            bubbleUp(position)
        }
        position++
    }

    tailrec private fun bubbleUp(itemId: Int) {
        if (parent(itemId) <= 0) return
        if (address[itemId]!! < address[parent(itemId)]!!) {
            val child = address[itemId]
            val parent = address[parent(itemId)]
            address[itemId] = parent
            address[parent(itemId)] = child
            bubbleUp(parent(itemId))
        }
    }

    fun pop(): T {
        val item = address[1]
        address[1] = address[position - 1]
        position--
        trickleDown()
        return item!!
    }

    tailrec private fun trickleDown(id: Int = 1) {
        var smallest = id
        if (left(id) < position && address[smallest]!! > address[left(id)]!!) smallest = left(id)
        if (right(id) < position && address[smallest]!! > address[right(id)]!!) smallest = right(id)
        if (smallest != id) {
            swap(id, smallest)
            trickleDown(smallest)
        }
    }

    private fun swap(x: Int, y: Int) {
        val temp = address[x]
        address[x] = address[y]
        address[y] = temp
    }
}

data class HeapItemInfo(val index: Int, val item: Int)

