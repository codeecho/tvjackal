package uk.co.codeecho.tvjackal.model;

import java.util.List;

public class Recommendations {

    private List<Film> films;
    private List<Episode> showPremieres;
    private List<Episode> seriesPremieres;

    public Recommendations(List<Film> films, List<Episode> showPremieres, List<Episode> seriesPremieres) {
        this.films = films;
        this.showPremieres = showPremieres;
        this.seriesPremieres = seriesPremieres;
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Episode> getShowPremieres() {
        return showPremieres;
    }

    public List<Episode> getSeriesPremieres() {
        return seriesPremieres;
    }
    
}
