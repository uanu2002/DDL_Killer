package com.example.dlk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setScene(new Scene(root,800,600));//AnchorPane相同或更大
        primaryStage.setTitle("DDL Killer");//设置标题
        primaryStage.setResizable(true);//设置为不能修改窗口大小
        primaryStage.show();
    }
}
