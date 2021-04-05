package intern_java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    public Label welcomeLabel;
    public ChoiceBox<String> choiceBox;
    public TextField textField;
    public Button convertButton;

    private static final String  C_TO_F ="Celcius to Fahrenheit";
    private static final String  F_TO_C ="Fahrenheit to Celcius";
    private boolean isC_TO_F =true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    choiceBox.getItems().add(C_TO_F);
    choiceBox.getItems().add(F_TO_C);

    choiceBox.setValue(C_TO_F) ;

    choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue)-> {
        if (newValue.equals(C_TO_F)) {
            isC_TO_F = true;
        } else{
            isC_TO_F=false;
        }
    });
        convertButton.setOnAction(event ->{
        convert();
        });
    }

    private void convert() {
      String input=textField.getText();
        float temperature = 0.0f;
      try {
           temperature = Float.parseFloat(input);
      } catch(Exception exception){
          warning();
          return;
      }
      float newTemperature= 0.0f;
      if(isC_TO_F){
          newTemperature=(temperature*9/5)+32;
      }else{
          newTemperature=(temperature-32)*5/9;
      }
      display(newTemperature);
      }

    private void warning() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Some Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid Temperature");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit=isC_TO_F? "F":"C";
        System.out.println("The new temperature is:" +newTemperature+unit);
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The New Temperature is: "+newTemperature+unit);
        alert.show();
    }


}
