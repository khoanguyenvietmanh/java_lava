package utils;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import sample.Controller;

import static utils.consts.PAINTER_PRIORITY;

//ACHIEVEMENT: Make this class can access FXML
//TODO: Finish run() method
//TODO: ThreadPool or ObservableList

public class Async_Painter implements Runnable{

    private static Thread t;

    private final Controller c;

    public Async_Painter(Controller c) {
        this.c = c;
    }

    @Override
    public void run() {

    }

    public synchronized void paint_new_rect(int no_of_rect, double width_per_rect, Array_Controller my_Array) {
        Pane visual_board = c.getVisual_board();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < no_of_rect; i++) {
                    double rect_height =
                            (1 - my_Array.getNum_Array()[i]) * visual_board.getHeight();

                    Colorful_Rectangle rect = new Colorful_Rectangle(
                            i * width_per_rect,
                            rect_height,
                            width_per_rect,
                            visual_board.getHeight() - rect_height
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

