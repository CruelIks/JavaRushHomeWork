package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution() {}
    private Solution(int obj) {}
    protected Solution(Integer obj) {}

    public Solution(double obj) {}
    private Solution(Double obj) {}
    protected Solution(float obj) {}

    public Solution(Float obj) {}
    private Solution(char obj) {}
    protected Solution(Character obj) {}

    Solution(int x, int y) {}
    Solution(String x, String y) {}
    Solution(Double x, Double y) {}
}

