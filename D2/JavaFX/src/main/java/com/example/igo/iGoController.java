package com.example.igo;

import com.example.igo.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
    private TextField usernameField;
    @FXML
    private TextField passwordField;
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

        // TODO: implement logic for displaying transaction history - transactionsArrayList
        TableView<Transactions> tableView = new TableView();
        TableColumn<Transactions, String> firstColumnName = new TableColumn<>("Transaction date");
        firstColumnName.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));

        TableColumn<Transactions, String> secondColumnName = new TableColumn<>("Amount($)");
        secondColumnName.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Transactions, String> thirdColumnName = new TableColumn<>("Payment method");
        thirdColumnName.setCellValueFactory(new PropertyValueFactory<>("paymentMode"));

        tableView.getColumns().addAll(firstColumnName, secondColumnName, thirdColumnName);

        ObservableList<Transactions> transactionsData = FXCollections.observableArrayList(transactionsArrayList);
        tableView.setItems(transactionsData);
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

        HBox buttonHBox = new HBox(cancelButton, logoutButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);

        VBox root = new VBox(tableView, buttonHBox);
        root.setSpacing(20);
        root.setPrefWidth(600);
        root.setPrefHeight(400);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onViewAvailableTicketsButtonClick(ActionEvent event) {

        // LOGIC FOR VIEW AVAILABLE TICKET BUTTON IN HOMEPAGE
        //    System.out.println("View Available Tickets");
        ticketArrayList = SqliteJDBC.viewAvailableTickets(user.getUserId());
        // TODO: Add GUI To display tickets

        TableView<Ticket> tableView = new TableView();
        TableColumn<Ticket, String> firstColumnName = new TableColumn<>("Ticket type");
        firstColumnName.setCellValueFactory(new PropertyValueFactory<>("ticketType"));

        TableColumn<Ticket, String> secondColumnName = new TableColumn<>("Ticket description");
        secondColumnName.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Ticket, String> thirdColumnName = new TableColumn<>("Purchase date");
        thirdColumnName.setCellValueFactory(new PropertyValueFactory<>("ticketDate"));

        tableView.getColumns().addAll(firstColumnName, secondColumnName, thirdColumnName);

        ObservableList<Ticket> ticketData = FXCollections.observableArrayList(ticketArrayList);
        tableView.setItems(ticketData);
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

        HBox buttonHBox = new HBox(cancelButton, logoutButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);

        VBox root = new VBox(tableView, buttonHBox);
        root.setSpacing(30);
        root.setPrefWidth(800);
        root.setPrefHeight(600);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewAvailableTickets.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @FXML
    protected void onRequestTripInfoButtonClick(ActionEvent event) throws Exception {

        // LOGIC FOR Select Route BUTTON IN HOMEPAGE
        fareArrayList = SqliteJDBC.showAvailableFares(user.getUserId(), user.getRoleTitle());
        Set<String> fareTypesSet = new HashSet<>();
        Set<String> ticketTypesSet = new HashSet<>();
        for (Fare f : fareArrayList) {
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
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold;");

        Button amountButton = new Button("Get Amount");

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

        Label amountLabel = new Label("$0.00");
        amountButton.setOnAction(e -> {
            System.out.println("Inside get amount");
            String selectedFareType = fareTypesComboBox.getValue();
            String selectedTicketType = ticketTypesComboBox.getValue();
            newFare.setFareType(selectedFareType);
            newFare.setFareTitle(selectedTicketType);
            for (Fare f : fareArrayList) {
                if (Objects.equals(f.getFareType(), selectedFareType) && Objects.equals(f.getFareTitle(), selectedTicketType)) {
                    amountLabel.setText("$" + f.getFareAmount());
                    newFare.setFareAmount(f.getFareAmount());
                    newFare.setFareDescription(f.getFareDescription());
                    newFare.setFareId(f.getFareId());
                }
            }
        });

        ComboBox<String> paymentTypesComboBox = new ComboBox<>();
        paymentTypesComboBox.setPromptText("Select a payment method");
        paymentTypesComboBox.getItems().addAll("Pay by card", "Pay with cash");
        Button paymentButton = new Button("Simulate Payment");
        paymentButton.setOnAction(e -> {
            boolean payment = SqliteJDBC.processTicket(user.getUserId(), newFare, "Visa");
            if(payment){
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e1 -> {
                    showReceiptPopUp(newFare, paymentTypesComboBox);
                }));
                timeline.play();
            }
            else{
                System.out.println("Unsuccessful");
                Label errorLabel = new Label("Payment was unsuccessful. Please try again.");
                Button closeButton = new Button("Close");
                VBox errorLayout = new VBox(errorLabel, closeButton);
                Scene errorScene = new Scene(errorLayout, 400, 200);

                // create a new stage to display the error message
                Stage errorStage = new Stage();
                errorStage.setScene(errorScene);
                errorStage.setTitle("Payment Error");

                // set the close button action to close the error stage and return to the payment screen
                closeButton.setOnAction(event1 -> {
                    errorStage.close();
                });

                // display the error stage
                errorStage.show();
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

        HBox fareTypeBox = new HBox(10);
        fareTypeBox.setAlignment(Pos.CENTER);
        fareTypeBox.setPadding(new Insets(10));
        Label fareTypeLabel = new Label("Fare Type:");
        fareTypeBox.getChildren().addAll(fareTypeLabel, fareTypesComboBox);

        HBox ticketTypeBox  = new HBox(10);
        fareTypeBox.setAlignment(Pos.CENTER);
        fareTypeBox.setPadding(new Insets(10));
        Label ticketTypeLabel  = new Label("Ticket Type:");
        fareTypeBox.getChildren().addAll(ticketTypeLabel, ticketTypesComboBox);

        HBox getAmountBox = new HBox(10);
        getAmountBox.setAlignment(Pos.CENTER);
        getAmountBox.setPadding(new Insets(10));
        amountLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        getAmountBox.getChildren().addAll(amountButton, amountLabel);

        HBox paymentTypeBox = new HBox(10);
        paymentTypeBox.setAlignment(Pos.CENTER);
        paymentTypeBox.setPadding(new Insets(10));
        Label paymentTypeLabel = new Label("Payment Type:");
        paymentTypeBox.getChildren().addAll(paymentTypeLabel, paymentTypesComboBox, paymentButton);

        HBox buttonHBox = new HBox(cancelButton, logoutButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(20);

        // Create the VBox

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(titleLabel, ticketTypeBox, fareTypeBox, getAmountBox, paymentTypeBox, buttonHBox);
//        VBox root = new VBox(ticketSelectionBox, amountBox, paymentBox, buttonHBox);
//        root.setSpacing(30);
//        root.setPrefWidth(800);
//        root.setPrefHeight(600);
//        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));


        Scene scene = new Scene(vbox, 800, 600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showReceiptPopUp(Fare newFare, ComboBox paymentTypesComboBox) {
        System.out.println("Successful");
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Set modality to block input to other windows
        popupStage.setTitle("Transaction complete");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label receiptLabel = new Label("Receipt");
        receiptLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        grid.add(receiptLabel, 0, 0, 2, 1);

        Label ticketTypeLabel = new Label("Ticket Type:");
        grid.add(ticketTypeLabel, 0, 1);

        Label ticketTypeValueLabel = new Label(newFare.getFareTitle());
        grid.add(ticketTypeValueLabel, 1, 1);

        Label fareTypeLabel = new Label("Fare Type:");
        grid.add(fareTypeLabel, 0, 2);

        Label fareTypeValueLabel = new Label(newFare.getFareType());
        grid.add(fareTypeValueLabel, 1, 2);

        Label aLabel = new Label("Amount:");
        grid.add(aLabel, 0, 3);

        Label amountValueLabel = new Label("$" + newFare.getFareAmount());
        amountValueLabel.setStyle("-fx-font-weight: bold;");
        grid.add(amountValueLabel, 1, 3);

        Label paymentTypeLabel = new Label("Payment Type:");
        grid.add(paymentTypeLabel, 0, 4);

        if (paymentTypesComboBox.getValue().equals("Pay by card")){
            Label paymentTypeValueLabel = new Label("Credit card");
            grid.add(paymentTypeValueLabel, 1, 4);
        }
        else {
            Label paymentTypeValueLabel = new Label("Cash");
            grid.add(paymentTypeValueLabel, 1, 4);
        }
        // Create the content for the popup
        VBox popupContent = new VBox();
        Label popupLabel = new Label("Please use pin pad to complete the transaction");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e1 -> {
            Stage stage = (Stage) ((Node) e1.getSource()).getScene().getWindow();
            stage.close();
            onCancelButtonClick(e1);

        });
        popupContent.getChildren().addAll(grid, closeButton);
        popupContent.setAlignment(Pos.CENTER);

        // Set the scene for the popup stage
        Scene popupScene = new Scene(popupContent, 400, 400);
        popupStage.setScene(popupScene);

        // Show the popup stage
        popupStage.show();
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
        String username = usernameField.getText();
        String password = passwordField.getText();

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