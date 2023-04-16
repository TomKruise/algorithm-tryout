package com.tom.counting;

public class MyCount {

    public static void main(String []args){
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = countingSort(a);
        for(int i : b){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static int[] countingSort(int[] arr) {
        int [] answer = arr;
        if (null != arr && arr.length > 1) {
            int min = arr[0];
            int max = arr[0];

            for (int i = 0; i < arr.length; i++) {
                min = findMin(min,arr[i]);
                max = findMax(max,arr[i]);
            }

            int[] countingArr = constructCountingArr(min,max,arr);

            answer = createArrByCountingArr(arr.length, countingArr, min);
        }
        return answer;
    }

    private static int[] createArrByCountingArr(int length, int[] countingArr, int min) {
        int [] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int value = getValueFromCountingArr(countingArr, min);
            answer[i] = value;
        }
        return answer;
    }

    private static int getValueFromCountingArr(int[] countingArr, int min) {
        for (int i = 0; i < countingArr.length; i++) {
            if (countingArr[i] == 0) {
                continue;
            }
            int answer = i+min;
            countingArr[i] = --countingArr[i];
            return answer;
        }

        //never be useful
        return 0;
    }

    private static int[] constructCountingArr(int min, int max, int[] arr) {
        int newArrLength = max - min + 1;
        int[] countingArr = new int[newArrLength];

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            int countingIndex = value - min;

            int countingArrValue = countingArr[countingIndex];

            countingArr[countingIndex] = ++countingArrValue;
        }

        return countingArr;
    }

    private static int findMax(int a, int b) {
        return a > b ? a : b;
    }

    private static int findMin(int a, int b) {
        return a < b ? a : b;
    }
}
