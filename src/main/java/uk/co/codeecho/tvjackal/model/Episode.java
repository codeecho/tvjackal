package uk.co.codeecho.tvjackal.model;

import java.util.Date;

public class Episode extends Programme<uk.co.codeecho.tvjackal.data.Episode>{

    public Episode(String show, int series, String channel, Date startTime) {
        super(channel, startTime);
        data.setShow(show);
        data.setSeries(series);
    }
    
    public String getShow(){
        return data.getShow();
    }
    
    public int getSeries(){
        return data.getSeries();
    }

    @Override
    protected uk.co.codeecho.tvjackal.data.Episode createDataObject() {
        return new uk.co.codeecho.tvjackal.data.Episode();
    }

}
