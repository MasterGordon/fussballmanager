package fußballmanager;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.text.NumberFormat;

import fußballmanager.personen.*;

public class Spiel {
	int spielzeit;
	int verlängerung;
	Team heimteam;
	Team auswärtsteam;
	Schiedsrichter schiri;
	Ball b;
	//true = heim | false = auswärts
	boolean ballBesitz;

	public Spiel(Team heim, Team aus, Schiedsrichter s) {
		this.heimteam = heim;
		this.auswärtsteam = aus;
		this.schiri = s;
		ballBesitz = ((int) Math.random()) == 0 ? true : false;
		spielzeit = 0;
	}

	public void tick() {
		spielzeit++;
		movePhase();
		attackPhase();

	}
	
	private void movePhase(){
		Team ballteam;
		Team nichtballteam;
		if(ballBesitz){
			ballteam = heimteam;
			nichtballteam = auswärtsteam;
		}else{
			ballteam = auswärtsteam;
			nichtballteam = heimteam;
		}
		for(Spieler s:ballteam.spieler){
			double d = s.geschwindigkeit;
			if(s.hasBall()) d-=1;
			s.p.moveTo(nichtballteam.torwart.p, d);
		}
		for(Spieler s:nichtballteam.spieler){
			s.p.moveTo(b.s.p, s.geschwindigkeit);
		}
	}
	
	private void attackPhase(){
		
	}
	
	

	public String getSpielzeit() {
		String r = "";
		NumberFormat numberFormat = new DecimalFormat("0");
		numberFormat.setRoundingMode(RoundingMode.DOWN);
		r += "Spielzeit: " + numberFormat.format(this.spielzeit / 60) + ":";
		if (spielzeit % 60 < 10){
			r += "0";
		}
		r += spielzeit % 60;
		return r;
	}
	
	
}
