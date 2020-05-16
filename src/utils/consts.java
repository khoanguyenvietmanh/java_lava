package utils;

import javafx.scene.paint.Color;

public class consts {

    //Thread Priority
    public static final int LOG_PRIORITY = 8;
    public static final int PAINTER_PRIORITY = 6;


    public static final int DISTANCE_FROM_RECT_TO_UPPER_BOUND = 5;


    //Data properties
    public static final int NUMBER_OF_RECTANGLE = 15;


    //Colorful Rect properties
    //color
    public static final Color NORMAL_FILL_COLOR =
            new Color(0.158, 0.89, 0.96, 0.75);
    public static final Color NORMAL_STROKE_COLOR =
            new Color(0.667, 0.96, 0.189, 1);
    // size
    public static final double MINIMUM_RECT_HEIGHT = 0.1D;
    public static final double MAXIMUM_RECT_HEIGHT = 0.95D;
    //status
    public static final int NORMAL_RECT = 0;


    //Log parameters
    public static final int STANDARD_LOG_RATE = 1;
    public static final int MAXIMUM_LOG_RATE = 100;
    public static final int MINIMUM_LOG_RATE = 0;

    public static final float RATE_INCREASE_COEFFICIENT = 1.3F;
    public static final float RATE_DECAY_COEFFICIENT = 0.5F;

    public static final int SLEEP_TIME_PER_RATE = 10;
}
