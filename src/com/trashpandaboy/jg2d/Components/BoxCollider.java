package com.trashpandaboy.jg2d.Components;

import com.trashpandaboy.jg2d.Core.Component;

public class BoxCollider extends Component {
    int _x, _y, _z, _width, _height;
    boolean _colliding;

    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void set_z(int _z) {
        this._z = _z;
    }

    public void set_height(int _height) {
        this._height = _height;
    }

    public void set_width(int _width) {
        this._width = _width;
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

    public int get_height() {
        return _height;
    }

    public int get_width() {
        return _width;
    }

    public void set_colliding(boolean _colliding) {
        this._colliding = _colliding;
    }

    public boolean get_colliding() {
        return _colliding;
    }

    public BoxCollider(int x, int y, int width, int height) {
        _x = x;
        _y = y;
        _z = 0;
        _width = width;
        _height = height;
    }

    public BoxCollider(int x, int y, int z, int width, int height) {
        _x = x;
        _y = y;
        _z = z;
        _width = width;
        _height = height;
    }

    @Override
    public void Update() {
        // Reset colliding flag
        _colliding = false;

    }

}