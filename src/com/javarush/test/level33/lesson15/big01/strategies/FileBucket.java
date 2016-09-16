package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Prog on 08.08.2016.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {

        try
        {
            path = Files.createTempFile("tmp", null);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }

        path.toFile().deleteOnExit();

    }

    public long getFileSize()
    {
        return path.toFile().length();
    }

    public void putEntry(Entry entry)
    {

        try
        {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            /*Entry tmpEntry = entry;
            while (tmpEntry != null)
            {
                oos.writeObject(tmpEntry);
                tmpEntry = entry.next;
            }*/
            oos.writeObject(entry);

            fos.close();
            oos.close();


        }
        catch (FileNotFoundException e)
        {
            ExceptionHandler.log(e);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }


    }

    public Entry getEntry()
    {
        if (getFileSize() == 0) return null;
        Entry result = null;

        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(path.toFile()));
            result = (Entry) input.readObject();

            input.close();

        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (ClassNotFoundException e)
        {
            ExceptionHandler.log(e);
        }

        return result;
    }

    public void remove()
    {
        path.toFile().delete();
    }
}
