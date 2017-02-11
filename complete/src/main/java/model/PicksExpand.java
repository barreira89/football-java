package model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class PicksExpand {

	
	@Id
	String id;
	String username;
	int week;
	Games game;
	double season;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public Games getGame() {
		return game;
	}

	public void setGame(Games game) {
		this.game = game;
	}

	public double getSeason() {
		return season;
	}

	public void setSeason(double season) {
		this.season = season;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	String winner;
	
	PicksExpand(){};
	
	public PicksExpand(String id, String username, int week, Games game, double season, String winner){
		this.id = id;
		this.username = username;
		this.week = week;
		this.game = game;
		this.season = season;
		this.winner = winner;
	}
}
