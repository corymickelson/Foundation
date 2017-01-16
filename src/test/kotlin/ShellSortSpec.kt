import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.security.SecureRandom
import java.util.*

/**
 * Created by cory on 1/15/17.
 */
class ShellSortSpec:Spek({
    describe("Shell Sort") {
       on("create") {
           it("does not fail") {
               val subject = Array(25, {i -> SecureRandom().nextInt(100)})
               val op = ShellSort(subject)
               op.shellsort()
               assertThat(op.subject.size, equalTo(25))
           }
       }
    }
})
