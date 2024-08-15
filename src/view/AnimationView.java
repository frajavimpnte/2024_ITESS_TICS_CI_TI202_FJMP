/*
 * ITES-TICS Enero-Junio 2024
 * Matemáticas aplicadas a comunicaciones
 * TI401 Alumno: 
 * DOCENTE: FJMP
 * Descripción: vista del Drone
 * 16 / febrero / 2024
 */
package view;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.function.Predicate;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tools.Coordinate;

public class AnimationView extends Application {
    // low level graphics
    private GraphicsContext g;
    
    // app size
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
       
    // canvas draw size
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 400;
    
    // font size
    private final int FONT_SIZE = 12;
    
    // simulation time
    private double t = 0.0;
    private double deltaT = 0.017;
    AnimationTimer timer;
    
    // input field
    ValidatingTextField field;
    
    // coordinate tranformation
    Coordinate coor = new Coordinate(
            -200,200,
            -200, 200,
            CANVAS_WIDTH, CANVAS_HEIGHT);
    
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
      
        // Buttons HBox 
        HBox hBoxButtons = new HBox(10); 
        hBoxButtons.setAlignment(Pos.CENTER);
        var btnStart = new Button("Start");
        btnStart.setFont(Font.font(FONT_SIZE));
        //btnStart.disableProperty().bind(field.isValidProperty.not());
        btnStart.setOnAction(e -> { 
            deltaT = Double.parseDouble(field.getText());
            timer.start(); 
        });
        
        var btnStop = new Button("Stop");
        btnStop.setFont(Font.font(FONT_SIZE));
        //btnStop.disableProperty().bind(field.isValidProperty.not());
        btnStop.setOnAction(e -> { timer.stop(); });
        
        hBoxButtons.getChildren().addAll(btnStart, btnStop);
        
        //TextField and validation for time
        var hBoxLabel = new HBox(10);
        hBoxLabel.setAlignment(Pos.CENTER);
        
        var label = new Label();
        label.setText("Time: ");
        
        field = new ValidatingTextField( input -> input.contains("."));
        field.setText("0.017");
        
        field.setFont(Font.font(FONT_SIZE));
        hBoxLabel.getChildren().addAll(label, field);
        
        // Canvas for drawing
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.ORANGE);
        g.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        
        // animation time loop
         timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += deltaT;
                System.out.println("t:" + t);
                draw();
            }
        };
        
        VBox vBox = new VBox(10);

        vBox.setBackground(Background.EMPTY);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBoxButtons,  hBoxLabel, canvas);
        root.getChildren().add(vBox);
        
        return root;
    }
    
    private static class ValidatingTextField extends TextField {
        private final Predicate<String> validation;
        private BooleanProperty isValidProperty = new SimpleBooleanProperty();
        
        ValidatingTextField(Predicate<String> validation) {
            this.validation = validation;
            
            textProperty().addListener((o, oldValue, newText) -> {
                isValidProperty.set(validation.test(newText));
                System.out.println("input" + newText);
            });
        }
    }
    private void draw() {
        Point2D p = curveFunction();
        
        g.setStroke(Color.BLACK);
        
        //double x = CANVAS_WIDTH/2 + p.getX();
        //double y = CANVAS_HEIGHT/2+ p.getY();
        
        double x =  p.getX();
        double y =  p.getY();
        System.out.println("x:" + x +" y:" + y);
        
        g.strokeOval(coor.toScreenX(x), coor.toScreenY(y), 1 , 1);
    }
    
    private Point2D curveFunction() {
        double x = Math.sin(t)*(Math.pow(Math.E, Math.cos(t)) 
                - 2 * Math.cos(4*t) - Math.pow(Math.sin(t/12), 5));
        double y = Math.cos(t) *(Math.pow(Math.E, Math.cos(t)) 
                - 2 * Math.cos(4*t) - Math.pow(Math.sin(t/12), 5));
        
        return new Point2D(x,y).multiply(50);
    }
    
    @Override 
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setTitle("Animation function with thread!");
        stage.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
