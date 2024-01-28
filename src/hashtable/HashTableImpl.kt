package hashtable

import java.lang.StringBuilder
import kotlin.math.abs

class HashTableImpl<K, V> : HashTableInterface<K, V> {
    private var currentSize: Int = 0
    private var bucketsMaxSize: Int = 4
    private var buckets = List<MutableList<Pair<K, V>>>(bucketsMaxSize) { mutableListOf() }

    override fun hash(key: K): Int = abs(key.hashCode()) % bucketsMaxSize

    override fun put(key: K, value: V) {
        if (currentSize + 1 == bucketsMaxSize) {
            resize()
        }
        val index = hash(key)
        buckets[index].add(Pair(key, value))
        currentSize++
    }

    override fun get(key: K): V? {
        val a = null
        val index = hash(key)
        val bucket = buckets[index]
        for (el in bucket) {
            if (key == el.first) {
                 return  el.second
            }
        }
        return a
    }

    override fun remove(key: K) {
        val index = hash(key)
        val bucket = buckets[index]
        for (i in 0..<bucket.size) {
            if (key == bucket[i].first) {
                bucket.removeAt(i)
                currentSize--
            }
        }
    }

    override fun containsKey(key: K): Boolean {
        val index = hash(key)
        val bucket = buckets[index]
        for (el in bucket) {
            if (key == el.first) {
                return true
            }
        }
        return false
    }

    override fun containsValue(value: V): Boolean {
        for (bucket in buckets) {
            for (el in bucket) {
                if (el.second == value) {
                    return true
                }
            }

        }
        return false
    }

    override fun keys(): Set<K> {//возвращает все ключи
        val setOfKeys = mutableSetOf<K>()
        for (bucket in buckets) {
            for (el in bucket) {
                setOfKeys.add(el.first)
            }
        }
        return setOfKeys
    }

    override fun values(): List<V> {//возвращает все вэлью
        val listOfValues = mutableListOf<V>()
        for (bucket in buckets) {
            for (el in bucket) {
                listOfValues.add(el.second)
            }
        }
        return listOfValues
    }

    override fun size() = currentSize

    private fun resize() {
        bucketsMaxSize *= 2
        val buckets2 = List<MutableList<Pair<K, V>>>(bucketsMaxSize) { mutableListOf() }
        for (bucket in buckets) {
            for (el in bucket) {
                val index = hash(el.first)
                buckets2[index].add(Pair(el.first, el.second))
            }
        }
        buckets = buckets2
    }

    override fun isEmpty(): Boolean {
        return currentSize == 0
    }

    override fun clear() {
        for (bucket in buckets) {
            bucket.clear()
        }
        currentSize = 0
    }

    fun string(): String {
        val stringCollector = StringBuilder()
        if (isEmpty()) {
            return "empty"
        } else {
            for (bucket in buckets) {
                stringCollector.append(bucket.toString() + "\n")
            }
        }
        return stringCollector.toString() + "\n"
    }

    override fun toString(): String {
        return string()
    }
}


fun main(args: Array<String>) {
    var hashTable = HashTableImpl<String, Int>()
    hashTable.put("roma", 15)
    hashTable.put("andrey", 12)
    hashTable.put("nik", 13)
    println(hashTable)
    hashTable.put("den", 14)
    println(hashTable)
    hashTable.put("sla", 16)
    hashTable.put("kaj", 1)
    println(hashTable.containsValue(78))
    println(hashTable.containsKey("andrery"))
    println(hashTable)
    println(hashTable.get("sla"))
    println(hashTable.keys())
    println(hashTable.values())
    hashTable.remove("andrey")
    println(hashTable)
    println(hashTable.get("nik"))
    hashTable.clear()
    println(hashTable)
}
