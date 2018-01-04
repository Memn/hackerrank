package memn.hackerrank


/**
 *
 * @author Memn
 * @date 4.01.2018
 *
 */

fun countInversions(arr: IntArray): Long {
    // Complete this function;
    return mergeSort(arr, 0, arr.size - 1)
}

private fun mergeSort(arr: IntArray, l: Int, r: Int): Long {
    var inversions: Long = 0
    if (r > l) {
        // 1. Find the middle point to divide the array into two halves:;
        val m = (l + r) / 2
        // 2. Call mergeSort for first half:;
        inversions += mergeSort(arr, l, m)
        // 3. Call mergeSort for second half:;
        inversions += mergeSort(arr, m + 1, r)
        // 4. Merge the two halves sorted in step 2 and 3:;
        inversions += merge(arr, l, m, r)
    }
    return inversions
}

private fun merge(arr: IntArray, l: Int, m: Int, r: Int): Long {
    var inversions: Long = 0
    val n1 = m - l + 1
    val n2 = r - m
    val L = IntArray(n1)
    val R = IntArray(n2)

    System.arraycopy(arr, l, L, 0, n1)
    System.arraycopy(arr, m + 1, R, 0, n2)

    var i = 0
    var j = 0
    // Initial index of merged sub-array array;
    var k = l
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i]
            i++
        } else {
            arr[k] = R[j]
            j++
            inversions += (n1 - i).toLong()
        }
        k++
    }

    /* Copy remaining elements of L[] if any */
    if (i < n1) {
        val size = n1 - i
        System.arraycopy(L, i, arr, k, size)
        k += size
    }

    /* Copy remaining elements of R[] if any */
    if (j < n2) {
        val size = n2 - j
        System.arraycopy(R, j, arr, k, size)
    }

    return inversions
}

private fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(args: Array<String>) {
    val (t) = readInts()
    for (a0 in 0 until t) {
        val (_) = readInts()
        val result = countInversions(readInts().toIntArray())
        println(result)
    }
}