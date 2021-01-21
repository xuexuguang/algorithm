public class InsertSort {
    private InsertSort() {
    }

    /**
     * 在学习前，按照自己的思路实现的插入排序
     * <p>
     * 思考：
     * 1、插入的时候，如何保证后续的数字有序的问题？比如2要插入到0的位置，那么3和4都要进行位置交换
     * 2、复杂度是什么样的？  (n)*(n-1)，复杂度应该是O(n^2)
     *
     * @param data 泛型数组
     * @param <E>  泛型数组
     */
    public static <E extends Comparable<E>> void Sort1(E[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[j + 1].compareTo(data[j]) < 0) {
                    SortingHelper.swap(data, j + 1, j);
                }
            }
        }
    }

    /**
     * 听完讲解后，按照思路又重新实现了一遍
     * <p>
     * 思考：
     * 1、对于程序的循环条件的使用还是不够灵活
     * 2、没有考虑到break的使用
     * <p>
     * 复杂度为：O(n^2) 跟选择排序法一致，与自己考虑的基本一致，代码实现细节上有小的区别
     *
     * @param data 泛型数组
     * @param <E>  泛型数组
     */
    public static <E extends Comparable<E>> void Sort2(E[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (data[j].compareTo(data[j - 1]) >= 0) {
                    break;
                }
                SortingHelper.swap(data, j, j - 1);
            }
        }
    }

    /**
     * 插入排序法的写法上的一个优化
     *
     * @param data 泛型数组
     * @param <E>  泛型数组
     */
    public static <E extends Comparable<E>> void Sort3(E[] data) {
        // 写法的优化：将条件放到了for的条件语句中，来使得代码更加简洁
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >= 1 && data[j].compareTo(data[j - 1]) >= 0; j--) {
                SortingHelper.swap(data, j, j - 1);
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 思路：
     * 1、从i-n的区间内进行遍历
     * 2、找到0-i的区间内，i最小的索引位置进行插入
     * <p>
     * 区别：
     * 1、选择排序 [0-i]是根据整个数组进行排序的结果，选择排序[0-i]根据0-i之间的元素进行排序的结果
     * 2、相同点在于循环不变量都是[0-i]为有序的数组，[i-n]为无序的数组
     *
     * @param data 泛型数组
     * @return 有序的泛型数组
     */
    public static <E extends Comparable<E>> void Sort(E[] data) {
        // 优化思路：将交换操作替换为赋值的操作，并不会解决时间复杂度，只是相对于程序执行的操作更少
        /*for (int i = 1; i < data.length; i++) {
            E n = data[i];
            for (int j = i; j >= 1; j--) {
                if (data[j].compareTo(data[j - 1]) >= 0) {
                    break;
                }
                data[j] = data[j - 1];
                data[j - 1] = n;
            }
        }*/

        for (int i = 1; i < data.length; i++) {
            E n = data[i];
            int j;
            // 如果当前i位置的数字更小，则将所有的数据，进行平移
            // 理解for的循环的时候搞清楚：1、从哪开始循环，2、满足什么条件循环
            for (j = i; j >= 1 && data[j].compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            // 平移完毕之后，将数据插入到指定的位置
            // TODO：这里还需要再理解下为什么是j？
            data[j] = n;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10};
        for (int n : dataSize) {
            Integer[] data = makeArray.makeRandomArray(n, n);
            SortingHelper.SortTest("insertSort", data, n);
        }
    }
}

