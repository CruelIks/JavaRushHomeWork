package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private int age, height;
        private Human father, mother;
        private boolean sex;

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human()
        {

        }

        public Human(String name, int age, Human father)
        {
            this.name = name;
            this.age = age;
            this.father = father;
        }

        public Human(String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Human(String name, int age, int height, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }

        public Human(String name, int age, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, int height, boolean sex, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.father = father;
            this.mother = mother;
            this.height = height;
            this.sex = sex;
        }

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(String name,boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(boolean sex, Human father, Human mother)
        {
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, Human father, Human mother)
        {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }
    }
}
