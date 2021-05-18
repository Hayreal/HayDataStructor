package com.hayreal.hayArray.sparseArray;

/**
 * @author hayreal
 */
public class TransToArray {

    public static void main(String[] args) {
        //1、创建一个原始的二位数组
        int[][] chessArr = new  int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] =2;
        //2、遍历输出这个数组
        for (int[] chars : chessArr) {
            for (int i : chars) {
                System.out.printf("%d\t",i);
            }
        //打印完第一列就换行
            System.out.println();
        }
    }
}
