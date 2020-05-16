package utils;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import static utils.consts.PAINTER_PRIORITY;

//TODO: Make this class can access FXML
//TODO: Finish run() method

public class Async_Painter implements Runnable {

    @FXML
    private Pane visual_board;

    private static Thread t;

    public Async_Painter() {
        if (t == null) {
            System.out.println("No painter. Creating new painter");
            t = new Thread(this);
            t.setName("Painter thread");
            t.setPriority(PAINTER_PRIORITY);
            System.out.println(t.getName() + " created");
            t.start();
        }

    }

    @Override
    public void run() {

    }

    public synchronized void paint_new_rect(int no_of_rect, double width_per_rect, Array_Controller my_Array) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < no_of_rect; i++) {
                    double rect_height = Math.min(
                            my_Array.getNum_Array()[i] * 10,
                            visual_board.getHeight() - consts.DISTANCE_FROM_RECT_TO_UPPER_BOUND);

                    Colorful_Rectangle rect = new Colorful_Rectangle(
                            i * width_per_rect,
                            visual_board.getHeight() - rect_height,
                            width_per_rect,
                            rect_height
                    );

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            visual_board.getChildren().add(rect);
                        }
                    });
                }

            }
        }).start();
    }


}

