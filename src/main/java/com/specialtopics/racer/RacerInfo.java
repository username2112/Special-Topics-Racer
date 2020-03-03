package com.specialtopics.racer;

import com.oroarmor.core.game.GameInfo;
import com.specialtopics.racer.graphics.RacerDisplay;

public class RacerInfo implements GameInfo {
	private RacerDisplay racerDisplay;

	public RacerDisplay getRacerDisplay() {
		return racerDisplay;
	}

	public synchronized void setRacerDisplay(RacerDisplay racerDisplay) {
		this.racerDisplay = racerDisplay;
	}

}
