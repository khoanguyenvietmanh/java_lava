package utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Colorful_Rectangle extends Rectangle {

    private static final Color fill_color = Consts.FILL_COLOR_NORMAL;
    private static final Color stroke_color = Consts.STROKE_COLOR_NORMAL;


    public Colorful_Rectangle() {
        super();
        setFill(fill_color);
        setStroke(stroke_color);
    }

    public Colorful_Rectangle(double width, double height) {
        super(width, height);
        setFill(fill_color);
        setStroke(stroke_color);
    }

    public Colorful_Rectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFill(fill_color);
        setStroke(stroke_color);
    }
}
