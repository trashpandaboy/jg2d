package com.trashpandaboy.jg2d.Objects;

/**
 * A Camera Object represent a Movable Camera objecct to render a portion of WorldSpace
 */
public class CameraObject {
    int _x, _y, _width, _height;

    /**
     * Create a new Camera Object with specified size at [0,0] World Position
     * 
     * @param width Width Size
     * @param height Height Size
     */
    public CameraObject(int width, int height)
    {
        _x = 0;
        _y = 0;
        _width = width;
        _height = height;
    }

    /**
     * Create a new Camera Object with specified size at specified World Position
     * 
     * @param x X position
     * @param y Y position
     * @param width Width size 
     * @param height Height size
     */
    public CameraObject(int x, int y, int width, int height)
    {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    /**
     * Get the Camera Height
     * 
     * @return
     */
    public int get_height() {
        return _height;
    }
    
    /**
     * Get the Camera Width
     * 
     * @return
     */
    public int get_width() {
        return _width;
    }

    /**
     * Get the Camera X position
     * 
     * @return
     */
    public int get_x() {
        return _x;
    }

    /**
     * Get the Camera Y position
     * 
     * @return
     */
    public int get_y() {
        return _y;
    }

    /**
     * Set the Camera X Position
     * 
     * @param _x
     */
    public void set_x(int _x) {
        this._x = _x;
    }

    /**
     * Set the Camera Y Position
     * 
     * @param _y
     */
    public void set_y(int _y) {
        this._y = _y;
    }

    /**
     * Set the Camera Resolution with specified size
     * 
     * @param width Width Size
     * @param height Height Size
     */
    public void SetCameraResolution(int width, int height)
    {
        _width = width;
        _height = height;
    }
    
}
