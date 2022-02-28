package arr;

import common.Print;
import org.junit.Test;

import java.util.Arrays;

public class Arr {

    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    @Test
    public void moveZeroes() {
        int[] nums = {1, 2, 0, 2, 6, 0, 2, 6, 0, 4};
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            else {
                nums[temp] = nums[i];
                temp++;
            }
        }
        Arrays.fill(nums,temp,nums.length,0);
        Print.printArrInt(nums);

    }
}
