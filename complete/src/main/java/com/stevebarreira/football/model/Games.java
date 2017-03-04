package com.stevebarreira.football.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Games {

    @Id
    public String id;
    public String home;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getHomescore() {
		return homescore;
	}

	public void setHomescore(int homescore) {
		this.homescore = homescore;
	}

	public int getVisitscore() {
		return visitscore;
	}

	public void setVisitscore(int visitscore) {
		this.visitscore = visitscore;
	}

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

