import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.describe
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * Created by cory on 1/6/17.
 */

class PercolateSpek : Spek({
    describe("Percolate") {
        on("On creation.") {
            val subject = Percolation(5)
            it("should instantiate a closed n x n grid") {
                assertThat(subject.id.size, equalTo(5))
                assertThat(subject.id[0].size, equalTo(5))
                assertThat(subject.numberOfOpenSites(), equalTo(0))
            }
        }
        on("Open Site.") {
            val subject = Percolation(5)
            subject.open(0, 1)
            it("should open a new site and set it's status.") {
                assertThat(subject.numberOfOpenSites(), equalTo(1))
                assertThat(subject.id[0][1].status, equalTo(true))
            }
        }
        on("Implicit connection.") {
            val subject = Percolation(5)
            val openings: Array<Pair<Int, Int>> =
                    arrayOf(Pair(0, 1), Pair(1, 1), Pair(2, 1), Pair(3, 1), Pair(4, 1),
                            Pair(2, 4), Pair(1, 4), Pair(2, 3), Pair(2, 2), Pair(0, 4))
            openings.forEach { i -> subject.open(i.first, i.second) }
            it("should update itself and any surrounding open sites.") {
                assertThat(subject.numberOfOpenSites(), equalTo(10))
                assertThat(subject.percolates(), equalTo(true))
            }

        }
    }
})
