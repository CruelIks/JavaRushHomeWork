package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {

    public static void main(String args[])
    {

        Person mother = new Person("Mom", "Mommy", 50);
        Person dad = new Person("Dad", "Daddy", 49);
        Person son = new Person("Son", "Goodson", 20);
        son.setMother(mother);
        son.setFather(dad);
        List<Person> list = new ArrayList<Person>();
        list.add(son);
        mother.setChildren(list);
        dad.setChildren(list);

        try
        {
            FileOutputStream out = new FileOutputStream("1");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            son.writeExternal(oos);
            oos.close();
            out.close();

            FileInputStream in = new FileInputStream("1");
            ObjectInputStream iis = new ObjectInputStream(in);

            Person son2 = new Person();
            son2.readExternal(iis);

            System.out.println(son2.getFirstName() + " " + son2.getLastName() + " " + son2.getAge());
            in.close();
            iis.close();

        }
        catch (IOException e) {e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}


    }


    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person()
        {}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public int getAge()
        {
            return age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }
}
