package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream oos) throws IOException
        {
            throw new NotSerializableException("Not serializable class");
        }

        private void readObject(ObjectInputStream ois) throws IOException
        {
            throw new NotSerializableException("Not serializable class");
        }
    }
}
