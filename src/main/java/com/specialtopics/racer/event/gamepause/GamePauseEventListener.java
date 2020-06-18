package com.specialtopics.racer.event.gamepause;

import java.util.ArrayList;

import com.oroarmor.core.game.event.Active;

public interface GamePauseEventListener extends Active {

	public static ArrayList<GamePauseEventListener> gamePauseListeners = new ArrayList<>();

	public static void addGamePauseListener(GamePauseEventListener listener) {
		gamePauseListeners.add(listener);
	}

	public static void processAllGamePauseEvent(GamePauseEvent event) {
		for (GamePauseEventListener listener : gamePauseListeners) {
			listener.processGamePauseEvent(event);
		}
	}

	public default void addToGamePauseListeners() {
		addGamePauseListener(this);
	}

	public void processGamePauseEvent(GamePauseEvent event);
}
