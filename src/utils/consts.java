package utils;

import javafx.scene.paint.Color;

public class consts {

    //Thread Priority
    public static final int LOG_PRIORITY = 8;
    public static final int PAINTER_PRIORITY = 6;



    public static final int DISTANCE_FROM_RECT_TO_UPPER_BOUND = 5;


    //Colorful Rect color
    public static final Color FILL_COLOR_NORMAL =
            new Color(0.158, 0.89, 0.96, 0.75);
    public static final Color STROKE_COLOR_NORMAL =
            new Color(0.667, 0.96, 0.189, 1);

    //Colorful Rect size
    public static final double MINIMUM_HEIGHT = 0.1D;
    public static final double MAXIMUM_HEIGHT = 0.95D;

    //Colorful Rect status
    public static final int NORMAL = 0;


    //Log parameters
    public static final int STANDARD_LOG_RATE = 1;
    public static final int MAXIMUM_LOG_RATE = 100;
    public static final int MINIMUM_LOG_RATE = 0;

    public static final float LOG_RATE_INCREASE_RATE = 1.5F;
    public static final float LOG_RATE_DECAY_RATE = 0.5F;

    public static final int SLEEP_TIME_PER_RATE = 10;
}
