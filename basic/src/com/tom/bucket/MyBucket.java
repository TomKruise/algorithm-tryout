package com.tom.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyBucket {
    public static void main(String []args){
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = bucketSort(3,a);
        for(int i : b){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static int[] bucketSort(int bucketNum, int[] arr) {
        int min = arr[0];
        int max = min;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (min > num) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        int bucketLength = (max-min)/bucketNum;

        List<List<Integer>> bucketList = getBucketListByBucketNum(bucketNum);

        put2BucketList(arr, bucketList, bucketLength, min);

        List<Integer> result = getResultFromBucketList(bucketList);

        int[] newArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            newArr[i] = result.get(i);
        }
        return newArr;
    }

    private static List<Integer> getResultFromBucketList(List<List<Integer>> bucketList) {
        List<Integer> result = new LinkedList<>();

        for (List<Integer> integers : bucketList) {
            if (!integers.isEmpty()) {
                Collections.sort(integers);
                for (Integer integer : integers) {
                    result.add(integer);
                }
            }
        }

        return result;
    }

    private static void put2BucketList(int[] arr, List<List<Integer>> bucketList, int bucketLength, int min) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            putEachNum2SpecificBucket(num,bucketList,bucketLength,min);
        }
    }

    private static void putEachNum2SpecificBucket(int num, List<List<Integer>> bucketList, int bucketLength, int min) {
        int index = (num - min) / bucketLength;

        if (index == bucketList.size()) {
            index-=1;
        }

        List<Integer> bucket = bucketList.get(index);

        bucket.add(num);
    }

    private static List<List<Integer>> getBucketListByBucketNum(int bucketNum) {
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        return bucketList;
    }
}
