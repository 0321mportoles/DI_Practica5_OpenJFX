package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Cliente;
import utils.Utils;

public class CreateClientController implements Initializable
{

    public CreateClientController() {
	}

	@FXML
    private TextField tfName;
    
    @FXML
    private TextField tfSurname;
    
    @FXML
    private TextField tfDocNumber;
    
    @FXML
    public ComboBox<String> cbDocType;
    
    @FXML
    private ComboBox<String> cbGender;
    
    @FXML
    private Button btReset;
    
    @FXML
    private Button btCreate;
    
    @FXML
    private Label lbErrName;

    @FXML
    private Label lbErrSurname;
    
    @FXML
    private Label lbErrDocNumber;
    
    @FXML
    private Label lbErrDocType;
    
    ObservableList<String> docTypes = FXCollections.observableArrayList("DNI", "NIE");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		resetErrors();

		if (Main.data == null || (int) Main.data == -1) {
			resetTextFields();
		} else {
			loadClientData((int) Main.data);
		}
		
		cbDocType.setItems(docTypes);
		cbGender.setItems(FXCollections.observableArrayList("Mujer", "Hombre"));
		
	}
	
	private void loadClientData(int data) {
		Cliente c = Main.clientes.get(data);

		tfName.setText(c.getNombreCliente());
	    tfSurname.setText(c.getApellidoContacto());
	    tfDocNumber.setText(c.getNumeroDniNie());
	}

	public void actionReset(ActionEvent ae) {
		resetTextFields();
	}
	
    public void actionBack(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("MainPage.fxml");
    	m.getStg().setTitle("Página principal");
    }

	private void resetTextFields() {
		tfName.setText("");
	    tfSurname.setText("");
	    tfDocNumber.setText("");
	    cbDocType.setValue(null);
	    cbGender.setValue(null);
	}
	
    public void actionCreateClient(ActionEvent event) throws IOException {
    	createClient();
    }

	private void createClient() throws IOException {
		resetErrors();
		boolean ok = true;

		ok = checkTextFieldEmpty(tfName) && ok;
		ok = checkTextFieldEmpty(tfSurname) && ok;
		ok = checkTextFieldEmpty(tfDocNumber) && ok;
		ok = checkIdentityNumber() && ok;
		ok = checkComboboxEmpty(cbDocType) && ok;
		ok = checkComboboxEmpty(cbGender) && ok;

		if (ok) {
			Main m = new Main();
			m.changeScene("MainPage.fxml");
		}
	}

	private boolean checkComboboxEmpty(ComboBox<String> combobox) {
		if (combobox.getSelectionModel().isEmpty()) {
			if (combobox.getId().equals("cbDocType")) { lbErrDocType.setVisible(true); }

			return false;
		}

		return true;
	}

	private boolean checkTextFieldEmpty(TextField textField) {
		if (textField.getText() == null || textField.getText().isEmpty()) {
			if (textField.getId().equals("tfName")) { lbErrName.setVisible(true); }
			if (textField.getId().equals("tfSurname")) { lbErrSurname.setVisible(true);}
			if (textField.getId().equals("tfDocNumber")) { lbErrDocNumber.setVisible(true);}
			return false;
		}

		return true;
	}
	
	private void resetErrors()
	{
		lbErrName.setVisible(false);
		lbErrSurname.setVisible(false);
		lbErrDocNumber.setVisible(false);
		lbErrDocNumber.setText("Debes introducir un documento");
		lbErrDocType.setVisible(false);
	}

	private boolean checkIdentityNumber()
	{
		if (tfDocNumber.getText() == null || tfDocNumber.getText().isEmpty()) { return true; }
		
		boolean ok = Utils.isNifNie(tfDocNumber.getText()); 
		if (!ok) { lbErrDocNumber.setVisible(true); lbErrDocNumber.setText("El número no es válido");}
		return ok;
	}
}