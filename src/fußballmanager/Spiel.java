package fußballmanager;

import java.util.Random;

import fußballmanager.personen.Schiedsrichter;

public class Spiel {
	//Spielzeit wird in Sekunden
	int spielzeit;
	int verlängerung;
	Team heimteam;
	Team auswärtsteam;
	Schiedsrichter schiri;
	
	public void tick(){
		spielzeit++;
		int zufall = new Random().nextInt(100);
	}
}
