package autre;

import constante.Constante;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Application;
import view.ChoixPersonnageController;
import view.LancementDuJeuController;

public class Partie extends Application{

    private Stage primaryStage;
    private AnchorPane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setResizable(false);
            this.primaryStage.setTitle("Le Seigneur Des Hameaux : La Bataille Pour La Terre Excentré");
            this.primaryStage.getIcons().add(new Image("file:" +Constante.CHEMIN_IMAGES + "logo.png"));
            this.root = new AnchorPane();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Partie.class.getResource("/view/LancementDuJeu.fxml"));

            this.root = loader.load();

            LancementDuJeuController controllerRoot = loader.getController();

            controllerRoot.setPartie(this);
            this.scene = new Scene(root, 1280, 640);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
        Mage mage = new Mage();
        Guerrier guerrier = new Guerrier();
        mage.attaqueBasique(guerrier);
        System.out.println("Le guerrier n'a plus que " + guerrier.getPtsDeVie() + " pts de vies");
        System.out.println("Le mage n'a plus que " + mage.getMana() + " pts de mana");



        guerrier.attaqueBasique(mage);
        System.out.println("Le mage n'a plus que " + mage.getPtsDeVie() + " pts de vies");
        System.out.println("Le guerrier n'a plus que " + guerrier.getMana() + " pts de mana");
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
