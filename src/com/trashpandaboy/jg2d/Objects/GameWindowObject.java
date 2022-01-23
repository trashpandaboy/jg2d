package com.trashpandaboy.jg2d.Objects;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.trashpandaboy.jg2d.Core.Helpers.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameWindowObject {
    public boolean isReady = false;

    List<DisplayMode> displayModes;
    public static DisplayMode _displayMode;
    GraphicsDevice _graphicsDevice;
    GraphicsEnvironment _graphicsEnvironment;
    ArrayList<String> resolutionsStrings;

    // GameWindows
    JFrame _gameWindow;
    BufferStrategy _strategy;
    boolean _fullScreen = false;

    // Settings
    JFrame _settingsFrame;
    JComboBox<String> _resolutionsList;
    JCheckBox _fullScreenCheckbox;

    public GameWindowObject() {
        init();
    }

    private void createGameWindow() {
        _graphicsDevice = _graphicsEnvironment.getDefaultScreenDevice();
        _gameWindow = new JFrame();

        _gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _gameWindow.setLocation((_graphicsEnvironment.getMaximumWindowBounds().width - _displayMode.getWidth()) / 2,
                (_graphicsEnvironment.getMaximumWindowBounds().height - _displayMode.getHeight()) / 2);
        _gameWindow.setSize(_displayMode.getWidth(), _displayMode.getHeight());

		Environment.KEYBOARDHANDLER_PRESSEDKEYS = new ArrayList<Integer>();
        _gameWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                
                if (!Environment.KEYBOARDHANDLER_PRESSEDKEYS.contains(key.getKeyCode())) {
					Environment.KEYBOARDHANDLER_PRESSEDKEYS.add(key.getKeyCode());
				}
            }

            @Override
            public void keyReleased(KeyEvent key) {
                for (int i = 0; i < Environment.KEYBOARDHANDLER_PRESSEDKEYS.size(); i++) {
					if (Environment.KEYBOARDHANDLER_PRESSEDKEYS.get(i).equals(key.getKeyCode())) {
						Environment.KEYBOARDHANDLER_PRESSEDKEYS.remove(i);
					}
				}
            }

            @Override
            public void keyTyped(KeyEvent key) {

            }
        });

        if (_fullScreen && _graphicsDevice.isFullScreenSupported()) {
            System.out.println("Full screen supported!");
            _gameWindow.setUndecorated(true);
            _gameWindow.setResizable(false);
            _gameWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
            _graphicsDevice.setFullScreenWindow(_gameWindow);
            _graphicsDevice.setDisplayMode(_displayMode);
            _gameWindow.pack();
            _gameWindow.validate();

        }
    }

    private void createSettingsFrame(ArrayList<String> resolutionsStrings) {
        _settingsFrame = new JFrame();
        _settingsFrame.setTitle("Play Settings");
        _settingsFrame.setLayout(new BoxLayout(_settingsFrame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel settingsPanel = new JPanel();
        JPanel checkboxPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        _resolutionsList = new JComboBox<String>(resolutionsStrings.toArray(new String[0]));

        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.PAGE_AXIS));
        settingsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        settingsPanel.add(_resolutionsList);

        _fullScreenCheckbox = new JCheckBox();
        _fullScreenCheckbox.setText("Full Screen Mode");

        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.LINE_AXIS));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        checkboxPanel.add(Box.createHorizontalGlue());
        checkboxPanel.add(_fullScreenCheckbox);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selIndex = _resolutionsList.getSelectedIndex();

                _fullScreen = _fullScreenCheckbox.isSelected();
                _displayMode = displayModes.get(selIndex);

                System.out.println("Selected DisplayMode: " + _displayMode.toString());
                System.out.println("Fullscreen: " + _fullScreen);

                _settingsFrame.dispose();

                showGameWindow();
            }
        });

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(closeButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonsPanel.add(saveButton);

        _settingsFrame.add(settingsPanel);
        _settingsFrame.add(checkboxPanel);
        _settingsFrame.add(buttonsPanel);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        _settingsFrame.setLocation(dim.width / 2 - _settingsFrame.getSize().width / 2,
                dim.height / 2 - _settingsFrame.getSize().height / 2);
        _settingsFrame.setSize(600, 400);
        _settingsFrame.setMinimumSize(new Dimension(600, 400));
        _settingsFrame.pack();
    }

    public void init() {
        _graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Recupero i Graphic Devices
        GraphicsDevice[] devices = _graphicsEnvironment.getScreenDevices();

        resolutionsStrings = new ArrayList<String>();

        displayModes = Arrays.asList(devices[0].getDisplayModes());

        for (GraphicsDevice graphicsDevice : devices) {
            System.out.println("GDevice found: " + graphicsDevice.toString());
        }
        Collections.sort(displayModes, Comparator.comparing(DisplayMode::getWidth).thenComparing(DisplayMode::getHeight)
                .thenComparing(DisplayMode::getBitDepth).thenComparing(DisplayMode::getRefreshRate));

        Collections.reverse(displayModes);

        for (DisplayMode mode : displayModes) {
            resolutionsStrings.add(mode.toString());
        }

    }

    private void showSettings() {
        createSettingsFrame(resolutionsStrings);
        _settingsFrame.setVisible(true);
        _settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _settingsFrame.setResizable(false);
    }

    private void showGameWindow() {
        createGameWindow();
        _gameWindow.setVisible(true);
        _gameWindow.createBufferStrategy(2);
        _strategy = _gameWindow.getBufferStrategy();
        isReady = true;
    }

    public void show()
    {
        showSettings();
    }

    public BufferStrategy get_BufferStrategy() {
        return _strategy;
    }

}
