package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Period;

public class App extends Application {
    
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        // Crear elementos de la interfaz de usuario
        Label titleLabel = new Label("Calculadora de Edad");
        DatePicker birthDatePicker = new DatePicker();
        Button calculateButton = new Button("Calcular Edad");
        Label resultLabel = new Label("Tu edad aparecerá aquí.");

        // Configurar acción al hacer clic en el botón "Calcular Edad"
        calculateButton.setOnAction(e -> {
            // Obtener la fecha de nacimiento seleccionada
            LocalDate birthDate = birthDatePicker.getValue();
            
            if (birthDate != null) {
                // Calcular la edad a partir de la fecha de nacimiento seleccionada y la fecha actual
                LocalDate currentDate = LocalDate.now();
                int age = Period.between(birthDate, currentDate).getYears();
                
                // Mostrar la edad calculada en la etiqueta de resultado
                resultLabel.setText("Tu edad es: " + age + " años.");
            } else {
                // Mostrar un mensaje de error si no se ha seleccionado una fecha de nacimiento
                resultLabel.setText("Por favor, selecciona tu fecha de nacimiento.");
            }
        });

        // Configurar el diseño de la interfaz de usuario
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, birthDatePicker, calculateButton, resultLabel);

        // Configurar la escena y mostrar la ventana
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Calculadora de Edad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
