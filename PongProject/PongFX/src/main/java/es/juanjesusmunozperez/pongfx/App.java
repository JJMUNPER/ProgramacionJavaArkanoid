package es.juanjesusmunozperez.pongfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {
    
    int ballCenterX = 10;
    int ballCurrentSpeedX = 3;
    int ballCenterY = 30;
    int ballCurrentSpeedY = 3;
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 400;
    final int STICK_WIDTH = 7;
    final int STICK_HEIGHT = 50;
    int stickPosY = (SCENE_TAM_Y - STICK_HEIGHT) / 2;
    int stickCurrentSpeed = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
              
        
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_TAM_X, SCENE_TAM_Y);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("PongFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Circle circleBall = new Circle(ballCenterX, ballCenterY,7,Color.WHITE); 
        root.getChildren().add(circleBall);
        
        Rectangle rectStick = new Rectangle(SCENE_TAM_X*0.9, stickPosY, STICK_WIDTH, STICK_HEIGHT);
        rectStick.setFill(Color.WHITE);
        root.getChildren().add(rectStick);
        
        Timeline animationBall = new Timeline(
                new KeyFrame (Duration.seconds(0.017), (ActionEvent ae) -> {
                    circleBall.setCenterX(ballCenterX);
                    ballCenterX += ballCurrentSpeedX;
                    if(ballCenterX >= SCENE_TAM_X) {
                        ballCurrentSpeedX = -3;
                    }
                    if(ballCenterX <= 0) {
                        ballCurrentSpeedX = 3;
                    }
                    circleBall.setCenterY(ballCenterY);
                    ballCenterY += ballCurrentSpeedY;
                    if(ballCenterY >= SCENE_TAM_Y) {
                        ballCurrentSpeedY = -3;
                    }
                    if(ballCenterY <= 0) {
                        ballCurrentSpeedY = 3;
                    }
                stickPosY += stickCurrentSpeed;
                if(stickPosY < 0) {
                    stickPosY = 0;
                } else {
                    if(stickPosY > SCENE_TAM_Y - STICK_HEIGHT){
                        stickPosY = SCENE_TAM_Y - STICK_HEIGHT;
                    }
                }
                rectStick.setY (stickPosY);
                 Shape shapeColision = Shape.intersect(circleBall, rectStick);
                     boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                        if(colisionVacia == false){
                        ballCurrentSpeedX = -3;
                }       
        })
               
        );
        
        for(int i = 0; i<SCENE_TAM_Y; i+=30){
            Line line = new Line(SCENE_TAM_X/2, i, SCENE_TAM_X/2, i+10);
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(4);
            root.getChildren().add(line);
        }
        
        animationBall.setCycleCount(Timeline.INDEFINITE);
        animationBall.play();
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()){
                case UP:
                    stickCurrentSpeed = -6;
                    break;
                case DOWN:
                    stickCurrentSpeed = 6;
                    break;
            }
        });
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            stickCurrentSpeed = 0;
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}