package com.example.igo;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class iGoController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField loginLabel2;

    @FXML
    private TextField loginLabel3;

    @FXML
    private TextField Signup_TextField1;

    @FXML
    private TextField Signup_TextField2;

    @FXML
    private TextField Signup_TextField3;

    @FXML
    private TextField Signup_TextField4;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onCreateNewAccountButtonClick(ActionEvent event) {
       System.out.println("Sign Up");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onRegisterButtonClick(ActionEvent event) {
        String firstname = Signup_TextField1.getText();
        String lastname = Signup_TextField2.getText();
        String id= Signup_TextField3.getText();
        String password= Signup_TextField4.getText();
        System.out.println(firstname+" "+lastname+" "+id+" "+password);
        if (firstname.isEmpty() || lastname.isEmpty() || id.isEmpty()|| password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the details");

            alert.showAndWait();
        }
        else
        {
            System.out.println("Registration Successful");


            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText("User Registration completed Successfully");

                alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }



    @FXML
    protected void onSignInButtonClick(ActionEvent event) {
        String username = loginLabel2.getText();
        String password = loginLabel3.getText();

        if (username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Username cannot be empty!");

            alert.showAndWait();
        }
        else if (password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password cannot be empty!");

            alert.showAndWait();
        }
        else {
            // Validate Login
            System.out.println("Username: " + username + ", Password: " + password);
            if(username.equals("Alpha") && password.equals("Alpha")) {
                System.out.println("login successful");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Login Unsuccessful");

                alert.showAndWait();
            }
        }
    }
}