package uk.co.codeecho.tvjackal.data;

import biz.devspot.entity.framework.core.model.AbstractDataObject;
import java.util.Date;

public class Programme extends AbstractDataObject {

    private String channel;
    private Date startTime;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

}
