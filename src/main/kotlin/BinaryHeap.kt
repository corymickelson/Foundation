/**
 * Created by cory on 1/9/17.
 */

enum class HeapResize {
    INCREASE, DECREASE
}

class MinHeap(
        var address: Array<Int> = Array(100, { i -> -1 }),
        var position: Int = 1) {

    fun left(x: Int): Int = 2 * x
    fun right(x: Int): Int = 2 * x + 1
    fun parent(x: Int): Int = x / 2

    fun push(item: Int) {
        if (position >= address.size * 0.75) resizeAddressSpace()
        if (position == 0) address[position] = item
        else {
            address[position] = item
            bubbleUp(position)
        }
        position++
    }

    private fun resizeAddressSpace() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    tailrec private fun bubbleUp(itemId: Int) {
        if (address[itemId] < address[parent(itemId)]) {
            val child = address[itemId]
            val parent = address[parent(itemId)]
            address[itemId] = parent
            address[parent(itemId)] = child
            bubbleUp(parent(itemId))
        }
    }

    fun pop(): Int {
        val item = address[1]
        address[1] = address[position - 1]
        address[position - 1] = -1
        position--
        trickleDown()
        return item
    }

    tailrec private fun trickleDown(id: Int = 1) {
        var smallest = id
        if(left(id) < position && address[smallest] > address[left(id)]) smallest = left(id)
        if(right(id) < position && address[smallest] > address[right(id)]) smallest = right(id)
        if(smallest != id) {
            swap(id, smallest)
            trickleDown(smallest)
        }
    }

    private fun swap(x:Int, y:Int) {
        val temp = address[x]
        address[x] = address[y]
        address[y] = temp
    }

    fun find(item: Int): HeapItemInfo {
        return HeapItemInfo(0, 0)
    }
}

data class HeapItemInfo(val index: Int, val item: Int)

