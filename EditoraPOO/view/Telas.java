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
	
	//adicionado demais telas
	
	public static void telaAlteracaoAutor() throws Exception{ 
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAlteracaoAutor.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	
	public static void telaAlteracaoAvaliador() throws Exception{ 
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaAlteracaoAvaliador.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	 
	 public static void telaCadastroAutor() throws Exception{ 
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroAutor.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	
	public static void telaCadastroAvaliador() throws Exception{ 
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaCadastroAvaliador.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	
	public static void telaGerenciarAvaliacoes() throws Exception{ 
		 Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaGerenciarAvaliacoes.fxml"));
		 
		 Scene cena = new Scene(root); 
		 
		 primaryStage.setScene(cena);
	 }
	
	 public static void main(String[] args) {
			launch();
		} 
	 
}
