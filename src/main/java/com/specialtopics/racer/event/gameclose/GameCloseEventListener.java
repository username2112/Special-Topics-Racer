package com.specialtopics.racer.event.gameclose;

import java.util.ArrayList;

import com.oroarmor.core.glfw.event.Active;

public interface GameCloseEventListener extends Active {
	public static ArrayList<GameCloseEventListener> gameCloseListeners = new ArrayList<GameCloseEventListener>();

	public static void addGameCloseListener(GameCloseEventListener listener) {
		gameCloseListeners.add(listener);
	}

	public static void processAllGameCloseEvent(GameCloseEvent event) {
		for (GameCloseEventListener listener : gameCloseListeners) {
			listener.processGameCloseEvent(event);
		}
	}

	public default void addToGameCloseListeners() {
		addGameCloseListener(this);
	}

	public void processGameCloseEvent(GameCloseEvent event);
}
