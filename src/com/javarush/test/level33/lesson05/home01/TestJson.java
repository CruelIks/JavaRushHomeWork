package com.javarush.test.level33.lesson05.home01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Prog on 17.06.2016.
 */
public class TestJson
{
    public static void main(String[] args)
    {

        TestJson test = new TestJson();
        Car myCar = new Car("BMW", 200);
        Car mySecondCar = new Car("LADA SEDAN", 100);

        System.out.println(myCar);
        System.out.println(mySecondCar);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(writer, myCar);
            System.out.println(writer.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    @JsonAutoDetect
    public static class Car{
        public String model;
        public int maxSpeed;

        public Car(String model, int maxSpeed)
        {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        @Override
        public String toString()
        {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }
    }
}
