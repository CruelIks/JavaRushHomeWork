package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> result = new HashSet<Cat>();

        result.add(new Cat());
        result.add(new Cat("Барсик"));
        result.add(new Cat("Васька"));
        result.add(new Cat("Вшивый"));

        return result;
    }

    public static Set<Dog> createDogs()
    {
        Set<Dog> result = new HashSet<Dog>();
        result.add(new Dog("Алый"));
        result.add(new Dog("Злой"));
        result.add(new Dog("Бодрый"));

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> pets = new HashSet<Object>();

        pets.addAll(cats);
        pets.addAll(dogs);

        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        pets.removeAll(cats);

    }

    public static void printPets(Set<Object> pets)
    {
        for (Object pet : pets)
        {
            System.out.println(pet.toString());
        }
    }

    public static class Cat
    {
        private String name;

        public Cat()
        {
            name = "noname";
        }

        public Cat(String catName)
        {
            name = catName;
        }
    }

    public static class Dog
    {
        private String name;

        public Dog()
        {
            name = "noname";
        }

        public Dog(String dogName)
        {
            name = dogName;
        }

    }

}
