package org.iniad.se.sample12.quiz;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
    private List<Entry> contents = new ArrayList<Entry>();

    public ContentManager() {
    }

    public List<Entry> getContent() {
        return contents;
    }

    public void post(String title, String content) throws InvalidPostException{
        if (title == null || content == null || title.equals("") || content.equals("") || title.length() > 10){
            throw new InvalidPostException("Invalid Post");
        }
        for (int i= 0; i < title.length(); i++){
            if (title.charAt(i) == '\n'){
                throw new InvalidPostException("Invalid Post");
            }
        }
        contents.add(new Entry(title, content));
    }
}