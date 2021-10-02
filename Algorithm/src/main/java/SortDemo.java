import org.junit.Test;
import sort.BubbleSort;
import sort.InsertSort;
import sort.SelectionSort;
import utils.Print;


public class SortDemo {

    public static final int[] originArr = {4,9,5,8,2,1,0,6,7,3};

    @Test
    public void testBubbleSort(){
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = bubbleSort.sort(originArr);
        Print.printArr(arr);
    }

    @Test
    public void testSelectionSort(){
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = selectionSort.sort(originArr);
        Print.printArr(arr);
    }

    @Test
    public void testInsertSort(){
        InsertSort insertSort = new InsertSort();
        int[] arr = insertSort.sort(originArr);
        Print.printArr(arr);
    }
}
