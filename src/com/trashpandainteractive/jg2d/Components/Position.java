package com.trashpandainteractive.jg2d.Components;

import com.trashpandainteractive.jg2d.Core.Component;

public class Position extends Component{

    int _x,_y, _z;

    public void set_x(int _x) {
        this._x = _x;
    }
    
    public void set_y(int _y) {
        this._y = _y;
    }

    public void set_z(int _z) {
        this._z = _z;
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

    public Position(int x, int y)
    {
        _x = x;
        _y = y;
        _z = 0;
    }

    public Position(int x, int y, int z)
    {
        _x = x;
        _y = y;
        _z = z;
    }

    @Override
    public void Update() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
        return "X: " + _x + " | Y: " + _y + " | Z: " + _z; 
    }
}
