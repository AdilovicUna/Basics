package creational

import kotlin.concurrent.Volatile

/**
 * A class of which only a single instance can exist.
 * In kotlin singleton is implemented using "object"
 */
class Singleton private constructor(){

    companion object {
        @Volatile
        private var INSTANCE: Singleton? = null

        fun getInstance() = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Singleton().also { INSTANCE = it }
        }
    }

}