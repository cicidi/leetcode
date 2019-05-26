package algorithm.binary_search;

public class MergeSort {


    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        mergeSort(actual, 6);
        for (int i = 0; i < 6; i++) {
            println(actual[i]);
        }
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void mergeSort(int[] A, int length) {
        if (length < 2) return;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        setValue(A, left, 0, mid);
        setValue(A, right, mid, length);
        mergeSort(left, mid);
        mergeSort(right, length - mid);
        merge(A, left, right, mid, length - mid);
    }

    public static void merge(int[] A, int[] left, int[] right, int leftLength, int rightLength) {
        int l = 0, r = 0, index = 0;
        while (l < leftLength && r < rightLength) {
            if (left[l] <= right[r]) {
                A[index++] = left[l++];
            } else {
                A[index++] = right[r++];
            }
        }
        while (l < leftLength) {
            A[index++] = left[l++];
        }
        while (r < rightLength) {
            A[index++] = right[r++];
        }
    }

    public static void setValue(int[] A, int[] B, int start, int end) {
        for (int i = start; i < end; i++) {
            B[i - start] = A[i];
        }
    }
}
