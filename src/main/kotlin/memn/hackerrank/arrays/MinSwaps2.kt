package memn.hackerrank.arrays

import java.util.*


// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    val indices = mutableMapOf<Int, Int>()
    arr.forEachIndexed { index, value -> indices[value] = index }

    var swap = 0
    for (i in 1..arr.size) {
        if (i == arr[i - 1]) continue
        val temp = arr[i - 1]
        val lastIndex = indices[i]!!
        arr[lastIndex] = temp
        arr[i - 1] = i
        indices[i] = i - 1
        indices[temp] = lastIndex
        swap++
    }
    return swap
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
