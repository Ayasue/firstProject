package pages;

import org.junit.Assert;
import org.junit.Test;

public class Conflicts {
    @Test
    public void test1(){
        int x = 5;
        int y = 5;
        System.out.println("Sum" + (x+y));
    }
    @Test
    public void test2(){
        String text = "welcome to USA - the lend of opportunity";
        Assert.assertTrue(text.contains("US"));
    }
}
