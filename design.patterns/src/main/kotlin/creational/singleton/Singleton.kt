package src.main.kotlin.creational.singleton

import kotlin.concurrent.Volatile

class Singleton private constructor(){

    companion object {
        @Volatile
        private var INSTANCE: Singleton? = null

        fun getInstance() = synchronized(this) {
            INSTANCE ?: Singleton().also { INSTANCE = it }
        }
    }

}