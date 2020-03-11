package com.example.recycelview;

import java.util.List;

public class ArrayDataItem {

    private List<ItemData> data;

    public ArrayDataItem(List<ItemData> data) {
        this.data = data;
    }

    public List<ItemData> getData() {
        return data;
    }

    public void setData(List<ItemData> data) {
        this.data = data;
    }

    public void getData(String s) {
    }
}
