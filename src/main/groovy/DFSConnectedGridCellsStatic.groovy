/**
 *
 * @author Memn
 * @date 19.12.2017
 *
 */

class DFSConnectedGridCellsStatic {
    static void main(String[] args) {

        def scanner = new Scanner(System.in)
        def n = scanner.nextInt()
        def m = scanner.nextInt()
        def grid = new int[n][m]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt()
            }
        }

        int largestRegionNodeCount = findLargestRegionNodeCount(grid)
        println largestRegionNodeCount
    }

    static int findLargestRegionNodeCount(int[][] grid) {
        int largestRegionNodeCount = Integer.MIN_VALUE
        boolean[][] visited = new boolean[grid.length][grid[0].length]
        int i = 0, j = 0  // start indices
        while (i != -1) {
            (i, j) = findNextGraphHead(grid, visited, i, j)
            def temp = traverseGraph(grid, visited, i, j)
            if (largestRegionNodeCount < temp) {
                largestRegionNodeCount = temp
            }
        }

        largestRegionNodeCount
    }

    static traverseGraph(int[][] grid, boolean[][] visited, int r, int c) {
        def count = 0
        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length)
            if (grid[r][c] == 1 && !visited[r][c]) {
                visited[r][c] = true
                count++
                count += traverseGraph(grid, visited, r - 1, c - 1)
                count += traverseGraph(grid, visited, r - 1, c)
                count += traverseGraph(grid, visited, r - 1, c + 1)
                count += traverseGraph(grid, visited, r, c - 1)
                count += traverseGraph(grid, visited, r, c + 1)
                count += traverseGraph(grid, visited, r + 1, c - 1)
                count += traverseGraph(grid, visited, r + 1, c)
                count += traverseGraph(grid, visited, r + 1, c + 1)
            }

        return count
    }

    static findNextGraphHead(int[][] grid, boolean[][] visited, int i, int j) {
        for (int k = i; k < grid.length; k++) {
            for (int l = j; l < grid[0].length; l++) {
                if (grid[k][l] == 1 && !visited[k][l])
                    return [k, l]
            }
        }
        return [-1, -1]
    }
}
