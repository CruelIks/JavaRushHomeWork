package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> poor = new ArrayList<Human>();
        Human ch1 = new Human("Вася", true, 15, poor);
        Human ch2 = new Human("Петя", true, 10, poor);
        Human ch3 = new Human("Даша", false, 12, poor);
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());

        ArrayList<Human> children = new ArrayList<Human>();
        children.add(ch1);
        children.add(ch2);
        children.add(ch3);

        Human father = new Human("Кирилл", true, 33, children);
        Human mother = new Human("Мария", false, 33, children);
        System.out.println(father.toString());
        System.out.println(mother.toString());

        ArrayList<Human> parents = new ArrayList<Human>();
        parents.add(father);
        parents.add(mother);

        Human gf1 = new Human("Федор", true, 65, parents);
        Human gf2 = new Human("Сергей", true, 63, parents);
        Human gm1 = new Human("Галя", false, 60, parents);
        Human gm2 = new Human("Лариса", false, 55, parents);

        System.out.println(gf1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }

        public Human()
        {}

        public Human(String n, boolean s, int a, ArrayList<Human> ch)
        {
            this.name = n;
            this.sex = s;
            this.age = a;
            this.children = ch;

        }
    }

}
