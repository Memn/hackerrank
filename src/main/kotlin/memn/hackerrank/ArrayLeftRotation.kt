package memn.hackerrank


/**
 *
 * @author Memn
 * @date 3.01.2018
 *
 */

private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(vararg args: String) {
    val (_, d) = readInts()
    val array = readLine()!!.split(' ').map(String::toInt).toTypedArray()
    leftRotate(array, d)
    for (i in array) {
        print(i)
        print(' ')
    }
}

private fun leftRotate(array: Array<Int>, rotation: Int) {
    val d = rotation % array.size
    val temp = Array(d, { array[0] })
    System.arraycopy(array, 0, temp, 0, d)
    System.arraycopy(array, d, array, 0, array.size - d)
    System.arraycopy(temp, 0, array, array.size - d, d)
}
