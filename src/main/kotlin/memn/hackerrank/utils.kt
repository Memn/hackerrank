package memn.hackerrank

fun <T : Comparable<T>> sortedListOf(vararg elements: T): List<T> = if (elements.isEmpty()) emptyList() else elements.asList().sorted()
