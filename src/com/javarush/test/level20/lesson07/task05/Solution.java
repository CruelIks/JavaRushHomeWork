package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public static void main(String args[])
    {
        Solution sol = new Solution(50);
        Solution sol2 = new Solution();

        try
        {
            FileOutputStream out = new FileOutputStream("1");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            sol.writeObject(oos);

            oos.close();
            out.close();

            FileInputStream in = new FileInputStream("1");
            ObjectInputStream ois = new ObjectInputStream(in);

            sol.readObject(ois);

            ois.close();
            in.close();

        }
        catch(IOException e) {e.printStackTrace();}
        catch(ClassNotFoundException e) {e.printStackTrace();}

    }

    public Solution() {}

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        System.out.println("do something in thread");

    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }
}
