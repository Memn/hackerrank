/**
 *
 * @author Memn
 * @date 19.12.2017
 *
 */
class DFSConnectedGridCells {
    private final int[][] grid
    private final boolean[][] visited

    DFSConnectedGridCells(int[][] grid) {
        this.grid = grid
        this.visited = new boolean[grid.length][grid[0].length]
    }

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

        int largestRegionNodeCount = new DFSConnectedGridCells(grid).findLargestRegionNodeCount()
        println largestRegionNodeCount
    }

    int findLargestRegionNodeCount() {
        int largestRegionNodeCount = Integer.MIN_VALUE
        int i = 0, j = 0  // start indices
        // head of
        while (i != -1) {
            (i, j) = findNextGraphHead(i, j)
            def temp = traverseGraph(i, j)
            if (largestRegionNodeCount < temp) {
                largestRegionNodeCount = temp
            }
        }

        largestRegionNodeCount
    }

    def traverseGraph(int r, int c) {
        def count = 0
        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length)
            if (grid[r][c] == 1 && !visited[r][c]) {
                visited[r][c] = true
                count++
                count += traverseGraph(r - 1, c - 1)
                count += traverseGraph(r - 1, c)
                count += traverseGraph(r - 1, c + 1)
                count += traverseGraph(r, c - 1)
                count += traverseGraph(r, c + 1)
                count += traverseGraph(r + 1, c - 1)
                count += traverseGraph(r + 1, c)
                count += traverseGraph(r + 1, c + 1)
            }

        return count
    }

    def findNextGraphHead(int i, int j) {
        for (int k = i; k < grid.length; k++) {
            for (int l = j; l < grid[0].length; l++) {
                if (grid[k][l] == 1 && !visited[k][l])
                    return [k, l]
            }
        }
        return [-1, -1]
    }
}
