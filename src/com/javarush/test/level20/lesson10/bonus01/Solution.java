package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[][] matrix;

    /*public static void main(String args[]) {

        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        int[]result = getNumbers(100000000);
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));

    }*/


    public static int[] getNumbers(int N) {
        int[] result = null;

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        setMatrix(getCountDegree(N));

        for (int i = 1; i < N; i++)
        {

            if (isArmstrong(i))
            {
                /*System.out.print(i + " ");*/
                list.add(i);
                count++;
            }
        }

        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static boolean isArmstrong(int i)
    {
        boolean result = false;
        int razryad = getCountDegree(i);
        int sum = 0;
        int tempI = i;

        for (int j = razryad; j > 0 ; j--)
        {
            int temp = tempI / matrix[10][j - 1];
            sum += matrix[temp][razryad];
            tempI = tempI - temp * matrix[10][j - 1];
        }

        if (sum == i) return true;
        else return false;

    }

    private static void setMatrix(int degree)
    {
        matrix = new int[11][degree + 1];

        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j <= degree ; j++)
            {
                matrix[i][j] = getDegree(i, j);
            }
        }
    }

    private static int getDegree(int i, int j)
    {
        int result = 1;

        for (int k = 1; k <= j; k++)
        {
            result *= i;
        }

        return result;
    }

    public static int getCountDegree(int x){

        int i = 0;
        while (x > 0)
        {
            x = x / 10;
            i++;
        }
        return i;
    }
}
