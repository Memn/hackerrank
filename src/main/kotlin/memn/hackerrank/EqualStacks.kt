package memn.hackerrank

import java.util.*


/**
 *
 * @author Memn
 * @date 3.01.2018
 *
 */


private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(vararg args: String) {
    val (_, _, _) = readInts()
    val s1 = readLine()!!.split(' ').map(String::toInt).toTypedArray()
    val s2 = readLine()!!.split(' ').map(String::toInt).toTypedArray()
    val s3 = readLine()!!.split(' ').map(String::toInt).toTypedArray()

    println(maxCommonHeight(s1, s2, s3))
}

fun maxCommonHeight(a1: Array<Int>, a2: Array<Int>, a3: Array<Int>): Int {

    val s1 = CustomStack(a1)
    val s2 = CustomStack(a2)
    val s3 = CustomStack(a3)

    // popped
    while (true) {
        if (s1.empty() || s2.empty() || s3.empty())
            return 0
        if (s1.sum == s2.sum && s2.sum == s3.sum)
            break
        maxOf(s1, s2, s3, Comparator { a, b -> compareValues(a.sum, b.sum) }).pop()

    }
    return s1.sum
}

class CustomStack(array: Array<Int>) {

    private val stack: Stack<Int> = Stack()
    var sum: Int

    init {
        stack.addAll(array.reversedArray())
        this.sum = array.sum()
    }

    fun pop() {
        sum -= stack.pop()
    }

    fun empty(): Boolean {
        return stack.empty()
    }

}
