import java.util.Random;

public class makeArray {
    private makeArray() {
    }

    public static Integer[] makeOrderedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }

        return data;
    }

    public static Integer[] makeRandomArray(int n, int bound) {
        Integer[] data = new Integer[n];
        Random rdm = new Random();
        for (int i = 0; i < n; i++) {
            // 指定随机数最大值
            data[i] = rdm.nextInt(bound);
        }

        return data;
    }
}
