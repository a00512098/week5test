package com.example.week5test;

//1. Sort the array with multiple same values in the array in an ascending order.
//
//        Input: {2,8,9,3,4,3,2,6,6,2,4,9,8}
//
//        Output: {2,2,2,3,3,4,4,6,6,8,8,9,9}


public class Problem1 {

    private static int[] orignalArray;

    // The aux array is used to perform operations and then pass the
    private static int[] auxArray;

    public static void sort(int[] array) {
        orignalArray = array;
        auxArray = new int[array.length];
        mergeSort(0, array.length - 1);
    }

    private static void mergeSort(int left, int right) {
        if (left == right)
            return;

        int pivot = left + (right - left) / 2;
        mergeSort(left, pivot);
        mergeSort(pivot + 1, right);
        mergeArrays(left, pivot, right);
    }

    private static void mergeArrays(int left, int pivot, int right) {
        for (int i = left; i <= right; i++) {
            auxArray[i] = orignalArray[i];
        }

        int i = left;
        int j = pivot + 1;
        int k = left;
        while (i <= pivot && j <= right) {
            if (auxArray[i] <= auxArray[j]) {
                orignalArray[k] = auxArray[i];
                i++;
            } else {
                orignalArray[k] = auxArray[j];
                j++;
            }
            k++;
        }
        while (i <= pivot) {
            orignalArray[k] = auxArray[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] array = {25,14,39,4,3,42,21,10,100,11,9};
        System.out.print("Input:  ");
        printArray(array);
        sort(array);
        System.out.print("Output: ");
        printArray(array);
    }

    private static void printArray(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i);
            builder.append(',');
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("\n");
        System.out.print(builder.toString());
    }
}
