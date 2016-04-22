package com.javarush.test.level26.lesson02.task01;


import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        final double median;
        if (array.length % 2 == 0){
            median = (array[(array.length / 2)] + array[(array.length / 2 - 1)]) / 2;
        }
        else
        {
            median = array[array.length / 2];
        }

        /*System.out.println("median: " + median);*/

        Comparator<Integer> myComparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double o11 = Math.abs(o1 - median);
                double o22 = Math.abs(o2 - median);

                if (o11 > o22) return 1;
                else if (o11 < o22) return -1;
                else return o1.compareTo(o2);
            }
        };

        Arrays.sort(array, myComparator);

        /*for (Integer i : array){
            System.out.print(i + " ");
        }*/


        return array;
    }

    public static void main(String args[]){

        Integer[] array = {3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92, 94};
        sort(array);
    }
}
