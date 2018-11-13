package memn.hackerrank

import java.util.*

// Complete the flippingBits function below.
fun flippingBits(n: Long): Long {
    val mask: Long = 0x00000000FFFFFFFF
    return n.inv().and(mask)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val n = scan.nextLine().trim().toLong()

        val result = flippingBits(n)

        println(result)
    }
}