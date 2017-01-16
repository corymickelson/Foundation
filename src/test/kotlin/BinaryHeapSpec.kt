import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.describe
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * Created by cory on 1/13/17.
 */

class BinaryHeapSpec : Spek({
    describe("Binary Heap") {
        val heap = MinHeap<Int>()
        on("Instantiate") {
            it("works") {
                val items = arrayOf(1, 2, 3, 4, 5, 6, 7, 9, 9, 23, 2, 11, 14, 8, 100, 0)
                items.forEach { heap.push(it) }
                heap.pop()
                assertThat(heap.address[1], equalTo(1))
                heap.pop()
                assertThat(heap.address[1], equalTo(2))
            }
        }
    }
})