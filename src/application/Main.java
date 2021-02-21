package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Cliente;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private static Stage stg;

	// Used to pass data between scenes
	public static Object data;

//	ArrayList<String> obj = new ArrayList<String>(
//			Arrays.asList("Pratap", "Peter", "Harsh"));
	
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>(Arrays.asList(
			new Cliente(0, "Daniel", "Bum", 976976985),
			new Cliente(1, "Marta", "Portoles", 686585854)
	));
	
//	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>(){
//
//		private static final long serialVersionUID = 1L;
//
//		{
//			add(new Cliente(0, "Daniel", "Bum", 976976985));
//			add(new Cliente(1, "Marta", "Portoles", 686585854));
//		}
//	};
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stg = primaryStage;
	        primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
			
			Scene scene = new Scene(root,600,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Desarrollo de interfaces con JavaFX");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Stage getStg() {
		return stg;
	}

	public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        data = null;
    }

	public void changeScene(String fxml, Object data) throws IOException {
		this.data = data;
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
	
	public static void main(String[] args) { launch(args); }
}
