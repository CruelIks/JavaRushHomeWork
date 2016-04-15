package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Externalizable
{
    public static void main(String[] args)
    {
        Solution savedObject = new Solution(4);
        System.out.println(savedObject);
        Solution loadedObject = new Solution();

        try
        {
            FileOutputStream out = new FileOutputStream("1");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            savedObject.writeExternal(oos);

            oos.close();
            out.close();


            FileInputStream in = new FileInputStream("1");
            ObjectInputStream ois = new ObjectInputStream(in);

            loadedObject.readExternal(ois);

            ois.close();
            in.close();

        }
        catch(IOException e) {e.printStackTrace();}
        catch(ClassNotFoundException e) {e.printStackTrace();}

        System.out.println("saved: " + savedObject.string);
        System.out.println("loaded: " + loadedObject.string);
        System.out.println(loadedObject.toString());

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient  Date currentDate;
    private transient  int temperature;
    String string;

    public Solution()
    {
        this.currentDate = new Date();
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        /*out.writeObject(this.currentDate);*/
        /*out.writeInt(this.temperature);*/
        out.writeObject(this.string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {

        /*this.currentDate = (Date)in.readObject();*/
        /*this.temperature = in.readInt();*/
        this.string = (String) in.readObject();

    }

    @Override
    public String toString() {
        return this.string;
    }
}
