package com.rodico.duke0808.mygeekhub_homeworks;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testFactorial() throws Exception{
        assertEquals(1,Integer.parseInt(HW2Activity.MathClass.mathClass.factorial(1).toString()));
        assertEquals(2,Integer.parseInt(HW2Activity.MathClass.mathClass.factorial(2).toString()));
        assertEquals(6,Integer.parseInt(HW2Activity.MathClass.mathClass.factorial(3).toString()));
        assertEquals(24,Integer.parseInt(HW2Activity.MathClass.mathClass.factorial(4).toString()));
        assertEquals(120, Integer.parseInt(HW2Activity.MathClass.mathClass.factorial(5).toString()));
    }

    public void testFibonachi(){

        //Порядок последовательности при этом таков:
        // 1, 1, 2, 3, 5, 8, 13, 21..., следующим числом будет 34

        assertEquals(1,HW2Activity.MathClass.mathClass.fibonachi(0));
        assertEquals(1,HW2Activity.MathClass.mathClass.fibonachi(1));
        assertEquals(2,HW2Activity.MathClass.mathClass.fibonachi(2));
        assertEquals(3,HW2Activity.MathClass.mathClass.fibonachi(3));
        assertEquals(5,HW2Activity.MathClass.mathClass.fibonachi(4));
        assertEquals(8,HW2Activity.MathClass.mathClass.fibonachi(5));
        assertEquals(13,HW2Activity.MathClass.mathClass.fibonachi(6));
    }

}