package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import utils.*;

public class Controller {

    private final Log my_Log = new Log();
    private final Async_Painter painter = new Async_Painter(this);

    @FXML
    private Button cancel_button;

    @FXML
    private Button start_button;

    @FXML
    private Pane visual_board;

    @FXML
    private Button step_forward_button;

    @FXML
    private Button step_backward_button;

    @FXML
    private Button pause_button;

    @FXML
    private Button reset_button;

    @FXML
    private Pane button_box;

    @FXML
    private Button randomize_button;

    @FXML
    void start_running(ActionEvent event) {
        my_Log.print("Start button clicked!\n" +
                "Now running!\n");
    }

    @FXML
    void one_step_forward(ActionEvent event) {
        my_Log.print("Next button pressed:\n" +
                "Go to next action\n");
    }

    @FXML
    void pause_running(ActionEvent event) {
        my_Log.print("Pause button pressed:\n" +
                "Stop action\n");
    }

    @FXML
    void one_step_backward(ActionEvent event) {
        my_Log.print("Backward button pressed:\n" +
                "Go to previous action\n");
    }

    @FXML
    void back_to_start(ActionEvent event) {
        my_Log.print("Reset button pressed:\n" +
                "Back to top\n");

    }

    @FXML
    void cancel_program(ActionEvent event) {
        System.out.println("Cancel button pressed:\n" +
                "Now exiting\n");
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void generate_random(ActionEvent event) {
        my_Log.print("Random button pressed:\n" +
                "Generating new random values");

        //Get parameters of rectangles
        visual_board.getChildren().clear();
        int no_of_rect = (int) Math.round(visual_board.getWidth() / 15);
        float width_per_rect = (float) visual_board.getWidth() / no_of_rect;

        Array_Controller my_Array = new Array_Controller();
        my_Array.make(no_of_rect);

        //Paint rectangles
        my_Log.print("Now painting array");
        painter.paint_new_rect(no_of_rect, width_per_rect, my_Array);

        my_Log.print("Finish painting\n");
    }


    public Pane getVisual_board() {
        return visual_board;
    }
}


