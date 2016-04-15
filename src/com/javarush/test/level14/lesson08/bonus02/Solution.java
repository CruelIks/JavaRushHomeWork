package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a, b, min, nod = 1;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        min = a < b ? a : b;

        for (int i = 1; i <= min; i++)
        {
            if (a % i == 0 & b % i == 0) nod = i;
        }

        System.out.println(nod);
    }
}
