package design.patterns.creational

import design.patterns.creational.Singleton
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.test.Test

class SingletonTest {
    @Test
    fun `getInstance returns the same instance on subsequent calls`() {
        val instance1 = Singleton.getInstance()
        val instance2 = Singleton.getInstance()
        assert(instance1 == instance2) { "Instances $instance1 and $instance2 are not the same" }
    }

    @Test
    fun `ensure MySingleton is thread-safe`() {
        val executor = Executors.newFixedThreadPool(100) // Use a thread pool with a large number of threads
        val instances = mutableListOf<Singleton>()

        for (i in 1..1000) {
            executor.submit {
                instances.add(Singleton.getInstance())
            }
        }

        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)

        val firstInstance = instances.first()
        instances.forEach {
            assert(firstInstance == it) { "Instances $firstInstance and $it are not the same" }
        }
    }
}