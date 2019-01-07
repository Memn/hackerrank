package memn.hackerrank.strings

import java.util.*

fun twoStrings(s1: String, s2: String): String {

    val s1Set = s1.toSet()
    val any = s2.toSet().any { s1Set.contains(it) }
    return if (any)
        "YES"
    else
        "NO"
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}
