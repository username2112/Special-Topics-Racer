package com.specialtopics.racer;

public class Main {

	public static void main(String[] args) {
		RacerInfo racerInfo = new RacerInfo();
		new Racer(new RacerRenderer(racerInfo), new RacerLogic(racerInfo)).run();
	}

}
