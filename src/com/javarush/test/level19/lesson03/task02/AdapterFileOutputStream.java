package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{

    private FileOutputStream outputStream;

    public AdapterFileOutputStream(FileOutputStream out)
    {
        outputStream = out;
    }


    @Override
    public void flush() throws IOException
    {
        outputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] b = s.getBytes();
        outputStream.write(b);
    }

    @Override
    public void close() throws IOException
    {
        outputStream.close();
    }
}

