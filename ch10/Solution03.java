package ch10;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution03 {

    // Assume that all elements in the array are distinct.

    // Satisfied to both ascending and descending order.

    int binarySearch(int A[], int l, int r, int tar) {
        while (l < r) {
            int m = (l + r) >> 1;
            if (A[l] <= A[r]) {
                if (A[m] < tar) l = m + 1;
                else r = m;
            } else {
                if (A[m] > tar) l = m + 1;
                else r = m;
            }
        }
        if (l > r || A[l] != tar) return -1;
        return l;
    }

    public int search(int[] A, int l, int r, int target) {
        int m = l + r >> 1;
        int maxV = Math.max(A[l], A[r - 1]), minV = Math.min(A[l], A[r - 1]);
        if (A[m] > maxV) {
            if (target <= A[m] && target >= maxV) {
                if (A[l] > A[r - 1]) return search(A, l, m + 1, target);
                return search(A, m, r, target);
            } else {
                if (A[l] > A[r - 1]) return search(A, m, r, target);
                return search(A, l, m + 1, target);
            }
        } else if (A[m] < minV) {
            if (target >= A[m] && target <= minV) {
                if (A[l] < A[r - 1]) return search(A, l, m + 1, target);
                return search(A, m, r, target);
            } else {
                if (A[l] < A[r - 1]) return search(A, m, r, target);
                return search(A, l, m + 1, target);
            }
        } else return binarySearch(A, l, r - 1, target);
    }

    public int searchInRotatedArray(int[] A, int tar) {
        return search(A, 0, A.length, tar);
    }

}
