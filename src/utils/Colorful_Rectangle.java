package utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


public class Colorful_Rectangle extends Rectangle {

    private Color fill_color = consts.NORMAL_FILL_COLOR;
    private Color stroke_color = consts.NORMAL_STROKE_COLOR;
    private int status;

    public Colorful_Rectangle() {
        super();
        setFill(fill_color);
        setStroke(stroke_color);
        this.status = consts.NORMAL_RECT;
    }

    public Colorful_Rectangle(double width, double height) {
        super(width, height);
        setFill(fill_color);
        setStroke(stroke_color);
        this.status = consts.NORMAL_RECT;
    }

    public Colorful_Rectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFill(fill_color);
        setStroke(stroke_color);
        this.status = consts.NORMAL_RECT;
    }

    @Getter
    public int getStatus() {
        return status;
    }

    @Setter
    public void setFill_color(Color fill_color) {
        this.fill_color = fill_color;
    }

    public void setStroke_color(Color stroke_color) {
        this.stroke_color = stroke_color;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
