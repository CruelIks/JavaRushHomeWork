package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 22.05.2016.
 */
public class TestHuman
{
    public static void main(String args[]){

        University nngu = new University("NNGU", 20);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivanov", 20, 4.6));
        students.add(new Student("Petrov", 21, 4.3));
        students.add(new Student("Sidorov", 22, 4.0));

        nngu.setStudents(students);

        System.out.println(nngu.getStudentWithMaxAverageGrade().getName() + " has max grade");
        System.out.println(nngu.getStudentWithMinAverageGrade().getName() + " has min grade");

    }
}
