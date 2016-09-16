package com.javarush.test.level34.lesson02.task01.tests;

import com.javarush.test.level34.lesson02.task01.Solution;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Prog on 12.08.2016.
 */
public class SolutionTest
{

    @Test
    public void testFibonacci(){

        Solution solution = new Solution();
        Assert.assertTrue(solution.fibonacci(9) == 34);
        Assert.assertTrue(solution.fibonacci(2) == 1);
        Assert.assertTrue(solution.fibonacci(1) == 1);
        Assert.assertTrue(solution.fibonacci(0) == 0);

    }


}
