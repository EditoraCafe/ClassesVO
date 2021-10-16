package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application  {
	 private static Stage primaryStage;
		 
		 
	 public static Stage getPrimaryStage() {
		 return primaryStage;
	 }
	 public static void setPrimaryStage(Stage primaryStage) {
		 Telas.primaryStage = primaryStage;
	 }
	 
	 public void start(Stage primaryStage) throws Exception{
		 setPrimaryStage(primaryStage);
		 primaryStage.setTitle("Editora poo");
		 primaryStage.show();
		 telaLogin();
	 }
	 
	 public static void telaLogin() throws Exception{
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaLogin.fxml"));
		 
		 Scene cena = new Scene(root);
		 
		 primaryStage.setScene(cena);
	 }
	 
	 
	 public static void telaPrincipalGerente() throws Exception{ //vai receber usuario?
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAdm.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	 
	 public static void telaCadastroObra() throws Exception{ //vai receber usuario?
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroObra.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	 
	 public static void telaListaObras() throws Exception{ //vai receber usuario?
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaListaObras.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	 
	 
	 public static void main(String[] args) {
			launch();
		} 
	 
}
