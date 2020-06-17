package com.specialtopics.racer.graphics;

import com.oroarmor.core.glfw.Display;
import com.oroarmor.core.glfw.event.key.Key;
import com.oroarmor.core.glfw.event.key.hold.KeyHoldEvent;
import com.oroarmor.core.glfw.event.key.press.KeyPressEvent;
import com.oroarmor.core.glfw.event.key.release.KeyReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.button.press.MousePressEvent;
import com.oroarmor.core.glfw.event.mouse.button.release.MouseReleaseEvent;
import com.oroarmor.core.glfw.event.mouse.over.enter.MouseEnterEvent;
import com.oroarmor.core.glfw.event.mouse.over.leave.MouseLeaveEvent;
import com.oroarmor.core.glfw.event.mouse.position.MousePositionEvent;
import com.oroarmor.core.glfw.event.mouse.scroll.MouseScrollEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEvent;
import com.specialtopics.racer.event.gameclose.GameCloseEventListener;
import com.specialtopics.racer.event.gamepause.GamePauseEvent;
import com.specialtopics.racer.event.gamepause.GamePauseEventListener;

public class RacerDisplay extends Display {

	public RacerDisplay() {
		super(1280, 720, "Space Racer");
	}

	@Override
	public void processKeyPressedEvent(KeyPressEvent event) {
	}

	@Override
	public void processKeyHeldEvent(KeyHoldEvent event) {
	}

	@Override
	public void processKeyReleasedEvent(KeyReleaseEvent event) {
		if (event.getKey() == Key.ESCAPE) {
			GameCloseEventListener.processAllGameCloseEvent(new GameCloseEvent());
		} else if(event.getKey() == Key.P) {
			GamePauseEventListener.processAllGamePauseEvent(new GamePauseEvent());
		}
	}

	@Override
	public void processMouseScrolledEvent(MouseScrollEvent event) {
	}

	@Override
	public void processMousePressEvent(MousePressEvent event) {
	}

	@Override
	public void processMouseReleasedEvent(MouseReleaseEvent event) {
	}

	@Override
	public void processMousePositionEvent(MousePositionEvent event) {
	}

	@Override
	public void processMouseLeaveEvent(MouseLeaveEvent event) {
	}

	@Override
	public void processMouseEnterEvent(MouseEnterEvent event) {
	}

}
