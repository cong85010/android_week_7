package com.example.android_week_7;

public class Travel {
    int _id;
    String _name;

    public Travel(int _id, String _name) {
        this._id = _id;
        this._name = _name;
    }

    public Travel(String _name) {
        this._name = _name;
    }

    public Travel() {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
