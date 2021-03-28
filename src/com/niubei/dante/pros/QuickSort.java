package com.niubei.dante.pros;

import java.util.HashMap;
import java.util.Map;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println("排序后:");
//        for (int i : arr) {
//            System.out.println(i);
//        }
        Map<Long,Integer>  map = new HashMap<>();
        map.put(null,123);
    }

    void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = tmp;
        return low;
    }
}
