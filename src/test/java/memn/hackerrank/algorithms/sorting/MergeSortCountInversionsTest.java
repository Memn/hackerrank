package memn.hackerrank.algorithms.sorting;

import org.junit.Test;

/**
 * @author Memn
 * 29.12.2017
 */

public class MergeSortCountInversionsTest {
    @Test
    public void countInversions() throws Exception {
        int[] arr = {2, 4, 1};
        long countInversions = MergeSortCountInversions.countInversions(arr);
        System.out.println(countInversions);
        int[] arr2 = {1, 1, 1, 2, 2};
        countInversions = MergeSortCountInversions.countInversions(arr2);
        System.out.println(countInversions);
        int[] arr3 = {2, 1, 3, 1, 2};
        countInversions = MergeSortCountInversions.countInversions(arr3);
        System.out.println(countInversions);
    }


}