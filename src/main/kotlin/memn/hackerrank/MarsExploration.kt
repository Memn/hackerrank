package memn.hackerrank


/**
 *
 * @author Memn
 * @date 5.01.2018
 *
 */

fun main(args: Array<String>) {
    val count = readLine()!!.filterIndexed { index, c ->
        ((index % 3 == 0 || index % 3 == 2) && c != 'S') || (index % 3 == 1 && c != 'O')
    }.count()
    println(count)
}