package com.specialtopics.racer.music;

import java.util.Random;

import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEventListener;
import com.oroarmor.core.openal.AudioMaster;
import com.oroarmor.core.openal.AudioSource;

public class Radio extends AudioSource implements KeyPressEventListener {

	public static String[] songs = new String[] { "Zipline", "Night Race", "better", "decent", "meh", "neat", "Nice" };
	private int volume = 5;

	private int currentSong = -1;

	public Radio() {
		super();
		for (String song : songs) {
			AudioMaster.loadSound("com/specialtopics/racer/music/" + song + ".ogg", song);
		}

		addToKeyPressListeners();
		setGain(volume / 100f);
	}

	public void playSound() {

		int nextSong;
		do {
			nextSong = new Random().nextInt(songs.length);
		} while (nextSong == currentSong);

		System.out.println("Now playing: " + songs[nextSong]);
		playSound(AudioMaster.getSound(songs[nextSong]));
		currentSong = nextSong;
	}

	@Override
	public void processKeyPressedEvent(KeyPressEvent event) {
		if (event.key == Key.EQUAL) {
			volume++;
		} else if (event.key == Key.MINUS) {
			volume--;
		} else if (event.key == Key.RIGHT_BRACKET) {
			stop();
			this.playSound();
			return;
		} else {
			return;
		}

		volume = Math.max(0, Math.min(volume, 10));

		setGain(volume / 100f);
		System.out.println("Volume: " + volume);

	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public void setActive(boolean active) {
	}

}
