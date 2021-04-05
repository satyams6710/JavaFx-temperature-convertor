package intern_java;

import  javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLOutput;
import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("applayout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar= createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Packet");
        primaryStage.show();
    }
//Creating menu
    public MenuBar createMenu(){
        //file menu
        Menu fileMenu= new Menu("File");
        MenuItem newMenuItem= new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem= new MenuItem("Quit");
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //help menu
        Menu helpMenu= new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");
        aboutApp.setOnAction(event ->  {aboutApp(); });
        helpMenu.getItems().addAll(aboutApp);



        //Menu Bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }

    private void aboutApp() {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("My First JavaFx App");
        alert1.setHeaderText("I am Learning JavaFx");
        alert1.setContentText("Just Started");

        ButtonType yesBtn=new ButtonType("YES");
        ButtonType noBtn=new ButtonType("NO");

        alert1.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickBtn=alert1.showAndWait();

        if(clickBtn.isPresent() && clickBtn.get()==yesBtn){
            System.out.println("Yes Button Clicked");
        }
        if(clickBtn.isPresent() && clickBtn.get()==noBtn){
            System.out.println("No Button Clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }
}
