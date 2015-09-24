package ch10;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution01 {

    public void sortedMerge(int[] A, int[] B) {
        int sizeB = B.length - 1, sizeA = A.length -B.length - 1, pos = A.length - 1;
        while (sizeB >= 0) {
            if (sizeA < 0 || B[sizeB] > A[sizeA]) A[pos--] = B[sizeB--];
            else A[pos--] = A[sizeA--];
        }
    }

    // another algorithm, complex but still O(m+n) time complexity
    public void sortedMerge1(int[] A, int[] B) {
        int sizeB = B.length, sizeA = A.length - B.length;
        if (sizeB == 0) return;
        System.arraycopy(B, 0, A, sizeA, sizeB);
        int pos = 0;
        while (pos < sizeA && A[pos] < A[sizeA]) pos++;
        int head = 0, tail = -1;
        for (; pos < sizeA; pos++) {
            int tmp = A[pos];
            if (tail < 0 || (sizeA < A.length && A[sizeA] < B[head])) {
                A[pos] = A[sizeA];
                A[sizeA++] = 0x7FFFFFFF;
            } else {
                A[pos] = B[head];
                head = (head + 1) % sizeB;
            }
            tail = (tail + 1) % sizeB;
            B[tail] = tmp;
        }
    }

    public void run() {
        int[] A = {1, 7, 9, 11, 13, 15, 0, 0, 0, 0, 0, 0, 0}, B = {2, 4, 6, 8, 10, 12, 100};
        sortedMerge(A, B);
        for (int i = 0; i < 13; i++) System.out.print(A[i] + " ");
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        solution.run();
    }

}
