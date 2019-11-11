package sample;

import javafx.application.Application;

import javafx.scene.control.Label;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("The Rock,Paper and Scissors game");

        GridPane gridPane = new GridPane();


        Random r_num = new Random();//used to generate random numbers that will be used to select rock, paper or scissors for the cpu
        AtomicInteger PLayer_count = new AtomicInteger();
        AtomicInteger CPU_count = new AtomicInteger();


        //Images used
        InputStream cpu_img1 = getClass().getResourceAsStream("/CPU_tools/CPU_PaperV2.png");
        Image cpu_image_take1 = new Image(cpu_img1);

        InputStream cpu_img2 = getClass().getResourceAsStream("/CPU_tools/CPU_RockV2.png");
        Image cpu_image_take2 = new Image(cpu_img2);

         InputStream cpu_img3 = getClass().getResourceAsStream("/CPU_tools/CPU_ScissorsV2.png");
        Image cpu_image_take3 = new Image(cpu_img3);

         InputStream User_img1 = getClass().getResourceAsStream("/User_tools/PaperV2.png");
        Image image_take1 = new Image(User_img1);

         InputStream User_img2 = getClass().getResourceAsStream("/User_tools/RockV2.png");
        Image image_take2 = new Image(User_img2);

         InputStream User_img3 = getClass().getResourceAsStream("/User_tools/ScissorsV2.png");
         Image image_take3 = new Image(User_img3);




//Declaring labels
        Label label1 = new Label("CPU: On Standby");
        label1.setStyle("-fx-font-size: 20px;");

        Label label2 = new Label("Rock, Paper or Scissors");
        label2.setStyle("-fx-font-size: 20px;");

        Label label3 = new Label("CPU:      Player:  ");
        label3.setStyle("-fx-font-size: 20px;");

        Label label4 = new Label("Winner: ");
        label4.setStyle("-fx-font-size: 20px;");


        //Declaring Buttons
        //Reset button action
        Button Reset_Button = new Button("Reset");
        Reset_Button.setMinWidth(100);
        Reset_Button.setMinHeight(50);
        Reset_Button.setStyle("-fx-font-size: 20px;");
        Reset_Button.setOnAction(value -> {label2.setText("Rock, Paper or Scissors");label2.setGraphic(null);
        label1.setText("CPU: On Standby");
        label1.setGraphic(null);
        label3.setText("CPU:        Player:  ");
        label4.setText("Winner: ");
        CPU_count.set(0);
        PLayer_count.set(0);

        });


     //Rock Button and its action
        Button Rock_Button = new Button("Rock");
        Rock_Button.setMinWidth(100);
        Rock_Button.setMinHeight(50);
        Rock_Button.setStyle("-fx-font-size: 20px;");
        Rock_Button.setOnAction(value -> {




            label2.setText("Rock Clicked");
            label2.setGraphic(new ImageView(image_take2));


        int num = r_num.nextInt(3);
        if(num == 0)
        {
            label1.setText("CPU: Rock");
            label1.setGraphic(new ImageView(cpu_image_take2));
            label4.setText("Draw");
        }
        if(num == 1)
        {
            label1.setText("CPU: Paper");
            label1.setGraphic(new ImageView(cpu_image_take1));
            label4.setText("Winner: CPU ");
            CPU_count.getAndIncrement();

            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);
        }
        if(num == 2)
        {
            label1.setText("CPU: Scissors");
            label1.setGraphic(new ImageView(cpu_image_take3));
            label4.setText("Winner: Player ");
            PLayer_count.getAndIncrement();
            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);
        }
        });

//Paper Button and its action
        Button Paper_Button = new Button("Paper");
        Paper_Button.setMinWidth(100);
        Paper_Button.setMinHeight(50);
        Paper_Button.setStyle("-fx-font-size: 20px;");
        Paper_Button.setOnAction(value -> {
            label2.setText("Paper Clicked");


            label2.setGraphic(new ImageView(image_take1));

       int num = r_num.nextInt(3);
        if(num == 0)
        {
            label1.setText("CPU: Rock");
            label1.setGraphic(new ImageView(cpu_image_take2));
            label4.setText("Winner: Player ");
            PLayer_count.getAndIncrement();
            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);
        }
        if(num == 1)
        {
            label1.setText("CPU: Paper");
            label1.setGraphic(new ImageView(cpu_image_take1));
            label4.setText("Draw");
        }
        if(num == 2)
        {
            label1.setText("CPU: Scissors");
            label1.setGraphic(new ImageView(cpu_image_take3));
            label4.setText("Winner: CPU ");
            CPU_count.getAndIncrement();
            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);

        }
        });

//Scissors Button and its action
        Button Scissors_Button = new Button("Scissors");
        Scissors_Button.setMinWidth(100);
        Scissors_Button.setMinHeight(50);
        Scissors_Button.setStyle("-fx-font-size: 20px;");
        Scissors_Button.setOnAction(value -> {
            label2.setText("Scissor Clicked");


            label2.setGraphic(new ImageView(image_take3));

        int num = r_num.nextInt(3);
        if(num == 0)
        {
            label1.setText("CPU: Rock");
            label1.setGraphic(new ImageView(cpu_image_take2));
            label4.setText("Winner: CPU ");
            CPU_count.getAndIncrement();
            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);
        }
        if(num == 1)
        {
            label1.setText("CPU: Paper");
            label1.setGraphic(new ImageView(cpu_image_take1));
            label4.setText("Winner: Player ");
            PLayer_count.getAndIncrement();
            label3.setText("CPU: " + CPU_count +    "Player: " + PLayer_count);
        }
        if(num == 2)
        {
            label1.setText("CPU: Scissors");
            label1.setGraphic(new ImageView(cpu_image_take3));
            label4.setText("Draw");
        }
        });


        //grid layout of the components
        gridPane.setHgap(30);
        gridPane.setVgap(90);
        gridPane.add(Reset_Button, 0, 0, 1, 1);
        gridPane.add(Scissors_Button, 2, 5, 1, 1);
        gridPane.add(Paper_Button, 1, 5, 1, 1);
        gridPane.add(Rock_Button, 0, 5, 1, 1);
        gridPane.add(label1,3,0,1,1);
        gridPane.add(label2,3,5,2,1);
        gridPane.add(label3,0,3,1,1);
        gridPane.add(label4, 3,3,2,1);


        //Display components on GUI
        Scene scene = new Scene(gridPane, 750,900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
