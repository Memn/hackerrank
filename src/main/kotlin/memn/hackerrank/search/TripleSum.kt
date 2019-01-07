package memn.hackerrank.search

import java.util.*

fun triplets(a: Array<Int>, b: Array<Int>, c: Array<Int>): Long {
    var count = 0L
    val ps = a.toSet().sorted()
    val rs = c.toSet().sorted()

    b.toSet().forEach { q ->
        count += ps.binarySearch(q).toLong() * rs.binarySearch(q).toLong()
    }
    return count
}

fun List<Int>.binarySearch(element: Int, fromIndex: Int = 0, toIndex: Int = size): Int {

    var low = fromIndex
    var high = toIndex - 1

    while (low <= high) {
        val mid = (low + high).ushr(1) // safe from overflows
        val midVal = get(mid)

        if (midVal <= element)
            low = mid + 1
        else if (midVal > element)
            high = mid - 1
    }
    return low
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val lenaLenbLenc = scan.nextLine().split(" ")

    val lena = lenaLenbLenc[0].trim().toInt()

    val lenb = lenaLenbLenc[1].trim().toInt()

    val lenc = lenaLenbLenc[2].trim().toInt()

    val arra = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val arrb = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val arrc = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val ans = triplets(arra, arrb, arrc)

    println(ans)
}
