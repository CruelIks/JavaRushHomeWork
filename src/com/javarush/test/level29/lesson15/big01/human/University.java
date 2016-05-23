package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University
{

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade)
    {
        //TODO:
        for (Student student : students){
            if (student.getAverageGrade() == averageGrade){
                return student;
            }
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade()
    {
        Student result = null;
        double max = 0;

        for (Student student : students){

            if (student.getAverageGrade() > max){
                max = student.getAverageGrade();
                result = student;
            }
        }
        return result;
    }

    public void getStudentWithMinAverageGradeAndExpel()
    {
        //TODO:
        expel(getStudentWithMinAverageGrade());
    }

    public Student getStudentWithMinAverageGrade() {

        if (students.size() == 0) return null;

        Student result = students.get(0);
        double min = students.get(0).getAverageGrade();

        for (Student student : students){
            if (student.getAverageGrade() < min){
                min = student.getAverageGrade();
                result = student;
            }
        }

        return result;
    }

    public void expel(Student student){
        if (student == null) return;
        if (!students.contains(student)) return;

        students.remove(student);
    }
}
