package memn.hackerrank.search

import memn.hackerrank.sortedListOf
import org.junit.Assert
import org.junit.Test

class TripleSumKtTest {


    @Test
    fun binarySearch() {
        Assert.assertEquals(0, sortedListOf<Int>().binarySearch(1))
        Assert.assertEquals(0, sortedListOf(2).binarySearch(1))
        Assert.assertEquals(0, sortedListOf(2, 3).binarySearch(1))
        Assert.assertEquals(1, sortedListOf(1, 2, 3).binarySearch(1))
        Assert.assertEquals(1, sortedListOf(1, 2, 3, 4).binarySearch(1))
        Assert.assertEquals(3, sortedListOf(1, 2, 3, 4, 5).binarySearch(3))
    }
}