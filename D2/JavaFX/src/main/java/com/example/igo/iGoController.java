package com.example.igo;

import com.example.igo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class iGoController {
    private static User user;
    private static ArrayList<Transactions> transactionsArrayList;
    private static ArrayList<Ticket> ticketArrayList;
    private static ArrayList<Fare> fareArrayList;
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
    void onSelectRouteButtonClick(ActionEvent event) {
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
    protected void onCancelButtonClick(ActionEvent event) {
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
    protected void onCancelButton1Click(ActionEvent event) {
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

    @FXML
    protected void onManageRoutesButtonClick(ActionEvent event) {
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

    @FXML
    protected void onManageStationsButtonClick(ActionEvent event) {
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

    @FXML
    protected void onManageFareButtonClick(ActionEvent event) {
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

    @FXML
    protected void onManageDatabaseButtonClick() {
        // TODO: implement logic for Managing Fare
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Manage Database");
        alert.setHeaderText(null);
        alert.setContentText("This button will be used to Manage Database");
        alert.showAndWait();
    }

    @FXML
    protected void onLogoutButtonClick(ActionEvent event) throws IOException {
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
    protected void onViewUsersButtonClick(ActionEvent event) {
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
    protected void onViewTransactionHistoryButtonClick(ActionEvent event) {
        //LOGIC FOR VIEW TRANSACTION HISTORY BUTTON ON USER HOMEPAGE

        transactionsArrayList = SqliteJDBC.viewTransactions(user.getUserId());

        for (Transactions t : transactionsArrayList) {
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
    protected void onViewAvailableTicketsButtonClick(ActionEvent event) {

        // LOGIC FOR VIEW AVAILABLE TICKET BUTTON IN HOMEPAGE
        //    System.out.println("View Available Tickets");
        ticketArrayList = SqliteJDBC.viewAvailableTickets(user.getUserId());
        for (Ticket t : ticketArrayList) {
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
    protected void onRequestTripInfoButtonClick(ActionEvent event) throws Exception {

        // LOGIC FOR Select Route BUTTON IN HOMEPAGE
        fareArrayList = SqliteJDBC.showAvailableFares(user.getUserId());
        Set<String> fareTypesSet = new HashSet<>();
        Set<String> ticketTypesSet = new HashSet<>();
        for (Fare f : fareArrayList) {
            System.out.println(f.toString());
            fareTypesSet.add(f.getFareType());
            ticketTypesSet.add(f.getFareTitle());
        }

        // TODO: Add gui to select one of the fare/ticket returned by the above method.

        // This function will take the fare object returned by the gui (the one selected by the user), userid, and payment mode mentioned by the user
        // Replace new Fare() with Fare object, and payment type to string of payment type selected by user
        // method with return true if the process was successfully completed, else false
        //boolean payment = SqliteJDBC.processTicket(user.getUserId(), new Fare(), "Somepayment type");
        Fare newFare = new Fare();
        Label titleLabel = new Label("iGo");
        titleLabel.setStyle("-fx-font-size: 48pt; -fx-font-weight: bold;");
        Label fareTypeLabel = new Label("Select Ticket type");

        Button amountButton = new Button("Get Amount");
        Label amountLabel = new Label("0");

        // Create the combo boxes
        ComboBox<String> fareTypesComboBox = new ComboBox<>();
        fareTypesComboBox.setPromptText("Select a fare type");
        for (String fType : fareTypesSet) {
            fareTypesComboBox.getItems().add(fType);
        }


        ComboBox<String> ticketTypesComboBox = new ComboBox<>();
        ticketTypesComboBox.setPromptText("Select a ticket type");
        for (String tType : ticketTypesSet) {
            ticketTypesComboBox.getItems().add(tType);
        }


        amountButton.setOnAction(e -> {
            System.out.println("Inside get amount");
            String selectedFareType = fareTypesComboBox.getValue();
            String selectedTicketType = ticketTypesComboBox.getValue();
            newFare.setFareType(selectedFareType);
            newFare.setFareTitle(selectedTicketType);
            for (Fare f : fareArrayList) {
                if (Objects.equals(f.getFareType(), selectedFareType) && Objects.equals(f.getFareTitle(), selectedTicketType)) {
                    amountLabel.setText(String.valueOf(f.getFareAmount()));
                    newFare.setFareAmount(f.getFareAmount());
                    newFare.setFareDescription(f.getFareDescription());
                    newFare.setFareId(f.getFareId());
                }
            }
        });

        ComboBox<String> paymentTypesComboBox = new ComboBox<>();
        paymentTypesComboBox.setPromptText("Select a payment method");
        paymentTypesComboBox.getItems().addAll("Pay by card", "Pay with cash");
        Button paymentButton = new Button("Pay");
        paymentButton.setOnAction(e -> {
            if(paymentTypesComboBox.getValue().equals("Pay by card")){
                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL); // Set modality to block input to other windows
                popupStage.setTitle("Popup Window");

                // Create the content for the popup
                VBox popupContent = new VBox();
                Label popupLabel = new Label("Please use pin pad to complete the transaction");
                Button closeButton = new Button("Close");
                closeButton.setOnAction(e1 -> {
                    popupStage.close();
                    System.out.println(user.getUserId() + " " + newFare.toString());
                    boolean payment = SqliteJDBC.processTicket(user.getUserId(), newFare, "Visa");
                    if(payment){
                        System.out.println("Successful");
                    }
                    else{
                        System.out.println("Unsuccessful");
                    }
                });
                popupContent.getChildren().addAll(popupLabel, closeButton);
                popupContent.setAlignment(Pos.CENTER);

                // Set the scene for the popup stage
                Scene popupScene = new Scene(popupContent, 300, 200);
                popupStage.setScene(popupScene);

                // Show the popup stage
                popupStage.showAndWait();
            }
        });


        // Create the buttons
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> onCancelButtonClick(e));

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            try {
                onLogoutButtonClick(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Create the HBoxes
        HBox topHBox = new HBox(titleLabel);
        topHBox.setAlignment(Pos.CENTER);

        HBox fareTypeHBox = new HBox(fareTypesComboBox, ticketTypesComboBox);
        fareTypeHBox.setAlignment(Pos.CENTER);
        fareTypeHBox.setSpacing(20);

        HBox amountHBox = new HBox(amountButton, amountLabel);
        amountHBox.setAlignment(Pos.CENTER);
        amountHBox.setSpacing(20);

        HBox paymentBox = new HBox(paymentTypesComboBox, paymentButton);
        paymentBox.setAlignment(Pos.CENTER);
        paymentBox.setSpacing(20);

        HBox buttonHBox = new HBox(cancelButton, logoutButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);

        // Create the VBox
        VBox root = new VBox(topHBox, fareTypeLabel, fareTypeHBox, amountHBox, paymentBox, buttonHBox);
        root.setSpacing(30);
        root.setPrefWidth(800);
        root.setPrefHeight(600);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
        String id = Signup_TextField3.getText();
        String password = Signup_TextField4.getText();
        System.out.println(firstname + " " + lastname + " " + id + " " + password);
        if (firstname.isEmpty() || lastname.isEmpty() || id.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the details");

            alert.showAndWait();
        } else {
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
        } else if (password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Password cannot be empty!");

            alert.showAndWait();
        } else {
            // Validate Login
            System.out.println("Username: " + username + ", Password: " + password);
            user = SqliteJDBC.authenticateUser(username, password);
            if (user != null) {
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

            } else {
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