package com.codequest.backend.entity;

public class DrawingEvent {
    private int x;
    private int y;
    private String tool;
    private String color;
    private int lineWidth;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTool() {
        return tool;
    }

    public String getColor() {
        return color;
    }

    public int getLineWidth() {
        return lineWidth;
    }
// getters and setters
}
