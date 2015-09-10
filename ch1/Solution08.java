import java.util.HashSet;
import java.util.Set;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution08 {

    public void zeroMatrix(int[][] matrix) {
        Set<Integer> row = new HashSet<>(), col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
        for (int i : row)
            for (int j = 0; j < matrix[i].length; j++) matrix[i][j] = 0;
        for (int i : col)
            for (int j = 0; j < matrix.length; j++) matrix[j][i] = 0;
    }

}
