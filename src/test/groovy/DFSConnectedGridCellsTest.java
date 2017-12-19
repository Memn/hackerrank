import org.junit.Test;

/**
 * @author Memn
 * @date 19.12.2017
 */

public class DFSConnectedGridCellsTest {
    @Test
    public void findLargestRegionNodeCount() throws Exception {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}};
        int count = new DFSConnectedGridCells(grid).findLargestRegionNodeCount();
        System.out.println(count);
    }

}