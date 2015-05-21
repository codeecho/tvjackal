package uk.co.codeecho.tvjackal.model;

import biz.devspot.entity.framework.core.model.AbstractDataBackedObject;
import java.util.ArrayList;
import java.util.List;

public class User extends AbstractDataBackedObject<uk.co.codeecho.tvjackal.data.User>{

    public User() {
        data.setIgnoredChannels(new ArrayList<String>());
        data.setIgnoredShows(new ArrayList<String>());
    }
    
    public List<String> getIgnoredChannels(){
        return data.getIgnoredChannels();
    }
    
    public List<String> getIgnoredShows(){
        return data.getIgnoredShows();
    }
    
    public void addChannelToIgnore(String channel){
        data.addChannelToIgnore(channel);
    }
    
    public void addShowToIgnore(String show){
        data.addShowToIgnore(show);
    }

    @Override
    protected uk.co.codeecho.tvjackal.data.User createDataObject() {
        return new uk.co.codeecho.tvjackal.data.User();
    }

}
