package ua.zp.brain.labs.oop.basics.lab18;

public class ArrayExceptionTest {
    public static void main(String[] args) {
        int[] arrInt = {0, 1, 2, 3, 4, 5, 6, 7};

        printArray(arrInt, 0, 3);
        printArray(arrInt, -1, 5);
        printArray(arrInt, 0, 7);
        printArray(arrInt, 5, 8);

    }

    public static void printArray(int[] array, int start, int end) {

        for (int i = start; i <= end; i++) {
            try {
                System.out.println(array[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.printf("Ошибка. Попытка обращения к несуществующему "
                        + "индексу: текущий индекс = %d; размер массива = %d;\n", i, array.length);
            }
        }
    }
}
