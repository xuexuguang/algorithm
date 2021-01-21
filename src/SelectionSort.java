import java.util.logging.Logger;

public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * 选择排序
     * 基本思路：
     * 1、从给定的数组中，依次选取出最小的元素
     * 2、将最小的元素和当前的元素进行位置交换
     * <p>
     * 复杂度分析：
     * 1、执行结果：func: selection, n: 10000 , const time:0.123054 s ， func: selection, n: 100000 , const time:11.865340 s
     * 2、当n的规模由10000到100000的时候，增长了十倍，则时间从0.1s变成了11s,大概是100倍，计算得出复杂度为O(n^2) 10
     * <p>
     * 总结：
     * 所谓的复杂度就是说随着数据规模n的扩大，时间复杂度是根据数据规模成n^2的一个变化
     *
     * @param arr 需要进行排序的泛型数组
     * @param <E>
     */
    public static <E extends Comparable<E>> void Sort(E[] arr) {
        // arr[0-i)有序的，arr[i-n)是无序的，循环体做的事情呢，就是维护这个arr[0-n]这样的一个循环不变量
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 循环体：做大小比较，进行交换
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            SortingHelper.swap(arr, i, minIndex);
        }
    }

    /**
     * 选择排序的降序的实现
     *
     * @param arr 泛型数组
     * @param <E> 泛型数组
     */
    public static <E extends Comparable<E>> void SortDesc(E[] arr) {
        // arr[0-i)有序的，arr[i-n)是无序的，循环体做的事情呢，就是维护这个arr[0-n]这样的一个循环不变量
        // 实现arr[0-i)无序的，arr[i-n)是有序的，
        for (int i = arr.length - 1; i > 0; i--) {
            int minIndex = i;
            for (int j = i - 1; j > 0; j--) {
                // 循环体：做大小比较，进行交换
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            SortingHelper.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10, 100};
        for (int n : dataSize) {
            Integer[] data = makeArray.makeRandomArray(n, n);
            SortingHelper.SortTest("SortPostposition", data, n);
        }

        Student[] students = {
                new Student("张三", 19),
                new Student("萧逸", 15),
                new Student("李四", 12)
        };
        SortingHelper.SortTest("selectionSort", students, 11);
    }

}
