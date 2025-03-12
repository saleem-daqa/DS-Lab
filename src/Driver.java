import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Lab 1");
        Tab tab2 = new Tab("Lab 2");
        Tab tab3 = new Tab("Lab 3");
        Tab tab4 = new Tab("Lab 4");
        Tab tab5 = new Tab("Lab 5");
        Tab tab6 = new Tab("Lab 6");
        Tab tab7 = new Tab("Lab 7");
        Tab tab8 = new Tab("Lab 8");
        Tab tab9 = new Tab("Lab 9");
        Tab tab10 = new Tab("Lab 10");
        Tab tab11 = new Tab("Lab 11");
        Tab tab12 = new Tab("Lab 12");
        Tab tab13 = new Tab("Lab 13");

        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9, tab10, tab11, tab12, tab13);
        
        Lab0 l1 = new Lab0();
        tab1.setContent(l1);

        Scene scene = new Scene(tabPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}