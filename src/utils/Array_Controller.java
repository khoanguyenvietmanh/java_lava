package utils;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.concurrent.ThreadLocalRandom;


public class Array_Controller {
    private float[] num_Array;

    private int length;


    public Array_Controller() {
    }

    public void make(int length) {
        //Make a array of float between min and max value
        //Status = Normal

        this.length = length;

        num_Array = new float[length];

        for (int i = 0; i < length; i++) {
            num_Array[i] = (float) (
                    ThreadLocalRandom.current().nextDouble(
                            consts.MINIMUM_RECT_HEIGHT,
                            consts.MAXIMUM_RECT_HEIGHT
                    ));
        }
    }

    @Setter
    public void setLength(int length) {
        this.length = length;
    }

    public void setNum_Array(float[] num_Array) {
        this.num_Array = num_Array;
    }

    public float[] getNum_Array() {
        return num_Array;
    }


    @Getter
    public int getLength() {
        return length;
    }

}
