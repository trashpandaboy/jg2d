package com.trashpandaboy.jg2d.Components;

import com.trashpandaboy.jg2d.Core.Component;

/**
 * A Component that represent a collider shaped as Box
 */
public class BoxCollider extends Component {

    int _x, _y, _width, _height;

    /**
     * Set the X position of the Collider
     * 
     * @param _x X coord
     */
    public void set_x(int _x) {
        this._x = _x;
    }
    
    /**
     * Set the Y position of the Collider
     * 
     * @param _y Y coord
     */
    public void set_y(int _y) {
        this._y = _y;
    }

    /**
     * Set the Height size of the Collider
     * 
     * @param _height Height size
     */
    public void set_height(int _height) {
        this._height = _height;
    }

    /**
     * Set the Width size of the Collider
     * 
     * @param _width Width size
     */
    public void set_width(int _width) {
        this._width = _width;
    }

    /**
     * Get the X position of the Collider
     * 
     * @return X coord
     */
    public int get_x() {
        return _x;
    }

    /**
     * Get the Y position of the Collider
     * 
     * @return Y coord
     */
    public int get_y() {
        return _y;
    }

    /**
     * Get the Height size of the Collider
     * 
     * @return Height size
     */
    public int get_height() {
        return _height;
    }

    /**
     * Get the Width size of the Collider
     * 
     * @return Width size
     */
    public int get_width() {
        return _width;
    }

    /**
     * Create a BoxCollider object with specified parameters
     * @param x X position coord
     * @param y Y position coord
     * @param width Width size 
     * @param height Height size
     */
    public BoxCollider(int x, int y, int width, int height) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    @Override
    public void Update() {
    }

}