/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winterse;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author winte
 */
public class Assignment2 extends Application {
    
    @Override
    public void start(Stage firstStage) {
        Scanner input = new Scanner(System.in);
        // declaring variables for the rectangles
        double x1;
        double y1;
        double height1;
        double width1;
        double x2;
        double y2;
        double height2;
        double width2; 
        boolean overLap;
        boolean insideRec; 
         
        // inputing values for the first rectangle
        System.out.println("Please enter the x coordinate for the first rectangle: ");
        x1 = input.nextDouble();
        System.out.println("Please enter the y coordinate for the first rectangle: ");
        y1 = input.nextDouble();
        System.out.println("Please enter the height of the first rectangle: ");
        height1 = input.nextDouble();
        System.out.println("Please enter the width of the first rectangle: ");
        width1 = input.nextDouble();
        // inputing values for the second rectangle
        System.out.println("Please enter the x coordinate for the second rectangle: ");
        x2 = input.nextDouble();
        System.out.println("Please enter the y coordinate for the second rectangle: ");
        y2 = input.nextDouble();
        System.out.println("Please enter the height of the second rectangle: ");
        height2 = input.nextDouble();
        System.out.println("Please enter the width of the second rectangle: ");
        width2 = input.nextDouble();
        // Drawing the rectangles
        Rectangle rectangle1 = new Rectangle(x1, y1, width1, height1);
        Rectangle rectangle2 = new Rectangle(x2, y2, width2, height2);
        
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle2.setFill(Color.TRANSPARENT); 
        
        rectangle1.setStroke(Color.BLACK);
        rectangle2.setStroke(Color.BLACK);
        // creating a group for rectangle
        StackPane thePane = new StackPane();
        StackPane.setAlignment(thePane, Pos.CENTER);
        Group root = new Group();
     
        // assigning rectangles to the group
        root.getChildren().add(rectangle1);
        root.getChildren().add(rectangle2);
        
        // adding label text that corresponds to whether the rectangles overlap
        overLap = rectangleOverlap(rectangle1, rectangle2);
        
        insideRec = rectangleInside(rectangle1, rectangle2);
       
        if (overLap == true && insideRec == true){
            Label label1 = new Label("One rectangle is contained in another");
            label1.setWrapText(true);
            label1.setTranslateY(280);
            label1.setTranslateX(200);
            label1.setAlignment(Pos.CENTER);
            thePane.getChildren().add(label1);
            
        } else if (overLap == true && insideRec == false){
            Label label1 = new Label("The rectangles overlap");
            label1.setWrapText(true);
            label1.setTranslateY(280);
            label1.setTranslateX(200);
            label1.setAlignment(Pos.CENTER);
            thePane.getChildren().add(label1);
        }else if (overLap == false && insideRec == false){
            Label label1 = new Label("The rectangles do not overlap");
            label1.setWrapText(true);
            label1.setTranslateY(280);
            label1.setTranslateX(200);
            label1.setAlignment(Pos.CENTER);
            thePane.getChildren().add(label1);
        }
        //adding stackpane to group
        root.getChildren().add(thePane);
        
        // create the scene
        Scene scene = new Scene(root, 600, 300);
        
        // title for first stage
        firstStage.setTitle("Assignment 2");
        // add scene to the stage
        firstStage.setScene(scene);
        // display contents of the stage
        firstStage.sizeToScene(); 
        firstStage.show();
 
        
    }
    // method called rectangle overlapping to check overlapping
        public boolean rectangleOverlap(Rectangle r1, Rectangle r2){
          // boolean will return true if one rectangle overlaps another
          boolean ifOverlap = true;
          // variables to sort rectangles into their direction
          Rectangle leftR;
          Rectangle rightR;
          
          Rectangle upperR;
          Rectangle lowerR; 
          // variables to determine overlap
          int noOverLap = 0;
          int YesOverLap = 0;
          // determine Left and Right
          if (r1.getX() <= r2.getX()){
            leftR = r1;
            rightR = r2;
        }else {
              leftR = r2;
              rightR = r1;
          }
          //determine up and lower
          if (r1.getY() <= r2.getY()){
              upperR = r1;
              lowerR = r2;
          }else{
              upperR = r2;
              lowerR = r1;
          }
          
          //calc overlap
          //overlap width
          if (leftR.getX() + leftR.getWidth() <= rightR.getX()){
              //no over lap
             noOverLap++;
          }
          else if (leftR.getX() + leftR.getWidth() >= rightR.getX() + rightR.getWidth()){
              //fully overlap
              YesOverLap++; 
          }else{
              //partial overlap
              YesOverLap++;
          }
          
          //overlap height
          if (upperR.getY() + upperR.getHeight() <= lowerR.getY()){
              // no over lap
              noOverLap++;
          }else if (upperR.getY() + upperR.getHeight() >= lowerR.getY() + lowerR.getHeight()){
              // full overlap
              YesOverLap++;
          }else{
              //partial overlap
              YesOverLap++;
          }
          // asigning boolean value
          if (noOverLap > 0 && YesOverLap == 0){
              ifOverlap = false;
          }else{
              ifOverlap = true;
          }
          return ifOverlap; 
        }
        
     // method that determines if a rectangle is inside of an another rectangle
        public boolean rectangleInside(Rectangle r1, Rectangle r2){
            //boolean vaiable with return true if rectangle inside of other
           boolean ifInside = true;
           //variables to sort rectangles to their direction
          Rectangle leftR;
          Rectangle rightR;
          
          Rectangle upperR;
          Rectangle lowerR; 
          // variables to determine whether inside of eachother
          int notInside = 0;
          int YesInside = 0;
          // determine Left and Right rectangle
          if (r1.getX() <= r2.getX()){
            leftR = r1;
            rightR = r2;
        }else {
              leftR = r2;
              rightR = r1;
          }
          //determine up and lower rectangle
          if (r1.getY() <= r2.getY()){
              upperR = r1;
              lowerR = r2;
          }else{
              upperR = r2;
              lowerR = r1;
          }
          
          //calc whether inside
          // width
          if (leftR.getX() + leftR.getWidth() <= rightR.getX()){
              //not inside
             notInside++;
          }
          else if (leftR.getX() + leftR.getWidth() >= rightR.getX() + rightR.getWidth()){
              //fully inside
              YesInside++; 
          }else{
              // not inside
              notInside++;
          }
          
          //height
          if (upperR.getY() + upperR.getHeight() <= lowerR.getY()){
              // not inside
              notInside++;
          }else if (upperR.getY() + upperR.getHeight() >= lowerR.getY() + lowerR.getHeight()){
              // fully inside
              YesInside++;
          }else{
              //not inside
              notInside++;
          }
          //assigning boolean
          if (notInside == 0 && YesInside > 0){
              ifInside = true; 
          }else{
              ifInside = false;
          }
          return ifInside; 
        }
    public static void main(String args[]){ 
         
      // launch the application
      launch(args); 
      
      
      
   } 
    
}
