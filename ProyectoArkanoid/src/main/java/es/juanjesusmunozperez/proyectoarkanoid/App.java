package es.juanjesusmunozperez.proyectoarkanoid;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App Copia low-cost Arkanoid by JJ
 */
public class App extends Application {
    
    int ballCenterY = 525;
    int ballCurrentSpeedY = 3;
    int ballCenterX = 400;
    int ballCurrentSpeedX = 3;
    int stickPosX = 400-37;
    final int SCENE_TAM_X = 820;
    final int SCENE_TAM_Y = 600;
    final int STICK_WIDTH = 75;
    final int STICK_HEIGHT = 8;
    int stickCurrentSpeed = 0;
    final int widthBrick = 50;
    final int heightBrick = 10;

    @Override
    public void start(Stage primaryStage) {
        Pane paneRoot = new Pane();
        var scene = new Scene (paneRoot, SCENE_TAM_X, SCENE_TAM_Y);      //Tamaño de la ventana
        primaryStage.setTitle("Parkanoid");                              //Nombre que lleva la ventana
        primaryStage.setScene(scene);
        primaryStage.show();
        //Fondo
        Image img = new Image(getClass().getResourceAsStream("/images/arcade_carpet_1_512.png")); //Imagen del fondo
        ImageView imgView = new ImageView(img);
        paneRoot.getChildren().add(imgView);
        //Stick
        Rectangle rectStick = new Rectangle(stickPosX, 550, STICK_WIDTH, STICK_HEIGHT);
        rectStick.setFill(Color.CHOCOLATE);
        rectStick.setArcHeight(4);
        rectStick.setArcWidth(10);
        paneRoot.getChildren().add(rectStick);
        //Bola
        Circle circleBall = new Circle(ballCenterX, ballCenterY, 10, Color.GREEN); //Creacion de la bola, ejex, ejey, radio, color
        paneRoot.getChildren().add(circleBall);      //Introduccion de la bola a la escena
        
        Timeline animationBall = new Timeline(
                new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
                    
                    circleBall.setCenterY(ballCenterY);
                    ballCenterY+=ballCurrentSpeedY;
                    //System.out.println("Velocidad Bola Y: " + ballCurrentSpeedY);
                    //Limites de salida de la bola
                    if(ballCenterY <= 0) {
                        //System.out.println("Bola fuera de pantalla superior " + ballCenterY);
                        ballCurrentSpeedY = 3;
                        //System.out.println("Cambio velocidad bola Y: "+ ballCurrentSpeedY);
                    }
                    /*if(ballCenterY >= SCENE_TAM_Y){
                        ballCurrentSpeedY = -3;
                    }*/
                    
                    circleBall.setCenterX(ballCenterX);     
                    ballCenterX += ballCurrentSpeedX;
                    if(ballCenterX >= SCENE_TAM_X) {
                        ballCurrentSpeedX = -3;
                    }
                    if(ballCenterX <= 0) {
                        ballCurrentSpeedX = 3;
                    }
                    
                    
                    stickPosX += stickCurrentSpeed;
                   
                    //Limites de salida de la pala
                    if(stickPosX < 0){
                        stickPosX = 0;
                    }else{
                        if(stickPosX > SCENE_TAM_X - STICK_WIDTH){
                            stickPosX = SCENE_TAM_X - STICK_WIDTH;
                        }
                    }
                    rectStick.setX(stickPosX);
                    
                    //Colision Pala bola
                    Shape shapeColision = Shape.intersect(circleBall, rectStick);
                    boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                        if(colisionVacia == false){
                            ballCurrentSpeedY = -3;
                    }
                        
                                    
                    
                                                        
                })
        
        );
        animationBall.setCycleCount(Timeline.INDEFINITE);
        animationBall.play();
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case LEFT:
                    stickCurrentSpeed = -6;
                    break;
                case RIGHT:
                    stickCurrentSpeed = 6;
                    break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            stickCurrentSpeed = 0;
        });
        
        //Creacion de ladrillos
        Random color = new Random();
        Rectangle brick = new Rectangle(25, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick);
        brick.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick2 = new Rectangle(85, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick2);
        brick2.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick3 = new Rectangle(145, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick3);
        brick3.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick4 = new Rectangle(205, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick4);
        brick4.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick5 = new Rectangle(265, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick5);
        brick5.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick6 = new Rectangle(325, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick6);
        brick6.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick7 = new Rectangle(385, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick7);
        brick7.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick8 = new Rectangle(445, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick8);
        brick8.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick9 = new Rectangle(505, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick9);
        brick9.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick10 = new Rectangle(565, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick10);
        brick10.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick11 = new Rectangle(625, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick11);
        brick11.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick12 = new Rectangle(685, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick12);
        brick12.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick13 = new Rectangle(745, 60, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick13);
        brick13.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick14 = new Rectangle(85, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick14);
        brick14.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick15 = new Rectangle(145, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick15);
        brick15.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick16 = new Rectangle(205, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick16);
        brick16.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick17 = new Rectangle(265, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick17);
        brick17.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick18 = new Rectangle(325, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick18);
        brick18.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick19 = new Rectangle(385, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick19);
        brick19.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick20 = new Rectangle(445, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick20);
        brick20.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick21 = new Rectangle(505, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick21);
        brick21.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick22 = new Rectangle(565, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick22);
        brick22.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick23 = new Rectangle(625, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick23);
        brick23.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick24 = new Rectangle(685, 90, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick24);
        brick24.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick25 = new Rectangle(25, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick25);
        brick25.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick26 = new Rectangle(85, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick26);
        brick26.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick27 = new Rectangle(145, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick27);
        brick27.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick28 = new Rectangle(205, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick28);
        brick28.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick29 = new Rectangle(265, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick29);
        brick29.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick30 = new Rectangle(325, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick30);
        brick30.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick31 = new Rectangle(385, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick31);
        brick31.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick32 = new Rectangle(445, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick32);
        brick32.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick33 = new Rectangle(505, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick33);
        brick33.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick34 = new Rectangle(565, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick34);
        brick34.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick35 = new Rectangle(625, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick35);
        brick35.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick36 = new Rectangle(685, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick36);
        brick36.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Rectangle brick37 = new Rectangle(745, 120, widthBrick, heightBrick);
        paneRoot.getChildren().add(brick37);
        brick37.setFill(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        
        Timeline animationBrick = new Timeline (
                new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) ->{
                    Shape shapeColision = Shape.intersect(circleBall, brick);
                    boolean colision = shapeColision.getBoundsInLocal().isEmpty();
                    if(colision == false) {
                        ballCurrentSpeedY = 3;
                        brick.setVisible(false);
                        brick.setY(900);
                }
                    Shape shapeColision2 = Shape.intersect(circleBall, brick2);
                    boolean colision2 = shapeColision2.getBoundsInLocal().isEmpty();
                    if(colision2 == false) {
                        ballCurrentSpeedY = 3;
                        brick2.setVisible(false);
                        brick2.setY(900);
                }
                    Shape shapeColision3 = Shape.intersect(circleBall, brick3);
                    boolean colision3 = shapeColision3.getBoundsInLocal().isEmpty();
                    if(colision3 == false) {
                        ballCurrentSpeedY = 3;
                        brick3.setVisible(false);
                        brick3.setY(900);
                }
                    Shape shapeColision4 = Shape.intersect(circleBall, brick4);
                    boolean colision4 = shapeColision4.getBoundsInLocal().isEmpty();
                    if(colision4 == false) {
                        ballCurrentSpeedY = 3;
                        brick4.setVisible(false);
                        brick4.setY(900);
                }
                    Shape shapeColision5 = Shape.intersect(circleBall, brick5);
                    boolean colision5 = shapeColision5.getBoundsInLocal().isEmpty();
                    if(colision5 == false) {
                        ballCurrentSpeedY = 3;
                        brick5.setVisible(false);
                        brick5.setY(900);
                }
                    
                    
                }
        ));
        animationBrick.setCycleCount(Timeline.INDEFINITE);
        animationBrick.play();
        
    }

    public static void main(String[] args) {
        launch();
    }

}