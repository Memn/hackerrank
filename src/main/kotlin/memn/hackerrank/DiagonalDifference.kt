package memn.hackerrank


/**
 *
 * @author Memn
 * @date 10.01.2018
 *
 */


private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt).toIntArray()

fun main(args: Array<String>) {
    var fDiagonal = 0
    var sDiagonal = 0
    val (n) = readInts()
    var j = n - 1
    (0 until n).forEach {
        val row = readInts()
        fDiagonal += row[it]
        sDiagonal += row[j--]
    }

    println(Math.abs(fDiagonal - sDiagonal))

}