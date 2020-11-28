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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Partie extends Application{

    private Stage primaryStage;
    private AnchorPane root;
    private Scene scene;
    private Personnage personnage;

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


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        launch(args);
        Mage mage = new Mage();
        Guerrier guerrier = new Guerrier(150.0, 30, 1, new ArrayList<Arme>(Arrays.asList(new Epee(),new Bouclier())));
        mage.attaqueBasique(guerrier);
        System.out.println("Le guerrier n'a plus que " + guerrier.getPtsDeVie() + " pts de vies");
        System.out.println("Le mage n'a plus que " + mage.getMana() + " pts de mana");



        guerrier.attaqueBasique(mage);
        System.out.println("Le mage n'a plus que " + mage.getPtsDeVie() + " pts de vies");
        System.out.println("Le guerrier n'a plus que " + guerrier.getMana() + " pts de mana");



        File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+"Nom_Personnage") ;

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));
        // création d'un objet à sérializer

        Mage mage1 = new Mage(200, 200, 24, new ArrayList<Arme>());
        Mage mage2 = new Mage();
        ArrayList<Arme> salut = new ArrayList<Arme>();
        salut.add(new Arc());
        salut.add(new Arc());
        salut.add(new Arc());
        Chasseur chas1 = new Chasseur(2000000, 200, 24, new ArrayList<Arme>(Arrays.asList(new Arc())));
        Chasseur chas2 = new Chasseur();

        // sérialization de l'objet
        oos.writeObject(guerrier);
        oos.writeObject(mage1);
        oos.writeObject(chas1);

        Guerrier guer2 = new Guerrier();
        System.out.println("Guerrier 2 : "+guer2.toString());

        // désérialization de l'objet
        guer2=(Guerrier)ois.readObject();
        mage2=(Mage)ois.readObject();
        chas2=(Chasseur)ois.readObject();

        System.out.println("Guerrier 1 :" + guerrier.toString());
        System.out.println("Guerrier 2 :" + guer2.toString());
        System.out.println("Mage 2 : "+mage2.toString());
        System.out.println("Chas 2 : "+ chas2.toString());

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

    public Personnage getPersonnage(){
        return this.personnage;
    }
}
