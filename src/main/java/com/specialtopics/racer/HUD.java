package com.specialtopics.racer;

import java.awt.Graphics;
import java.util.*;

public class HUD {
	private static long startTime;
	

	public static long getTime() {
		long time = System.currentTimeMillis() - startTime;
		return time;
	}

	public void paintComponent(Graphics g) {
		g.drawString("Time: " + (getTime() / 1000), 20, 590);
	}
}
