package com.javarush.test.level16.lesson13.bonus02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new myThread1());
        threads.add(new myThread2());
        threads.add(new myThread3());
        threads.add(new myThread4());
        threads.add(new myThread5());

    }

    public static void main(String[] args)
    {
        Thread thread5 = threads.get(4);
        thread5.start();

    }

    public static class myThread1 extends Thread{
        @Override
        public void run()
        {
            while(true);
        }
    }

    public static class myThread2 extends Thread{

        @Override
        public void run()
        {
            try{
                while (!isInterrupted())
                {

                }
                throw new InterruptedException();
            }catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class myThread3 extends Thread{
        @Override
        public void run()
        {
            try{

                while (true)
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public static class myThread4 extends Thread implements Message{

        private boolean isWarning = false;
        @Override
        public void showWarning()
        {
            isWarning = true;
        }

        @Override
        public void run()
        {
            while(!isWarning) {}

        }
    }

    public static class myThread5 extends Thread {
        @Override
        public void run()
        {
            int result = 0;
            Scanner scanner = new Scanner(System.in);
            String line;

            while (true){

                line = scanner.nextLine();
                if (line.equals("N")) break;

                try
                {
                    result += Integer.parseInt(line);
                }
                catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }

            }

            System.out.println(result);
        }
    }

}
