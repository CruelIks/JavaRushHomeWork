package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] array = new Solution[2];
        Solution a1 = new Solution();
        a1.innerClasses[0] = a1.new InnerClass();
        a1.innerClasses[1] = a1.new InnerClass();

        Solution a2 = new Solution();
        a2.innerClasses[0] = a2.new InnerClass();
        a2.innerClasses[1] = a2.new InnerClass();

        array[0] = a1;
        array[1] = a2;

        return array;
    }
}
