package com.ljx.array;

import org.junit.Test;

/**
 * @author Lin
 * 2022/5/4  19:47
 */
public class SearchTest {
    @Test
    //作用：线性查找
    public void test1(){
        String[] arr = {"AA", "CC", "DD", "BB"};
        String dest = "BB";
        boolean isFlag = true;
        for (int i = 0; i < arr.length; i++) {
            if (dest.equals(arr[i])) {
                System.out.println("找到了指定元素，位置为"+i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("很遗憾，没有找到");
        }
    }

    @Test
    //作用：二分法查找
    //前提：所以查找的数组必须有序
    public void test2(){
        int[] arr = {-100, -90, -70, -60, 0, 45, 67, 79, 99};
        int dest = 40;
        boolean isFlag = true;
        int head = 0; //初始的首索引
        int end = arr.length - 1; //初始的末索引
        while (head <= end) {
            int middle = (head + end) / 2;
            if (dest == arr[middle]) {
                System.out.println("找到了指定元素，位置为"+middle);
                isFlag = false;
                break;
            } else if (dest < arr[middle]) {
                end = middle - 1;
            } else {
                head = middle + 1;
            }
        }
        if (isFlag) {
            System.out.println("很遗憾，没有找到");
        }
    }
}
