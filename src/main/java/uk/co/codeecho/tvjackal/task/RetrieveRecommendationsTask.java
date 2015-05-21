package uk.co.codeecho.tvjackal.task;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import java.io.IOException;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import uk.co.codeecho.mandrake.core.task.TransactionalTask;
import uk.co.codeecho.tvjackal.model.Episode;
import uk.co.codeecho.tvjackal.model.Film;

public class RetrieveRecommendationsTask extends TransactionalTask {

    @Override
    public void doRun() {
        try {
            Document doc = Jsoup.connect("http://www.tvguide.co.uk/?catcolor=&systemid=5&thistime=24&thisday=05/12/2015&gridspan=12:00&view=0&gw=1557").get();
            for (Element el : doc.select(".div-epg-channel-progs")) {
                String channel = el.select(".div-epg-channel-name").text();
                for (Element programmeEl : el.select(".div-epg-programme")) {
                    boolean isFilm = !programmeEl.select("img[alt=Film]").isEmpty();
                    String label = programmeEl.select("a").attr("qt-title");
                    if (!label.isEmpty()) {
                        String timeLabel = label.substring(0, label.indexOf(" "));
                        String startTimeLabel = timeLabel.substring(0, timeLabel.indexOf("-"));
                        Date startTime = parseTimeLabel(new Date(), startTimeLabel);
                        //String endTimeLabel = timeLabel.substring(timeLabel.indexOf("-") + 1);
                        String title = label.substring(label.indexOf(" ") + 1);
                        if (isFilm) {
                            Film film = new Film(title, 0, channel, startTime);
                            //System.out.println("FILM: " + film.getChannel() + ": " + film.getName() + " - " + film.getStartTime());
                        } else {
                            int series = -1;
                            int index = -1;
                            String qttext = programmeEl.select("a").attr("qt-text");
                            for (String token : qttext.split("<br>")) {
                                if (token.indexOf("Season ") == 0) {
                                    series = Integer.parseInt(token.substring(7, token.indexOf(".")));
                                    String episodeLabel = token.substring(token.indexOf(".") + 2, token.lastIndexOf(".")) + " ";
                                    episodeLabel = episodeLabel.substring(episodeLabel.indexOf(" ") + 1);
                                    episodeLabel = episodeLabel.substring(0, episodeLabel.indexOf(" "));
                                    index = Integer.parseInt(episodeLabel);
                                }
                            }
                            if (index == 1) {
                                if (series == 1) {
                                    Episode episode = new Episode(title, series, channel, startTime);
                                    //System.out.println("SHOW PREMIERE: " + episode.getChannel() + ": " + episode.getShow() + " - " + episode.getStartTime());
                                } else {
                                    Episode episode = new Episode(title, series, channel, startTime);
                                    //System.out.println("SERIES PREMIERE: " + episode.getChannel() + ": " + episode.getShow() + " - " + episode.getStartTime());
                                }
                            }

                        }
                    }
                }
            };
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Date parseTimeLabel(Date base, String timeLabel) {
        boolean isAm = false;
        if (timeLabel.endsWith("am")) {
            isAm = true;
        }
        timeLabel = timeLabel.replace("am", "").replace("pm", "");
        String hourLabel = timeLabel.substring(0, timeLabel.indexOf(":"));
        String minuteLabel = timeLabel.substring(timeLabel.indexOf(":") + 1);
        int hour = Integer.parseInt(hourLabel);
        int minute = Integer.parseInt(minuteLabel);
        if (!isAm) {
            hour = hour + 12;
        }
        Date date = new Date(base.getTime());
        date.setHours(hour);
        date.setMinutes(minute);
        date.setSeconds(0);
        return date;
    }

}
