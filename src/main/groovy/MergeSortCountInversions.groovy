/**
 *
 * @author Memn
 * @date 29.12.2017
 *
 */

class MergeSortCountInversions {

    static long countInversions(int[] arr) {
        // Complete this function
        mergeSort(arr, 0, arr.length - 1)
    }

    /**
     * @param start index of start to compare, inclusive
     * @param end index of end to compare, exclusive
     * */
    static long mergeSort(int[] arr, int l, int r) {
        long inversions = 0
        if (r > l) {
            // 1. Find the middle point to divide the array into two halves:
            int m = (l + r) / 2
            // 2. Call mergeSort for first half:
            inversions += mergeSort(arr, l, m)
            // 3. Call mergeSort for second half:
            inversions += mergeSort(arr, m + 1, r)
            // 4. Merge the two halves sorted in step 2 and 3:
            inversions += merge(arr, l, m, r)
        }
        inversions
    }

    static long merge(int[] arr, int l, int m, int r) {
        long inversions = 0
        int n1 = m - l + 1
        int n2 = r - m

        int[] L = new int[n1]
        int[] R = new int[n2]

        System.arraycopy(arr, l, L, 0, n1)
        System.arraycopy(arr, m + 1, R, 0, n2)


        int i = 0, j = 0

        // Initial index of merged sub-array array
        int k = l
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                i++
            } else {
                arr[k] = R[j]
                j++
                inversions += n1 - i
            }
            k++
        }
        /* Copy remaining elements of L[] if any */
        if (i < n1) {
            System.arraycopy(L, i, arr, k, n1 - i)
        }

        /* Copy remaining elements of R[] if any */
        if (j < n2) {
            System.arraycopy(R, j, arr, k, n2 - j)
        }

        inversions
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)
        def t = scanner.nextInt()
        for (int a0 = 0; a0 < t; a0++) {
            def n = scanner.nextInt()
            def arr = new int[n]
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = scanner.nextInt()
            }
            long result = countInversions(arr)
            System.out.println(result)
        }
        scanner.close()
    }
}
