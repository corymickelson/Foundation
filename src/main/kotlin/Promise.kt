import nl.komponents.kovenant.Kovenant
import nl.komponents.kovenant.buildDispatcher
import nl.komponents.kovenant.task

/**
 * Created by cory on 1/2/17.
 */
fun main(args: Array<String>) {
    val ctx = Kovenant.createContext {
        callbackContext.dispatcher = buildDispatcher { name = "cb-new" }
        workerContext.dispatcher = buildDispatcher { name = "work-new" }
    }

    task {
        println("default task $threadName")
    } success {
        println("default success $threadName")
    }

    task(ctx) {
        println("ctx task $threadName")
    } success {
        println("ctx success $threadName")
    }
}

private val threadName : String get() = Thread.currentThread().name