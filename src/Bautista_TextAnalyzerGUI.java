
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Extension of Assignment 3 where I add a GUI on top of the Text Analyzer. Main
 * function is also separated from application logic to allow for easier code
 * expansion. Uses JavaFX for the GUI. Contains the main function for the whole
 * program.
 * 
 * @author Ramon Bautista
 * @date 06/22/19
 *
 */
public class Bautista_TextAnalyzerGUI extends Application {

    // Contains the file path to the .txt file to analyze.
    private String filePath;

    // Label that contains the top 20 word occurences from the Text Analyzer.
    private Label entryLabel;

    /*
     * (non-Javadoc)
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * 
     * Creates the GUI for the application. Handles all GUI elements like
     * labels, panes, etc.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Text Analyzer");

        // The file path to the .txt file to be parsed will be entered here.
        TextField filePathEntryField = new TextField();

        // The pane is the foundation for where the labels are placed.
        FlowPane pane = new FlowPane();

        // The padding of the pane is the area that doesn't get touched around
        // the edges of the border of the GUI.
        pane.setPadding(new Insets(20, 20, 20, 20));

        // The vertical and horizontal number of pixels between each label.
        pane.setHgap(20);
        pane.setVgap(20);

        StringBuilder directions = new StringBuilder();
        directions.append(
                "*For putting in backslashes in the file path, use 2 backslashes instead of just one (i.e. ..\\\\ test.txt instead of ..\\ test.txt).");
        Label directionsLabel = new Label(directions.toString());
        pane.getChildren().add(directionsLabel);

        Label label = new Label("Enter file path to .txt file:");

        // This handles the event that occurs when the user presses enter.
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // If the user presses enter without anything in the text field,
                // we don't run anything and prompt the user to enter a path.
                if (filePathEntryField.getText().length() == 0) {
                    label.setText("Invalid entry; please enter file path.");
                }

                else {
                    // Taking the file path from the textfield and using it to
                    // reach the file from the File file variable.
                    filePath = new String();
                    filePath = filePathEntryField.getText();

                    File file = new File(filePath);

                    Bautista_TextAnalyzer text;

                    // try-catch block: if the file is found, parse it and
                    // analyze it, else throw an error.
                    try {
                        // Passing in the file path to the Scanner and
                        // getting the wordCountList for the analysis.
                        text = new Bautista_TextAnalyzer(file);
                        List<Bautista_WordCountContainer> entries = text
                                .getwordCountList();

                        // Just a little Title for the chart of entries.
                        StringBuilder stringEntries = new StringBuilder();
                        stringEntries.append(
                                "\t\t\t\t\t\t\t\t   Word\t\t Word Count\n");
                        entryLabel = new Label();

                        // Loop that appends each entry from the wordCountList
                        // entries
                        // to a StringBuilder.
                        int i = 0;
                        for (Bautista_WordCountContainer entry : entries) {
                            i++;
                            stringEntries.append("\t\t\t\t\t\t\t\t" + i + ") "
                                    + entry.toString() + "\n");

                            if (i == 20) {
                                break;
                            }
                        }

                        // Converting the StringBuilder of entries into a string
                        // setting it to the label text and adding it to the
                        // pane.
                        entryLabel.setText(stringEntries.toString());
                        pane.getChildren().add(entryLabel);
                    }

                    // The file wasn't found.
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Adding the action to the textbox for when the user presses enter.
        filePathEntryField.setOnAction(event);

        // Adding all of the labels to the pane.
        pane.getChildren().addAll(label, filePathEntryField);

        // Setting the scene size and displaying it.
        Scene scene = new Scene(pane, 650, 520);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Method that launches the whole application.
        launch(args);
    }

}
