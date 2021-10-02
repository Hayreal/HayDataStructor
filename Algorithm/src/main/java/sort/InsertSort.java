package sort;

import service.IArraySort;

import java.util.Arrays;

public class InsertSort implements IArraySort {
    public InsertSort() {
    }

    @Override
    public int[] sort(int[] originArr) {

        int[] arr = Arrays.copyOf(originArr, originArr.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }



        return arr;
    }
}
