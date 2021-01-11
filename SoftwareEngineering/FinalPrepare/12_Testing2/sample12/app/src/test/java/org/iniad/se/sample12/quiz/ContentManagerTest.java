package org.iniad.se.sample12.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContentManagerTest {
    private ContentManager contentManager;
    @Before
    public void setUp(){
        contentManager= new ContentManager();
    }

    @Test
    public void testPost1() throws InvalidPostException{
        contentManager.post("Bruh", "Moment");
        List<Entry> contents= contentManager.getContent();
        int found= 0;
        for (Entry entry : contents){
            if (entry.getTitle().equals("Bruh") && entry.getContent().equals("Moment")){
                found= 1;
            }
        }
        assertThat(found, is(1));
    }

    @Test (expected = InvalidPostException.class)
    public void testPost2() throws InvalidPostException{
        contentManager.post(null, "Bruh");
    }

    @Test (expected = InvalidPostException.class)
    public void testPost3() throws InvalidPostException{
        contentManager.post("Bruh", null);
    }

    @Test (expected = InvalidPostException.class)
    public void testPost4() throws InvalidPostException{
        contentManager.post("", "Bruh");
    }

    @Test (expected = InvalidPostException.class)
    public void testPost5() throws InvalidPostException{
        contentManager.post("Bruh", "");
    }

    @Test (expected = InvalidPostException.class)
    public void testPost6() throws InvalidPostException{
        contentManager.post("This is a too long title, not good, exception should be raised.", "Bruh");
    }

    @Test (expected = InvalidPostException.class)
    public void testPost7() throws InvalidPostException{
        contentManager.post("Not\nGood", "Bruh");
    }
}