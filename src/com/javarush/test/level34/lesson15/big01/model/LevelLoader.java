package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prog on 15.09.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public static void main(String[] args)
    {
        new LevelLoader(Paths.get("src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt")).getLevel(1);
    }


    public GameObjects getLevel(int level)
    {

        GameObjects gameObjects;

        /*Set<Wall> wallSet = new HashSet<>();
        wallSet.add(new Wall(200, 200));
        wallSet.add(new Wall(150, 150));
        wallSet.add(new Wall(100, 100));

        Set<Box> boxSet = new HashSet<>();
        boxSet.add(new Box(200, 100));

        Set<Home> homeSet = new HashSet<>();
        homeSet.add(new Home(300, 100));

        Player player = new Player(100, 300);
        gameObjects = new GameObjects(wallSet, boxSet, homeSet, player);*/

        String currentLevel = "Maze: " + level % 60;


        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toString())))
        {

            while(reader.ready()){
                String currentString = reader.readLine();
                if (!currentString.equals(currentLevel))
                {
                    continue;
                }

                reader.readLine();

                //second tech
                String str2 = reader.readLine();
                int xSize = Integer.parseInt(str2.substring(8).trim());
                System.out.println("X position: " + xSize);
                //third
                String str3 = reader.readLine();
                int ySize = Integer.parseInt(str3.substring(8).trim());
                System.out.println("Y position: " + ySize);






        }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return null;
    }
}
