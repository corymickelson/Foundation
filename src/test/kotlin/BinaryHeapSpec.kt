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
        val heap = MinHeap()
        on("Instantiate") {
            it("") {
                heap.push(1)
                heap.push(2)
                heap.push(3)
                heap.push(4)
                heap.push(5)
                heap.push(6)
                heap.push(7)
                heap.pop()
                heap.push(4)
                assertThat(heap.address[4], equalTo(7))
                assertThat(heap.address[7], equalTo(4))
            }
        }
    }
})