package memn.hackerrank.algorithms


/**
 *
 * @author Memn
 * @date 18.01.2018
 *
 */


private fun readInts(separator: Char = ' ') = readLine()!!.trim().split(separator).map(String::toInt)


fun main(args: Array<String>) {
    val (_) = readInts()
    val arr = readInts()
    countNumbers(arr).forEach { print(it.toString() + " ") }
}

fun countNumbers(arr: List<Int>): IntArray {
    val counts = IntArray(100, { 0 })
    arr.forEach { i -> counts[i]++ }
    return counts
}
