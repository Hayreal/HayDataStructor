package sort;

import service.IArraySort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 1. 第一个循环表示循环次数
 * 2. 第二个表示真正冒泡排序次数
 */
public class BubbleSort implements IArraySort {
    public BubbleSort() {
    }
    @Override
    public int[] sort(int[] sourceArray)  {
        // 对 arr 进行拷贝，不改变参数内容
        int count = 0;
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    count ++;
                }
            }
        }
        System.out.println("循环次数为"+ count);
        return arr;
    }
}
