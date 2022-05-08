package com.ljx.suanfa;

/**
 * @author Lin
 * 2022/5/4  19:08
 */
public class BubbleSortTest {
    public static void main(String[] args) {

        int[] arr = new int[]{43,32,76,-98,99,0,64,33,-21,32};
        System.out.println("排序之前：\n"+java.util.Arrays.toString(arr));
        System.out.println("开始排序：");
        //冒泡排序
        for(int i = 0;i < arr.length - 1;i++){

            for(int j = 0;j < arr.length - 1 - i;j++){

                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            System.out.println(java.util.Arrays.toString(arr));
        }
        System.out.println("排序之后：\n"+java.util.Arrays.toString(arr));

//        for(int i = 0;i < arr.length;i++){
//            System.out.print(arr[i] + "\t");
//        }

    }
}

