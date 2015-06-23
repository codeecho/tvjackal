package uk.co.codeecho.tvjackal.model;

import biz.devspot.entity.framework.core.model.AbstractDataBackedObject;
import java.util.Date;

public class AppData extends AbstractDataBackedObject<uk.co.codeecho.tvjackal.data.AppData>{

    public AppData(){
        data.setLastUpdateTime(new Date());
    }
    
    public Date getLastUpdateTime(){
        return data.getLastUpdateTime();
    }
    
    public void recordUpdate(){
        data.setLastUpdateTime(new Date());
    }
    
    @Override
    protected uk.co.codeecho.tvjackal.data.AppData createDataObject() {
        return new uk.co.codeecho.tvjackal.data.AppData();
    }

}
