package test.java;

import main.java.PO.Cat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CatTest {
    Cat cat;

    @BeforeMethod
    public void setUp() {
        cat = new Cat();
    }

    @Test
    public void test1() {
        int actual = cat.min(1, 2);
        int expected = 1;
        assertEquals(actual, expected);
    }
}