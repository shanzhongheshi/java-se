package com.ljx.suanfa;

/**
 * @author Lin
 * 2022/5/4  18:01
 */
/**
 * 冒泡排序 时间复杂度 O(n^2) 空间复杂度O(1)
 */
public class BubbleSort {

    public static void bubbleSort(int[] data) {

        System.out.println("开始排序");
        //获取数组长度
        int arrayLength = data.length;
        //数组从0开始，只要排（总数-1）次
        for (int i = 0; i < arrayLength - 1; i++) {

            boolean flag = false;
            //第一轮会把最大的数推到最左边
            //第二轮会把第二大的数推到次左边
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if(data[j] > data[j + 1]){
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    flag = true;
                }
            }

            System.out.println(java.util.Arrays.toString(data));

            if (!flag)
                break;
        }
    }

    public static void main(String[] args) {

        int[] data = { 50,40,9, -16, 30, 30 , 21, 23, -30, -49, 21};

        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));

        bubbleSort(data);

        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
