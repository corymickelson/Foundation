import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.lessThanOrEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.security.SecureRandom

/**
 * Created by cory on 1/20/17.
 */
class HeapSortSpec: Spek({
    describe("Heap Sort") {
        on("create") {
            it("sorts input") {
                val testArray = Array(25, {SecureRandom().nextInt(100)})
                val heapSort = HeapSort<Int>(testArray)
                heapSort.subject.mapIndexed { idx, i ->
                    if(i < heapSort.subject.size)
                        assertThat(heapSort.subject[idx], lessThanOrEqualTo(heapSort.subject[idx + 1]))
                }
            }
        }
    }
})
