package com.tom.heap;

import java.util.Arrays;

public class MyHeap {
    private int[] arr;

    public MyHeap(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        if (null != arr && arr.length > 1) {
            int len = arr.length - 1;
            while (len > 0) {
                maxHeapify(arr, len);

                swapNode(0,len,arr);
                len--;
            }

        }
    }

    private void maxHeapify(int[] arr, int len) {
        for (int i = 0; i <= len; i++) {
            int head = (len-i-1)/2;
            int left = (head<<1) + 1;
            int right = left + 1;

            if (left <= len) {
                if (arr[left] > arr[head]) {
                    swapNode(left,head,arr);
                }
            }

            if (right <= len) {
                if (arr[right] > arr[head]) {
                    swapNode(right,head,arr);
                }
            }
        }
    }

    private void swapNode(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 测试用例
     * <p>
     * 输出：
     * [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new MyHeap(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}
