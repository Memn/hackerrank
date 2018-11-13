package memn.hackerrank

import java.util.*
import kotlin.math.max

fun maxCircleSet(queries: Array<Array<Int>>): Array<Int> {
    val circles = Array(queries.size) { 0 }
    val zones = mutableListOf<MutableSet<Int>>()
    var maxZoneSize = Int.MIN_VALUE

    queries.forEachIndexed { i, friend ->
        val filtered = mutableListOf<Int>()
        zones.forEachIndexed { index, set ->
            if (set.contains(friend[0]) || set.contains(friend[1]))
                filtered.add(index)
        }

        when {
            filtered.isEmpty() -> {
                zones.add(mutableSetOf(friend[0], friend[1])) // new zone
                maxZoneSize = max(maxZoneSize, 2)
            }
            filtered.size == 1 -> {
                zones[filtered[0]].add(friend[0])
                zones[filtered[0]].add(friend[1])
                maxZoneSize = max(maxZoneSize, zones[filtered[0]].size)
            }
            else -> {
                // merge zones
                zones[filtered[0]].addAll(zones[filtered[1]])
                zones.removeAt(filtered[1])
                maxZoneSize = max(maxZoneSize, zones[filtered[0]].size)
            }
        }
        circles[i] = (maxZoneSize)
    }
    return circles

}

// value: representative
val people = mutableMapOf<Int, Int>()
val counts = mutableMapOf<Int, Int>() // group counts
var maxReps = Int.MIN_VALUE

fun maxCircle(queries: Array<Array<Int>>): Array<Int> {
    val answers = Array(queries.size) { 0 }
    queries.forEachIndexed { index, friends ->
        updateRelations(friends[0], friends[1])
        answers[index] = maxReps
        people.forEach { println(it.toString()) }
        println()
    }
    return answers
}

fun updateRelations(friend0: Int, friend1: Int) {
    val rep0 = people[friend0]
    val rep1 = people[friend1]

    maxReps = when {
        rep0 == null && rep1 == null -> {
            people[friend0] = friend0
            people[friend1] = friend0
            counts[friend0] = 2
            max(maxReps, 2)
        }
        rep0 != null && rep1 != null && rep0 != rep1 -> { // merge case
            counts[rep0] = counts[rep0]!! + counts[rep1]!!
            counts.remove(rep1)
            people.forEach { t, u -> if (u == rep1) people[t] = rep0 }
            max(maxReps, counts[rep0]!!)
        }
        rep0 == null && rep1 != null -> {
            people[friend0] = rep1
            counts[rep1] = counts[rep1]!! + 1
            max(maxReps, counts[rep1]!!)
        }
        rep0 != null && rep1 == null -> {
            people[friend1] = rep0
            counts[rep0] = counts[rep0]!! + 1
            max(maxReps, counts[rep0]!!)
        }
        else -> maxReps
    }
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    val queries = Array(q) { Array(2) { 0 } }

    for (i in 0 until q) {
        queries[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val ans = maxCircle(queries)

    println(ans.joinToString("\n"))
}
