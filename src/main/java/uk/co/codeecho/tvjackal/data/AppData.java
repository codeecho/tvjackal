package uk.co.codeecho.tvjackal.data;

import biz.devspot.entity.framework.core.model.AbstractDataObject;
import java.util.Date;

public class AppData extends AbstractDataObject{
    
    private Date lastUpdateTime;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
