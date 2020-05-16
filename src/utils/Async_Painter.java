package utils;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

//TODO: Make this class can access FXML
public class Async_Painter implements Runnable{

    private static Thread t;

    @FXML
    private Pane visual_board;


    public Async_Painter() {
        if (t == null) {
            t = new Thread(this);
            t.setName("Painter_thread");
            t.setPriority(6);
            t.setDaemon(true);
            run();
        }
    }

    @Override
    public void run() {
        System.out.println(t.getName() + " is running!");
    }

    public synchronized void paint_new_rect(int no_of_rect, double width_per_rect, Array_Controller my_Array){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < no_of_rect; i++) {
                    double rect_height = Math.min(
                            my_Array.getNum_array()[i] * 10,
                            visual_board.getHeight() - Consts.DISTANCE_FROM_RECT_TO_UPPER_BOUND);

                    Colorful_Rectangle rect = new Colorful_Rectangle(
                            i * width_per_rect,
                            visual_board.getHeight() - rect_height ,
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
