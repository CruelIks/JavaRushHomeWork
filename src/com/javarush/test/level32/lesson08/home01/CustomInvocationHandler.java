package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Admin on 12.06.2016.
 */
public class CustomInvocationHandler implements InvocationHandler
{

    private SomeInterfaceWithMethods obj;

    public CustomInvocationHandler(SomeInterfaceWithMethods obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println(method.getName() + " in");
        Object object = method.invoke(obj, args);
        System.out.println(method.getName() + " out");
        return object;
    }
}

