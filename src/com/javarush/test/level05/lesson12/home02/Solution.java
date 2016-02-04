package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Василий", 19, "Ленина 49-21");
        Man man2 = new Man("Денис", 21, "Революции 32-14");
        Woman w1 = new Woman("Мария", 19, "Ленина 49-21");
        Woman w2 = new Woman("Елена", 19, "Ленина 49-21");

        System.out.println("" + man1.name + " " + man1.age + " " + man1.address);
        System.out.println("" + man2.name + " " + man2.age + " " + man2.address);
        System.out.println("" + w1.name + " " + w1.age + " " + w1.address);
        System.out.println("" + w2.name + " " + w2.age + " " + w2.address);

    }

    public static class Man
    {
        private String name, address;
        private int age;

        private Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman
    {
        private String name, address;
        private int age;

        private Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
}
