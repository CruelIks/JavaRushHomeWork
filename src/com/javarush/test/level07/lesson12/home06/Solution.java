package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human gf = new Human("дед Василий", true, 90, null, null);
        Human gm = new Human("бабка Матрена", false, 90, null, null);
        Human gf2 = new Human("дед Семен", true, 90, null, null);
        Human gm2 = new Human("бабка Дуня", false, 90, null, null);

        Human father = new Human("отец Николай", true, 50, gf, gm);
        Human mother = new Human("мать Мария", false, 50, gf2, gm2);

        Human ch1 = new Human("Игорь", true, 2, father, mother);
        Human ch2 = new Human("Катя", true, 10, father, mother);
        Human ch3 = new Human("Аня", true, 21, father, mother);

        System.out.println(gf.toString());
        System.out.println(gm.toString());
        System.out.println(gf2.toString());
        System.out.println(gm2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father, mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

             }

        public Human()
        {}

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
