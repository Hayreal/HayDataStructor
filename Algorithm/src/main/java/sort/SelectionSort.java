package sort;

import service.IArraySort;
import java.util.Arrays;

/**
 * 选择排序
 * 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *
 * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的后面。
 *
 * 3. 重复第二步，直到所有元素均排序完毕
 */
public class SelectionSort implements IArraySort {
    public SelectionSort(){};

    @Override
    public int[] sort(int[] originArr) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(originArr, originArr.length);

        int count = 0;
        for (int i = 0; i < arr.length-1 ; i++) {

            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                    count++;
                }

            }
            if (i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }

        }
        System.out.println("循环次数为"+ count);
        return arr;
    }
}
