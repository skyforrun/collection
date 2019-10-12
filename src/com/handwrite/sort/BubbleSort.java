package com.handwrite.sort;

/**
 * 稳定
 * 冒泡排序
 * 时间复杂度：
 *      最好：O（n）
 *      最差：0（n^2）
 *      平均：0（n^2）
 * 空间复杂度：O（1）
 */

public class BubbleSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length==0){
            return;
        }

        for(int i =0;i<arr.length;i++) {

            /**
             * 交换标志
             */
            boolean flag = false;

            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    flag = true;
                }
            }

            if (!flag){
                return;
            }
        }

        for (int m = 0;m<arr.length;m++){
            System.out.print(arr[m]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,6,1,7,5,8,9,4,10};
        BubbleSort.sort(array);
    }
}
