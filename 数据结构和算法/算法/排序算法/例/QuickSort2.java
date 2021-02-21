package com.china.hcg.sort;

/**
 * @autor hecaigui
 * @date 2020-8-6
 * @description
 */
public class QuickSort2 {
    public static void intArrayQuickSort(int[] integers,int start,int end){
        //1. 迭代的终止条件。//2.切分有意义，如果大哪有什么意义
        if (start < end) {
            int partion = PARTITION(integers, start, end);
            intArrayQuickSort(integers, start, end - 1);
            intArrayQuickSort(integers, partion + 1, end);
        }
    }
    static int PARTITION(int[] integers,int start,int end){
        int x = start;//选择主元(pivot element)， 围绕它来划分子数组A[p..r]
        for (int i = end;i > start;i--){//从右往左比
            // 为什么要进行这个比较逻辑才能切分出2个左比右小的子数组了，你画个图就一目了然了
            // 2 8 7 1 3 5 6 4
            if (i>x && integers[i] < integers[x]){//当比较坐标大于元坐标时 -》则进行后面条件判断是否交换位置 //当比较值小于元值，则交换
                int tmp = integers[i];
                integers[i] = integers[x];
                integers[x] = tmp;
                x = i;
            }
            else if (i<x && integers[i] > integers[x]){//当比较坐标小于元坐标时 -》则进行后面条件判断是否交换位置 //当比较值大于元值，则交换
                int tmp = integers[i];
                integers[i] = integers[x];
                integers[x] = tmp;
                x = i;
            }
        }
        return x;
    }


    public static void main(String[] args) {
        //int intArray[] = {1,4,2,5};
        //int intArray[] = {2,4,1,5};
        //int intArray[] = {1,2,3,5};
        int intArray[] = {1,2,3,5,3,1,4,2,7,8,0,4,6};
        intArrayQuickSort(intArray,0,intArray.length-1);
        for (int i : intArray){
            System.out.println(i);
        }
    }
}
