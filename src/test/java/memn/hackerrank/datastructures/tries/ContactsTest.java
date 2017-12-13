package memn.hackerrank.datastructures.tries;

import org.junit.Assert;
import org.junit.Test;

public class ContactsTest {

    @Test
    public void testAdd() throws Exception {
        Contacts c = new Contacts();
        c.add("a");
        c.add("aab");
        c.add("aac");
        System.out.println(c);
    }

    @Test
    public void testFind() throws Exception {
        Contacts c = new Contacts();
        c.add("a");
        c.add("aab");
        c.add("aac");
        Assert.assertEquals(2, c.find("aa"));
        Assert.assertEquals(3, c.find("a"));
        Assert.assertEquals(0, c.find("ab"));

        Contacts c2 = new Contacts();
        c2.add("hack");
        c2.add("hackerrank");
        Assert.assertEquals(2, c2.find("hac"));

    }
}