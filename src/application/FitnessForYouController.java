package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FitnessForYouController {
	Stage applicationStage;
    @FXML
    private ChoiceBox<?> weekExerciseChoiceBox;
    
    @FXML 
    private TextField runningDistanceTextField;

   @FXML
   private Label runningLabel;
   
   @FXML 
   private Label caloriesBurned;
   
   @FXML 
   private Button calculate;

    @FXML
    void bmiCalculate(ActionEvent event) {
    	
    }

    @FXML
    void workoutDisplay(ActionEvent event) {
    	
    }
    
 //this method will set the scene that displays the textbox for distance ran, user can enter the distance 
 //scene has button to calculate the calories burned and label to display the calories burned
    @FXML 
    	void running (ActionEvent event) {
    		Scene mainScene = applicationStage.getScene();
    		
    		VBox runningContainer = new VBox();
    		
// text box with its label in a h box	
    			HBox distanceR = new HBox();
    			Label runningLabel = new Label("Distance Ran in Kilometers");
    			TextField runningDistanceTextField = new TextField();
// adding label and text box to H box  			
    			distanceR.getChildren().addAll(runningLabel, runningDistanceTextField);
// adding the H box to the V box     			
    			runningContainer.getChildren().add(distanceR);
    			
    			
 // the label that will display calories    			
    			Label caloriesBurned = new Label("Calories Burned: ");
 // this button will call another method that will calculate the calories    			
    			Button calculate = new Button("Calculate The Number Of Calories Burned During Your Exersize");
    			//need to add set on action to method that calculates 
    			//
    			
    			runningContainer.getChildren().addAll(caloriesBurned, calculate);
    			
    		Scene runningScene = new Scene(runningContainer);
    		applicationStage.setScene(runningScene);
    }
// this method will calculate the calories burned running using the calculate class 
    void calculateCalories (Scene runningScene ) {
    	//need to add a get value for the weight 
    	int MET = 8;
    	double bodyWeight = 0.0;
    	double totalCaloriesBurned = 0.0;
    	
    	//this takes the distance entered by the use and converts it to a double 
    	//need to do the same for weight
    	
    	String Distance=runningDistanceTextField.getText(); 
    	Double distanceRan = Double.parseDouble(Distance);
 //this invokes the class that calculates the calories burned
    	CountR caloriesR = new CountR(MET, distanceRan, bodyWeight);
 //calories will be caluclated in the Countr class using the getCalorieCalc method
    	totalCaloriesBurned += caloriesR.getCalorieCalc();
 //updatelabel
    	caloriesBurned.setText(String.format("Calories Burned: "+totalCaloriesBurned));
   
    }

}

