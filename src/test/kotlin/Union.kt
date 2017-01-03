import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe

/**
 * Created by cory on 1/2/17.
 */

class UnionSpec : Spek({
    describe("Instantiate a list of length of N.") {
        val subject = Union(10)
    }
})
