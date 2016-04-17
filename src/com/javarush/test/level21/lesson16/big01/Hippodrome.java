package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 26.03.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String args[])
    {

        game = new Hippodrome();

        game.getHorses().add(new Horse("horse1", 3, 0));
        game.getHorses().add(new Horse("horse2", 3, 0));
        game.getHorses().add(new Horse("horse3", 3, 0));

        game.run();
        game.printWinner();

    }

    public void run()
    {

        for (int i = 0; i < 100; i++)
        {
            move();
            print();

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


    public void move()
    {

        for (Horse horse : getHorses())
        {
            horse.move();
        }

    }

    public void print()
    {

        for (Horse horse : getHorses())
        {
            horse.print();
        }

        System.out.println("");
        System.out.println("");
    }

    public Horse getWinner() {

        double maxDistance = 0;
        Horse winner = null;

        for (Horse horse : getHorses())
        {
            if (horse.getDistance() > maxDistance)
            {
                maxDistance = horse.getDistance();
                winner = horse;
            }

        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
