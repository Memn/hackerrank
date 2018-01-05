package memn.hackerrank

import java.util.*


/**
 *
 * @author Memn
 * @date 5.01.2018
 *
 */


private fun readInts(separator: Char = ' ') = readLine()!!.trim().split(separator).map(String::toInt)

fun main(args: Array<String>) {
    val (n) = readInts()
    val heap = PriorityQueue<Int>()
    for (i in 1..n) {
        val query = readInts()
        when (query[0]) {
            1 -> {
                heap.add(query[1])
            }
            2 -> {
                heap.remove(query[1])
            }
            3 -> {
                println(heap.peek())
            }
        }
    }
}