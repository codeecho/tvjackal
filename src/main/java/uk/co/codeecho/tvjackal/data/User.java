package uk.co.codeecho.tvjackal.data;

import biz.devspot.entity.framework.core.model.AbstractDataObject;
import java.util.Collections;
import java.util.List;

public class User extends AbstractDataObject{

    private List<String> ignoredChannels;
    private List<String> ignoredShows;

    public List<String> getIgnoredChannels() {
        return Collections.unmodifiableList(ignoredChannels);
    }

    public void setIgnoredChannels(List<String> ignoredChannels) {
        this.ignoredChannels = ignoredChannels;
    }

    public List<String> getIgnoredShows() {
        return Collections.unmodifiableList(ignoredShows);
    }

    public void setIgnoredShows(List<String> ignoredShows) {
        this.ignoredShows = ignoredShows;
    }
    
    public void addChannelToIgnore(String channel){
        ignoredChannels.add(channel);
    }
    
    public void addShowToIgnore(String show){
        ignoredShows.add(show);
    }
    
}
