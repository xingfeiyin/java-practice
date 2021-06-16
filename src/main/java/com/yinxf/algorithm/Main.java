package com.yinxf.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author yinxf
 * @Date 2021/5/19
 * @Description
 * 给定两个整数数组a和b,要求对于b中的每个数值,找出a中和它距离最小的数（即两数差的绝对值最小）,
 * 如果出现距离相等的情况，输出较小的那个数。最后返回一个长度为b.length的数组来表示答案。
 **/
public class Main {

//    public static void main(String[] args) {
//
//        int[] a = {3,-1,7,6,5,-4,-2,7};
//        int[] b = {0,-9,-2,2,-2};
//        Arrays.sort(a);
//        System.out.println(JSON.toJSONString(a));
//
//        int blength = b.length;
//        for(int i=0;i<blength;i++){
//            int bi = b[i];
//
//            if (bi > a[a.length-1]){
//                System.out.println(a[a.length-1]);
//                continue;
//            }
//            if (bi < a[0]){
//                System.out.println(a[0]);
//                continue;
//            }
//
//            int num = getTarget(bi,a,0,a.length-1);
//            System.out.println(num);
//        }
//
//    }
//
//    private static int getTarget(int bi,int[] a,int low,int hight){
//
//        if( bi> a[hight]||bi < a[low]||low > hight){
//            System.out.println( low +"-"+ hight);
//            int small = a[low-1];
//            int big = a[low];
//            int m = bi - small;
//            int n = big - bi;
//            if (m > n){
//                return big;
//            }else if (m < n){
//                return small;
//            }else {
//                return small;
//            }
//        }
//
//        int middle = (low+hight) / 2 ;
//        int midval = a[middle] ;
//        if(bi > midval){
//            return getTarget(bi,a,middle+1 ,hight);
//        }else if(bi < midval){
//            return getTarget(bi,a,low ,middle-1);
//        }else {
//            return bi;
//        }
//
//    }


    public static void main(String[] args) {

        int[] a = { 3,-1,7,6,5,-4,-2,7};

        int[] b = { 0,-9,-2,2,-2};

        int[] back = minimalDistance(a, b);
        System.out.println("back：");
        for (int num : back)
            System.out.println(num);
    }

    public static int[] minimalDistance(int[] a, int[] b) {

        int[] backArray = new int[b.length];

        Arrays.sort(a);

        for (int j = 0; j < b.length; j++) {
            backArray[j] = findMin(a, b[j]);
        }
        return backArray;
    }

    public static int findMin(int[] a, int target) {

        int length = a.length;
        int low = 0;
        int high = length - 1;

        int middle = 0;

        while (low <= high) {
            middle = (low + high) / 2;
            if (a[middle] > target) {
                high = middle - 1;
            } else if (a[middle] < target) {
                low = middle + 1;
            } else {
                return a[middle];
            }
        }

        if (low >= length) {
            return a[high];
        } else if (high < 0) {
            return a[low];
        } else {
            return (a[low] - target) >= (target - a[high]) ? a[high] : a[low];
        }
    }
}
