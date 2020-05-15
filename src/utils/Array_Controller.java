package utils;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.Random;

public class Array_Controller {
    private float[] num_array;


    private int length;


    public Array_Controller() {
    }

    public void make(int length) {
        this.length = length;

        num_array = new float[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            num_array[i] = Math.round(random.nextFloat() * 25 + 4);

        }
    }

    @Setter
    public void setLength(int length) {
        this.length = length;
    }

    public void setNum_array(float[] num_array) {
        this.num_array = num_array;
    }

    public float[] getNum_array() {
        return num_array;
    }

    @Getter


    public int getLength() {
        return length;
    }

}
