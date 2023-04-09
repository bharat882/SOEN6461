package com.example.igo;

import com.example.igo.model.SqliteJDBC;
import com.example.igo.model.Ticket;
import com.example.igo.model.Transactions;
import com.example.igo.model.User;
import javafx.event.ActionEvent;
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
import java.util.ArrayList;

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

    private static User user;
    private static ArrayList<Transactions> transactionsArrayList;
    private static ArrayList<Ticket> ticketArrayList;

    @FXML
    void onSelectRouteButtonClick(ActionEvent event)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selectRoute.fxml"));
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
    protected void onCancelButtonClick(ActionEvent event)
    {
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


    @FXML
    protected void onCancelButton1Click(ActionEvent event)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomePage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void onManageRoutesButtonClick(ActionEvent event){
        // TODO: implement logic for Managing Routes
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageRoutes.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void onManageStationsButtonClick(ActionEvent event){
        // TODO: implement logic for Managing Stations
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageStations.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void onManageFareButtonClick(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageFare.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void onManageDatabaseButtonClick(){
        // TODO: implement logic for Managing Fare
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Manage Database");
        alert.setHeaderText(null);
        alert.setContentText("This button will be used to Manage Database");
        alert.showAndWait();
    }

    @FXML protected void onLogoutButtonClick(ActionEvent event) throws IOException{
        try {
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

    @FXML
    protected void onViewUsersButtonClick(ActionEvent event){
        //LOGIC FOR VIEW USERS BUTTON ON ADMIN HOME PAGE
        System.out.println("LOGIC FOR VIEW USERS BUTTON ON ADMIN HOME PAGE");
        // TODO: implement logic for Viewing Users
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewUsers.fxml"));
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
    protected void onSignUpCancelButtonClick(ActionEvent event) throws IOException {
        //LOGIC FOR CANCEL BUTTON ON SIGN UP PAGE
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void onViewTransactionHistoryButtonClick(ActionEvent event){
        //LOGIC FOR VIEW TRANSACTION HISTORY BUTTON ON USER HOMEPAGE

        transactionsArrayList = SqliteJDBC.viewTransactions(user.getUserId());

        for(Transactions t: transactionsArrayList){
            System.out.println(t.toString());
        }
        // TODO: implement logic for displaying transaction history - transactionsArrayList
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("View Transaction History");
        alert.setHeaderText(null);
        alert.setContentText("This button will show the transaction history.");
        alert.showAndWait();


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewTransactionHistory.fxml"));
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
    protected void onViewAvailableTicketsButtonClick(ActionEvent event){

        // LOGIC FOR VIEW AVAILABLE TICKET BUTTON IN HOMEPAGE
    //    System.out.println("View Available Tickets");
        ticketArrayList = SqliteJDBC.viewAvailableTickets(user.getUserId());
        for(Ticket t: ticketArrayList){
            System.out.println(t.toString());
        }
        // TODO: Add GUI To display tickets

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewAvailableTickets.fxml"));
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
    protected void onRequestTripInfoButtonClick(){

        // LOGIC FOR Select Route BUTTON IN HOMEPAGE
        System.out.println("Select Route");

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
            user = SqliteJDBC.authenticateUser(username, password);
            if(user!=null){
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
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Login Unsuccessful");

                alert.showAndWait();
            }
            /*if(username.equals("a") && password.equals("a")) {
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
            else if(username.equals("b") && password.equals("b"))
            {
                System.out.println("login successful");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomePage.fxml"));
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
            } */
        }
    }
}