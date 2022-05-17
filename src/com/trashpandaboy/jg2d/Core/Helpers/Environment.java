package com.trashpandaboy.jg2d.Core.Helpers;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.util.List;

import javax.swing.JFrame;

/**
 * Represent an Environment singleton container for shared information
 * 
 */
public class Environment {
	public static final long CURRENT_DELAY = 20;

    public static final int FPS_CAP = 120;
    /**
	 * Currently pressed Keys
	 */
	public static List<Integer> KEYBOARDHANDLER_CONTINUOUSKEYS;
	/**
	 * DisplayMode select at start
	 */
	public static DisplayMode CURRENT_DISPLAYMODE;
	/**
	 * Display selected at start
	 */
	public static GraphicsDevice CURRENT_DISPLAY;
	/**
	 * GameWindow JFrame object to use for GameLoop
	 */
	public static JFrame CURRENT_GAME_WINDOW;
	/**
	 * State flag that represent if GameWindow is ready and GameLoop can draw
	 */
	public static Boolean SYSTEM_READY = false;
}
