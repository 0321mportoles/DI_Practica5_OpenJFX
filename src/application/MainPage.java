package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Platform;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainPage {

    public MainPage() {

    }

    @FXML
    private Button btCreateCliente;

    @FXML
    private Button btListClients;

    @FXML
    private Button btLogOut;
    


    public void actionCreateClient(ActionEvent event) throws IOException {
    	createClient();
    }
    
    public void actionListClients(ActionEvent event) throws IOException {
        listClients();
    }
    
    public void actionUserLogout(ActionEvent event) throws IOException {
        logout();
    }
    
    private void createClient() throws IOException {
    	Main m = new Main();
    	m.changeScene("CreateClient.fxml");
    	m.getStg().setTitle("Crear cliente");
    }
    
    private void listClients() throws IOException {
    	Main m = new Main();
    	m.changeScene("ListClient.fxml");
    }
    
    private void logout() throws IOException {
//    	Main m = new Main();
//    	m.changeScene("LoginForm.fxml");
    	Platform.exit();
    }    
}
