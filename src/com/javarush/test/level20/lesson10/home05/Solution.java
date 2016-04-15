package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution implements Serializable {

    public static void main(String args[])
    {
        Person person = new Person("John", "Rembo", "Usa", Sex.MALE);

        try
        {
            FileOutputStream out = new FileOutputStream("1");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(person);
            oos.close();
            out.close();

            FileInputStream in = new FileInputStream("1");
            ObjectInputStream ois = new ObjectInputStream(in);
            Person newPerson = (Person) ois.readObject();
            ois.close();
            in.close();

            System.out.println(newPerson.firstName);
            System.out.println(newPerson.lastName);
            System.out.println(newPerson.fullName);
            System.out.println(newPerson.greetingString);
            System.out.println(newPerson.country);
            System.out.println(newPerson.sex);



        }
        catch (IOException e) {e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}

    }
    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person() {
            this.greetingString = "Hello, ";
        }
        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex implements Serializable{
        MALE,
        FEMALE
    }
}
