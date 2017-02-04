package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Games {

    @Id
    public String id;
    public String home;
    public String visitor;
    public int weekNumber;
    public int season;
    public String winner;
    public String date;
    public String time;
    public int homescore;
    public int visitscore;

    public Games() {}

    public Games(String home, String visitor, int weekNumber, int season, String winner, String date, String time, int homescore, int visitscore) {
        this.home = home;
        this.visitor = visitor;
        this.weekNumber = weekNumber;
        this.season = season;
        this.winner = winner;
        this.homescore = homescore;
        this.visitscore = visitscore;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format(
                "Game[id=%s, home='%s', visitor='%s', weekNumber='%s']",
                id, home, visitor, weekNumber);
    }

}

