package com.handwrite.sort;

import com.sun.javafx.collections.SortHelper;

/**
 *归并排序：适用于数组长度很长的时候
 *  思想：分治法
 *  1、将子数组变为有序，再讲子数组间设为有序
 *  2、将有有序的数组进行合并
 */

public class MergeSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length<=1){
            return;
        }

        int[] temp = new int[arr.length];
        sortHelper(arr,0,arr.length-1,temp);

        for (int m = 0;m<arr.length;m++){
            System.out.print(arr[m]+" ");
        }
    }

    public static void sortHelper(int[] arr,int start,int end,int[] temp){
        if (start>=end){return;}

        int mid = (start+end)/2;

        sortHelper(arr,start,mid,temp);
        sortHelper(arr,mid+1,end,temp);
        
        merge(arr,start,mid,mid+1,end,temp);
    }

    private static void merge(int[] arr, int s1, int e1, int s2, int e2, int[] temp) {
        int i=s1,j=s2,k=0;
        while (i<=e1&&j<=e2){
            //当第一个数组首位比第二个数组首位小的时候
            if (arr[i]<=arr[j]){
                //将小的那个数丢到合并的数组中，再次往前走
                temp[k++] = arr[i];
                i++;
            }else {
                temp[k++] = arr[j];
                j++;
            }
        }

        //当第一个数组长度比第二个数组长度小的时候
        while (i<=e1){
            temp[k++] = arr[i];
            i++;
        }

        //当第一个数组长度比第二个数组长度大的时候
        while (j<=e2){
            temp[k++] = arr[j];
            j++;
        }

        //两个数组都是有序数组的话，temp为临时数组，拷回去
        for (int l = 0;l<k;l++){
            arr[s1+l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,6,1,7,5,8,9,4,10};
        MergeSort.sort(array);
    }
}
