package com.handwrite.sort;

import java.util.jar.JarEntry;

/**
 * 稳定
 * 选择排序：在待排序的数组中选择最大或者最小的
 *          元素放在数组头部或者尾部
 * 时间复杂度：
 *      最好：0（n^2）
 *      最坏：0（n^2）
 *      平均：0（n^2）
 * 空间复杂度：O（1）
 */
public class SelectSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length==0){
            return;
        }

        for (int i = 0;i<arr.length;i++){
            //0-(i-1)是有序的

            int minIndex = i;

            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }


            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int m = 0;m<arr.length;m++){
            System.out.print(arr[m]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,6,1,7,5,8,9,4,10};
        SelectSort.sort(array);
    }
}
