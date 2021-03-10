package com.trashpandainteractive.jg2d.Objects;

public class CameraObject {
    int _x, _y, _width, _height;

    public CameraObject(int width, int height)
    {
        _x = 0;
        _y = 0;
        _width = width;
        _height = height;
    }

    public CameraObject(int x, int y, int width, int height)
    {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    public int get_height() {
        return _height;
    }
    
    public int get_width() {
        return _width;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void SetCameraResolution(int width, int height)
    {
        _width = width;
        _height = height;
    }
    
}
