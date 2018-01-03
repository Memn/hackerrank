package memn.hackerrank


/**
 *
 * @author Memn
 * @date 2.01.2018
 *
 */

private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(vararg args: String) {
    val (n, q) = readInts()
    val seqList = Array(n, { ArrayList<Int>() })

    var lastAnswer = 0
    for (i in 0 until q) {
        val (a, x, y) = readInts()
        when (a) {
            1 -> {
                seqList[(x.xor(lastAnswer) % n)].add(y)
            }
            2 -> {
                val seq = seqList[x.xor(lastAnswer) % n]
                lastAnswer = seq[y % seq.size]
                println(lastAnswer)
            }

        }
    }

}
