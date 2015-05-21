package uk.co.codeecho.tvjackal.model;

import java.util.Date;

public class Film extends Programme<uk.co.codeecho.tvjackal.data.Film>{

    public Film(String name, int year, String channel, Date startTime) {
        super(channel, startTime);
        data.setName(name);
        data.setYear(year);
    }
    
    public String getName(){
        return data.getName();
    }
    
    public int getYear(){
        return data.getYear();
    }

    @Override
    protected uk.co.codeecho.tvjackal.data.Film createDataObject() {
        return new uk.co.codeecho.tvjackal.data.Film();
    }

}
