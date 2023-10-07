package edu.sdccd.cisc191.template;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class GUILabel extends Label{
    public static Insets LABEL_PADDING = new Insets(20);

    public GUILabel() {
         //sets Label properties, like padding
        setStyle("-fx-text-alignment: center; -fx-background-color: green");


        setText("Southern California Surf Spots");
        setFont(Font.font("Ariel", FontPosture.ITALIC, 24));
    }

}
