package com.handwrite.sort;

/**
 * 稳定
 * 插入排序：将数据插入到已排序好的数组中
 * 时间复杂度：
 *      最好：0（n）
 *      最坏：0（n^2）
 *      平均：0（n^2）
 * 空间复杂度：O（1）
 */

public class InsertSort {
    public static void sort(int[] arr){

        if (arr == null || arr.length==0){
            return;
        }

        for (int i = 0;i<arr.length;i++){
            //0-(i-1)是有序的

            int data = arr[i];
            int j = i-1;

            while (j>=0 && data<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = data;
        }

        for (int m = 0;m<arr.length;m++){
            System.out.print(arr[m]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,6,1,7,5,8,9,4,10};
        InsertSort.sort(array);
    }
}
