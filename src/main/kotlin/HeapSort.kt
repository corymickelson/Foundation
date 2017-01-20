import kotlin.comparisons.compareValuesBy

/**
 * Created by cory on 1/15/17.
 */

data class HeapNode(var data: Int, var listNo: Int): Comparable<HeapNode> {
    override fun compareTo(other: HeapNode): Int = compareValuesBy(this, other, {it.data}, {it.listNo})
}

class HeapSort<T>(
        var subject: Array<T>,
        var heap: MinHeap<T> = MinHeap()) where T : Comparable<T> {

    init {
       subject.forEach {
           heap.push(it)
       }
        var i = 0
        while (heap.position > 1) {
           subject[i] = heap.pop()
            i++
        }
    }
}