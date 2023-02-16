package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;

public class UI extends Application {
        public static void main(String[] args){
            launch(args);
        }

        private final Button searchButton = new Button("Search");
        private final TextField searchRequestField = new TextField();
        private final TextField revisionsOutputField = new TextField();

        @Override
        public void start(Stage primaryStage) {
            revisionsOutputField.setEditable(false);
            configure(primaryStage);
            configureSearchButton();
        }

        private void configure(Stage stage){
            stage.setTitle("Wikipedia Revisions Parser");
            stage.setScene(new Scene(createRoot()));
            stage.sizeToScene();
            stage.show();
        }

        private Pane createRoot() {
            VBox root = new VBox();
            root.getChildren().addAll(
                    new Label("Enter Search Request"),
                    searchRequestField,
                    searchButton,
                    new Label("Revisions"),
                    revisionsOutputField);
            return root;
        }

        private void configureSearchButton() {
            searchButton.setOnAction(event -> getFormattedRevisions());
        }

        private void getFormattedRevisions() {
            String input = searchRequestField.getText();
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Formatter formatter = new Formatter();
            try {
                DocumentContext jsonContext = formatter.createJSONContext();
                formatter.parsePageMissing(jsonContext);
                String formattedStringList = formatter.revisionsToStringFormatter(jsonContext);
                if (formatter.checkIfRedirect(jsonContext)) {
                    revisionsOutputField.setText(formatter.formatRedirect(jsonContext));
                }
                revisionsOutputField.setText(formattedStringList);
            } catch (RuntimeException ioException) {
                revisionsOutputField.setText("Network connection problem" + ioException.getMessage());
//                System.exit(0);
            }

        }
}


