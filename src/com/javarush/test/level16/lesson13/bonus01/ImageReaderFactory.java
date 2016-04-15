package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


/**
 * Created by Prog on 09.03.2016.
 */
public class ImageReaderFactory
{

    public static ImageReader getReader(ImageTypes type)
    {

        try
        {

            if (type.equals(ImageTypes.BMP)) return new BmpReader();
            else if (type.equals(ImageTypes.PNG)) return new PngReader();
            else if (type.equals(ImageTypes.JPG)) return new JpgReader();
            else
            {
                try
                {

                    throw new IllegalArgumentException("Неизвестный тип картинки");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");

        }
        catch (NullPointerException e) {throw new IllegalArgumentException("Неизвестный тип картинки");}
    }

}


