package com.trashpandaboy.jg2d.Components;

import com.trashpandaboy.jg2d.Core.Component;

public class Position extends Component {
    float _x_pivot = 0.5f, _y_pivot = 0.5f;
    int _x, _y, _z;

    public void set_x_pivot (float _x_pivot)
    {
        this._x_pivot = _x_pivot;
    }

    public void set_y_pivot (float _y_pivot)
    {
        this._y_pivot = _y_pivot;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void set_z(int _z) {
        this._z = _z;
    }

    public float get_x_pivot()
    {
        return _x_pivot;
    }

    public float get_y_pivot()
    {
        return _y_pivot;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public int get_z() {
        return _z;
    }

    public Position(int x, int y) {
        _x = x;
        _y = y;
        _z = 0;
    }

    public Position(int x, int y, int z) {
        _x = x;
        _y = y;
        _z = z;
    }

    @Override
    public void Update() {
    }

    @Override
    public String toString() {
        return "X: " + _x + " | Y: " + _y + " | Z: " + _z;
    }
}
