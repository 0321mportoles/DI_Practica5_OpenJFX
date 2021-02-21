package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LogIn {

    public LogIn() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }
    
    public void actionForgotPassword(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ForgotPassword.fxml");
        m.getStg().setTitle("Olvidé la contraseña");
    }    

    private void checkLogin() throws IOException {
        Main m = new Main();
        
        if (username.getText().toString().equals("m") && password.getText().toString().equals("m")) {
//    	if (username.getText().toString().equals("marta") && password.getText().toString().equals("marta")) {
            wrongLogIn.setText("Success!");
            wrongLogIn.setStyle("-fx-text-fill: green;");
            m.changeScene("MainPage.fxml");
            m.getStg().setTitle("Página principal");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        } else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }
}
