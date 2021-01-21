public class SortingHelper {
    private SortingHelper() {
    }

    /**
     * 检查给定的数组是否是一个有序的数组
     * 主要是通过检查相邻的两个元素的大小，来判定是否为有序的数组
     *
     * @param arr 泛型数组
     * @param <E> 泛型数组
     * @return bool 有序则返回true，否则返回false
     */
    public static <E extends Comparable<E>> boolean IsSorted(E[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int maxIndex = length - 1;
            // 当前索引已经超出范围，认为已经扫描完毕了
            if (i >= maxIndex) {
                return true;
            }

            // i如果小于i+1，则返回<0 ,等于返回0，大于返回1
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static <E extends Comparable<E>> void SortTest(String funcName, E[] data, int n) {
        long start = System.nanoTime();
        if ("selectionSort".equals(funcName)) {
            SelectionSort.Sort(data);
        } else if ("selectionSortDesc".equals(funcName)) {
            SelectionSort.SortDesc(data);
        } else if ("insertSort".equals(funcName)) {
            InsertSort.Sort(data);
        } else {
            throw new RuntimeException(funcName + "is not exists");
        }

        long end = System.nanoTime();
        double constTime = (end - start) / 1000000000.0;
        if (!IsSorted(data)) {
            throw new RuntimeException(funcName + "is not sorted data,test failed!");
        }

        System.out.println(String.format("func: %s, n: %d , const time:%f s", funcName, n, constTime));

        if (n<50) {
            System.out.println("sorted data:\n");
            for (E i : data){
                System.out.println(String.format("%d", i));
            }
        }
    }

}
