package hashtable

interface HashTableInterface<K, V> {

    fun hash(key: K): Int

    fun put(key: K, value: V)

    fun get(key: K): V?

    fun remove(key: K)

    fun containsKey(key: K): Boolean

    fun containsValue(value: V): Boolean

    fun keys(): Set<K>

    fun values(): List<V>

    fun size(): Int

    fun isEmpty(): Boolean

    fun clear()

//    private fun resize()
}
