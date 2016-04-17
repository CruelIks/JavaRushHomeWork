package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        result = result.replace('\n', ' ');
        result = result.replace('\r', ' ').trim();

        String left = result.substring(0, result.indexOf('='));
        int mathResult = 0;

        if (left.indexOf('-') > -1)
        {
            mathResult = Integer.parseInt(left.substring(0, left.indexOf('-')).trim()) - Integer.parseInt(left.substring(left.indexOf('-') + 1).trim());
        }
        else if (left.indexOf('+') > -1)
        {
            mathResult = Integer.parseInt(left.substring(0, left.indexOf('+')).trim()) + Integer.parseInt(left.substring(left.indexOf('+') + 1).trim());
        }
        else if (left.indexOf('*') > -1)
        {
            mathResult = Integer.parseInt(left.substring(0, left.indexOf('*')).trim()) * Integer.parseInt(left.substring(left.indexOf('*') + 1).trim());
        }

        System.setOut(console);
        System.out.print(result + " " + String.valueOf(mathResult));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

