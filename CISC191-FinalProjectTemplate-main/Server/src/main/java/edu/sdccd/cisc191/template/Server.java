package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.Handle;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

public class Server extends Application{

    private static GUILabel message; // to hold the title of this GUI

    public static SurfLocation[][] surfLocations = new SurfLocation[2][2]; //creates an array of locations
    public static SurfReport[][] surfReports = new SurfReport[2][2]; //creates an array of surf reports

    public static void main(String[] args) {

         //getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink

        populateSurfLocations();
//        printSurfLocations(surfLocations);
        loadSurfReports();
        launch();//must extend Application
        System.out.println(message);
    }

    public static void populateSurfLocations(){
        surfLocations[0][0] = new SurfLocation(
                "La Jolla Shores",
                false,
                "rocky cliffs"
        );
        surfLocations[0][1]= new SurfLocation(
                "Huntington Beach",
                false,
                "sandy beach"
        );
        surfLocations[1][0] = new SurfLocation(
                "Malibu",
                false,
                "point break"
        );
        surfLocations[1][1]= new SurfLocation(
                "Trestles",
                true,
                "sandy beach"
        );
    }

//    public static void  printSurfLocations(SurfLocation surfLocationsArray[][]) {
//        // Loop through all rows in succession
//        for (int i = 0; i < surfLocationsArray.length; i++)
//
//            // Loop through all elements of current row
//            for (int j = 0; j < surfLocationsArray[i].length; j++)
//                System.out.println(surfLocationsArray[i][j] + " ");
//    }

    private static void loadSurfReports() {
        SurfReportImporter surfReportImporter = new SurfReportImporterText();
        //uses interface to access the object of the implemented class
        // The data type (the interface SurfReportImporter) is a pointer.
        // surfReportImporter points to the object SurfReportImporterText.
        // The code that follows is an interface method.
        // Do not want main method to care about importing surf report data.
        // We only want main to care about methods in the interface SurfReportImporter.
        surfReportImporter.importSurfReport();
        //this method (importSurfReport()) is defined
        // in the class that implements the interface SurfReportImporter (SurfReportImporterText)
        //TODO import array of surf reports into a 2D array that will be created.

        //Reports include wave height, wind speed, and tide height
        surfReports[0][0] = new SurfReport(
                new Date(2023, Calendar.OCTOBER, 1),
                "Wave height is around 7ft, onshore winds blowing 6mph, tide height is mid to high"
        );
        surfReports[0][1] = new SurfReport(
                new Date(2023, Calendar.OCTOBER, 1),
                "Wave height is around 8ft, onshore winds blowing 5mph, tide height is high"
        );
        surfReports[1][0] = new SurfReport(
                new Date(2023, Calendar.OCTOBER, 1),
                "Wave height is around 1.5ft, offshore winds blows 4mph, tide height is low"
        );
        surfReports[1][1] = new SurfReport(
                new Date(2023, Calendar.OCTOBER, 1),
                "Wave height is around 6ft, onshore winds blowing 3mph, tide height is mid to high"
        );
    }

    @Override
    public void start(Stage stage) throws Exception {//begin method "start"

        Label beachName = new Label("Beach Name");
        Label forBeginners = new Label("For Beginners?");
        Label environment = new Label("Surf Environment?");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(5);
        grid.setVgap(5);


        Label locationLabel = new Label("Select the Beach:");
        ComboBox<String> locationCB = new ComboBox<>();
        ObservableList<String> location = FXCollections.observableArrayList(
                "La Jolla Shores",
                        "Huntington Beach",
                        "Malibu Beach",
                        "Trestles Beach"
        );



        locationCB.setItems(location);
        locationCB.setValue("Beach");

        Button displayInfo = new Button("Get more info");
        displayInfo.setOnAction(e -> {
            String selected = locationCB.getValue();
        });

        grid.add(locationLabel, 0, 0);
        grid.add(locationCB, 0, 1);
        grid.add(beachName,0,3);
        grid.add(forBeginners,0,5);
        grid.add(environment,0,7);


        // create scene, stage, set title, and show
        Scene scene = new Scene(grid, 300, 250); //created scene
        stage.setScene(scene); // created stage
        stage.setTitle("Surf Locations"); //set title
        stage.show(); //created show
    } //end method "start"

} //end class Server
