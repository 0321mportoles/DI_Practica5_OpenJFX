package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Cliente;
import model.Cliente.Documento;

public class ListClientController implements Initializable {

	@FXML
	public ListView<String> listView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> wordsList = FXCollections.observableArrayList();
		int i = 0;
		for (Cliente c : Main.clientes) {
			wordsList.add(i, c.toStringList());
		}
		listView.setItems(wordsList);
	}

	public void actionCreateClient(ActionEvent ae) throws IOException {
		Main m = new Main();
		m.changeScene("ListClient.fxml");
	}
	
	public void actionUpdateClient(ActionEvent ae) throws IOException {
		System.out.println(listView.getSelectionModel().getSelectedIndex());
		Integer index = listView.getSelectionModel().getSelectedIndex();
		
		if (index == -1) {
			System.out.println("Debes seleccionar un cliente para poder modificarlo");
		} else {
			Main.data = index;
			Main m = new Main();
			m.changeScene("CreateClient.fxml");	
		}
	}
	
	public void actionDeleteClient(ActionEvent ae) throws IOException {
		Main m = new Main();
		m.changeScene("ListClient.fxml");
	}

	public void actionBack(ActionEvent ae) throws IOException {
		Main m = new Main();
		m.changeScene("MainPage.fxml");
	}
}
