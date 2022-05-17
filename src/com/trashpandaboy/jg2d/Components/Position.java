package com.trashpandaboy.jg2d.Components;

import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Objects.GameObject;

/**
 * 
 * Position is a Component who represent the position in Space of a Gameobject
 * Contains also value related to Pivoting
 * 
 */
public class Position extends Component {
    float _x_pivot = 0.5f, _y_pivot = 0.5f;
    int _x, _y, _z;

    /**
     * Set the X value of the Pivot for the Object
     * 
     * @param _x_pivot New X value - min 0.0f - max 1.0f
     */
    public void set_x_pivot (float _x_pivot)
    {
        if(_x_pivot < 0.0f)
        {
            _x_pivot = 0.0f;
        }
        else if(_x_pivot > 1.0f)
        {
            _x_pivot = 1.0f;
        }
        this._x_pivot = _x_pivot;
    }

    /**
     * Set the Y value of the Pivot for the Object
     * 
     * @param _y_pivot New Y value - min 0.0f - max 1.0f
     */
    public void set_y_pivot (float _y_pivot)
    {
        if(_y_pivot < 0.0f)
        {
            _y_pivot = 0.0f;
        }
        else if(_y_pivot > 1.0f)
        {
            _y_pivot = 1.0f;
        }
        this._y_pivot = _y_pivot;
    }

    /**
     * Set the X value of the Object
     * 
     * @param _x New X value
     */
    public void set_x(int _x) {
        this._x = _x;
    }

    /**
     * Set the Y value of the Object
     * 
     * @param _y new Y value
     */
    public void set_y(int _y) {
        this._y = _y;
    }

    /**
     * Set the Z value of the Object
     * 
     * @param _z new Z value
     */
    public void set_z(int _z) {
        this._z = _z;
    }

    /**
     * Get the X value of the Pivot 
     * 
     * @return min 0.0f - max 1.0f 
     */
    public float get_x_pivot()
    {
        return _x_pivot;
    }

    /**
     * Get the Y value of the Pivot
     * 
     * @return min 0.0f - max 1.0f
     */
    public float get_y_pivot()
    {
        return _y_pivot;
    }

    /**
     * Get the X value of the Object position
     * 
     * @return int value
     */
    public int get_x() {
        return _x;
    }

    /**
     * Get the Y value of the Object position
     * 
     * @return int value
     */
    public int get_y() {
        return _y;
    }

    /**
     * Get the Z value of the Object position
     * 
     * @return int value
     */
    public int get_z() {
        return _z;
    }

    /**
     * Create a new Position Component with given x and y and a default Z value of 0
     * 
     * @param x X value
     * @param y Y value
     */
    public Position(int x, int y, GameObject parent) {
        _x = x;
        _y = y;
        _z = 0;
        super.parent = parent;
    }

    /**
     * Create a new Position Component with given x, y and z
     * 
     * @param x X value
     * @param y Y value
     * @param z Z value
     */
    public Position(int x, int y, int z, GameObject parent) {
        _x = x;
        _y = y;
        _z = z;
        super.parent = parent;
    }

    /**
     * Implementation of Update Component method
     * 
     */
    @Override
    public void FrameUpdate() {
    }

    /**
     * Textual description of Position object
     */
    @Override
    public String toString() {
        return "X: " + _x + " | Y: " + _y + " | Z: " + _z + " - Pivot X: " + _x_pivot + " | Pivot Y: " + _y_pivot;
    }
}
