package uk.co.codeecho.tvjackal.controller;

import biz.devspot.entity.framework.core.EntityManager;
import biz.devspot.entity.framework.core.EntityManagerFactory;
import biz.devspot.entity.framework.core.query.Query;
import biz.devspot.entity.framework.core.query.QueryBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import uk.co.codeecho.mandrake.core.controller.AbstractController;
import uk.co.codeecho.mandrake.core.request.Request;
import uk.co.codeecho.mandrake.core.request.Response;
import uk.co.codeecho.tvjackal.model.Episode;
import uk.co.codeecho.tvjackal.model.Film;
import uk.co.codeecho.tvjackal.model.Programme;
import uk.co.codeecho.tvjackal.model.Recommendations;
import uk.co.codeecho.tvjackal.model.User;

public class RecommendationsController extends AbstractController{

    @Override
    public void handle(Request request, Response response, Map<String, Object> model) {
        User user = (User) request.getAttribute("user");
        EntityManager entityManager = EntityManagerFactory.getManager();
        List<Film> films = entityManager.find(Film.class, new Query());
        List<Episode> showPremieres = entityManager.find(Episode.class, new QueryBuilder().where("series").isEqualTo(1).build());
        List<Episode> seriesPremieres = entityManager.find(Episode.class, new QueryBuilder().where("series").isGreaterThan(1).build());
        for(String channel: user.getIgnoredChannels()){
            filterByChannel(films, channel);
            filterByChannel(showPremieres, channel);
            filterByChannel(seriesPremieres, channel);
        }
        Recommendations recommendations = new Recommendations(films, showPremieres, seriesPremieres);
        model.put("recommendations", recommendations);
    }
    
    private <P extends Programme> void filterByChannel(List<P> programmes, String channel){
        Iterator<P> iterator = programmes.iterator();
        while(iterator.hasNext()){
            P programme = iterator.next();
            if(programme.getChannel().equalsIgnoreCase(channel)){
                iterator.remove();
            }
        }
    }

}
