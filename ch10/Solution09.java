package ch10;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution09 {

    int getMaxLess(int[] list, int target) {
        int l = 0, r = list.length;
        while (l < r - 1) {
            int m = (l + r) >> 1;
            if (list[m] == target) return -2;
            if (list[m] > target) r = m;
            else l = m;
        }
        if (l == r - 1) {
            if (list[l] == target) return -2;
            if (list[l] < target) return l;
        }
        return -1;
    }

    int getMinGreater(int[] list, int target) {
        int l = 0, r = list.length - 1;
        while (l < r) {
            int m = (l + r) >> 1;
            if (list[m] == target) return -2;
            if (list[m] < target) l = m + 1;
            else r = m;
        }
        if (l == r) {
            if (list[l] == target) return -2;
            if (list[l] > target) return l;
        }
        return -1;
    }

    public boolean sortedMatrixSearch(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1, left = 0, right;
        if (matrix.length == 0) return false;
        else right = matrix[0].length - 1;
        while (top < bottom || left < right) {
            int[] tmp = new int[bottom - top + 1];
            for (int i = top; i <= bottom; i++) tmp[i - top] = matrix[i][left];
            int t = getMaxLess(tmp, target);
            for (int i = top; i <= bottom; i++) tmp[i - top] = matrix[i][right];
            int tt = getMinGreater(tmp, target);
            if (t == -2 || tt == -2) return true;
            if (tt < 0 || t < 0 || tt > t || left == right) return false;
            bottom = top + t; top += tt;
            tmp = new int[right - left + 1];
            for (int i = left; i <= right; i++) tmp[i - left] = matrix[top][i];
            t = getMaxLess(tmp, target);
            for (int i = left; i <= right; i++) tmp[i - left] = matrix[bottom][i];
            tt = getMinGreater(tmp, target);
            if (t == -2 || tt == -2) return true;
            if (tt < 0 || t < 0 || tt > t || top == bottom) return false;
            right = left + t; left += tt;
        }
        return matrix[top][left] == target;
    }

}
