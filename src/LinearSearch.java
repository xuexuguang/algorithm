public class LinearSearch {
    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        int index1 = LinearSearch.search(data, 2);
        System.out.println(index1);

        Student[] students = {
                new Student("xiaoyi",1),
                new Student("zhangsan",1),
                new Student("lisi",1),
        };

        Student zhangsan = new Student("zhangsan",1);
        int index2 = LinearSearch.search(students, zhangsan);
        System.out.println(index2);
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
