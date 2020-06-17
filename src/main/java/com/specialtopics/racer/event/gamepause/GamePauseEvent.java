package com.specialtopics.racer.event.gamepause;

import com.oroarmor.core.game.event.Event;

import com.oroarmor.core.game.event.EventType;


public class GamePauseEvent implements Event {
	private long window;

	@Override
	public EventType getEventType() {
		return EventType.CUSTOM;
	}

	@Override
	public long getWindow() {
		return window;
	}

	@Override
	public void setWindow(long window) {
		this.window = window;
	}

}


