package pages;

import org.junit.Assert;
import org.junit.Test;

public class Conflicts {
    @Test
    public void test1(){
        int x = 10;
        int y = 5;
        int sum = (x+y) + (x+y);
        System.out.println("Sum" + sum);
    }
    @Test
    public void test2(){
        String text = "welcome to USA - the lend of opportunity";
        Assert.assertTrue(text.contains("US"));
    }
}
