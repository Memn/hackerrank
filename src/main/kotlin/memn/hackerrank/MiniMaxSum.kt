package memn.hackerrank


/**
 *
 * @author Memn
 * @date 4.01.2018
 *
 */


private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toLong)

fun main(vararg args: String) {
    val arr = readInts()

    val sum = arr.sum()
    print(sum - arr.max()!!)
    print(' ')
    print(sum - arr.min()!!)

}
