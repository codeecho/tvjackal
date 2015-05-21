package uk.co.codeecho.tvjackal.model;

import biz.devspot.entity.framework.core.model.AbstractDataBackedObject;
import java.util.Date;

public abstract class Programme<DO extends uk.co.codeecho.tvjackal.data.Programme> extends AbstractDataBackedObject<DO>{

    public Programme(String channel, Date startTime){
        data.setChannel(channel);
        data.setStartTime(startTime);
    }
    
    public String getChannel(){
        return data.getChannel();
    }
    
    public Date getStartTime(){
        return data.getStartTime();
    }
    
}
