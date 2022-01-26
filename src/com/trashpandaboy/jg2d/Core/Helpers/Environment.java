package com.trashpandaboy.jg2d.Core.Helpers;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.util.List;

import javax.swing.JFrame;

public class Environment {
    
	public static List<Integer> KEYBOARDHANDLER_CONTINUOUSKEYS;
	public static DisplayMode CURRENT_DISPLAYMODE;
	public static GraphicsDevice CURRENT_DISPLAY;
	public static JFrame CURRENT_GAME_WINDOW;
	public static Boolean SYSTEM_READY = false;
}
