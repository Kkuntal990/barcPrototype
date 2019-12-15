package com.example.barcprototype;

import android.media.Image;

public class ListItem {
    private String name;
    private int iconId;
    private boolean isSelected = false;

    public ListItem(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return iconId;
    }

    public void setIcon(int iconId) {
        this.iconId = iconId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}