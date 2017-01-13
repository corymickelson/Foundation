import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.describe
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * Created by cory on 1/7/17.
 */

class StacksSpec : Spek({
    describe("Dequeue Stack") {
        on("enqueue") {
            val subject = Dequeue()
            subject.append(1)
            subject.prepend(2)
            it("should add two items to center of array") {

                assertThat(subject.q[50], equalTo(2))
                assertThat(subject.q[51], equalTo(1))
            }
        }
        on("resize") {
            val subject = Dequeue()
            for (i in Array(24, { i -> i })) {
                subject.prepend(i)
            }
            subject.prepend(25)
            subject.prepend(26)
            it("resize should double array indexes. values should be centered on new array") {

                assertThat(subject.q.size, equalTo(200))
                assertThat(subject.head, equalTo(87))
                assertThat(subject.tail, equalTo(112))
            }
        }
    }
})
