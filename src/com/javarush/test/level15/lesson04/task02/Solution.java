package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printmatrix(Object m, int n, String value) {}
    public static void printmatrix(int m, Object n, String value) {}
    public static void printmatrix(Object m, Object n, String value) {}
    public static void printmatrix(int m, Object n, Object value) {}
    public static void printmatrix(Object m, Object n, Object value) {}
    public static void printmatrix(Integer m, Object n, Object value) {}
    public static void printmatrix(Object m, Integer n, Object value) {}
    public static void printmatrix(Integer m, Integer n, String value) {}

}
