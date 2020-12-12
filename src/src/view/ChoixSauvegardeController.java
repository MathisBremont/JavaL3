package view;

import autre.*;
import constante.Constante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.InfoFichierSauvegarde;
import model.Sauvegarde;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ChoixSauvegardeController {

    @FXML
    private VBox vboxListeSauvegarde;

    @FXML
    private Button btnPartie1;

    @FXML
    private Button btnPartie2;

    @FXML
    private Button btnPartie3;


    private Partie partie;
    private Sauvegarde sauvegarde;
    private InfoFichierSauvegarde infoFichierSauvegarde;



    public void initialize() throws Exception {
        this.sauvegarde = new Sauvegarde();
        int nbSauvegarde = this.sauvegarde.getListeSauvegarde().length;
        switch (nbSauvegarde){
            case 0:
                break;
            case 1: btnPartie1.setText(this.sauvegarde.getListeSauvegarde()[0]);
                break;
            case 2: btnPartie1.setText(this.sauvegarde.getListeSauvegarde()[0]);
                btnPartie2.setText(this.sauvegarde.getListeSauvegarde()[1]);
                break;
            case 3: btnPartie1.setText(this.sauvegarde.getListeSauvegarde()[0]);
                btnPartie2.setText(this.sauvegarde.getListeSauvegarde()[1]);
                btnPartie3.setText(this.sauvegarde.getListeSauvegarde()[2]);
                break;
            default:
                System.out.println("Erreur, trop de sauvegardes se trouvent dans le repertoire de sauvegarde.");
        }
    }


    public void lancerPartie1() throws IOException, ClassNotFoundException {
        if(!btnPartie1.getText().equals("Nouvelle Partie")){
            File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+btnPartie1.getText()) ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));


            // désérialization de l'objet
            Personnage temp=(Personnage) ois.readObject();
            partie.setPersonnage(temp);
            chargerCombat();
        }
        if(btnPartie1.getText().equals("Nouvelle Partie")){

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Partie.class.getResource("/view/ChoixPersonnage.fxml"));

            partie.setRoot(loader.load());

            ChoixPersonnageController choixPersoCtrl = loader.getController();


            choixPersoCtrl.setPartie(partie);

            partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
            partie.getPrimaryStage().show();
        }
    }

    public void lancerPartie2() throws IOException, ClassNotFoundException {

        if(!btnPartie2.getText().equals("Nouvelle Partie")){
            File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+btnPartie2.getText()) ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));


            // désérialization de l'objet
            Personnage temp=(Personnage) ois.readObject();
            partie.setPersonnage(temp);
            chargerCombat();
        }
        if(btnPartie2.getText().equals("Nouvelle Partie")){
            partie.setRoot(new AnchorPane());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Partie.class.getResource("/view/ChoixPersonnage.fxml"));

            partie.setRoot(loader.load());

            ChoixPersonnageController choixPersoCtrl = loader.getController();

            choixPersoCtrl.setPartie(partie);

            partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
            partie.getPrimaryStage().show();
        }
    }

    public void lancerPartie3() throws IOException, ClassNotFoundException {
        if(!btnPartie3.getText().equals("Nouvelle Partie")){
            File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+btnPartie3.getText()) ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));


            // désérialization de l'objet
            Personnage temp=(Personnage) ois.readObject();
            partie.setPersonnage(temp);
            chargerCombat();
        }

        if(btnPartie3.getText().equals("Nouvelle Partie")){
            partie.setRoot(new AnchorPane());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Partie.class.getResource("/view/ChoixPersonnage.fxml"));

            partie.setRoot(loader.load());

            ChoixPersonnageController choixPersoCtrl = loader.getController();


            choixPersoCtrl.setPartie(partie);

            partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
            partie.getPrimaryStage().show();
        }
    }

    public void chargerCombat() throws IOException {
        //On charge la page d'après
       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));
        partie.setRoot(loader.load());
        System.out.println("tamere");

        CombatController combatCtrl = loader.getController();

        combatCtrl.setPartie(partie);


        partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
        partie.getPrimaryStage().show();*/

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));
        CombatController combatCtrl = new CombatController(partie);
        loader.setController(combatCtrl);
        System.out.println(partie);
        partie.setRoot(loader.load());



        partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
        partie.getPrimaryStage().show();


        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));

        CombatController controller = loader.<CombatController>getController();
        controller.setPartie(partie);
        loader.setController(controller);

        Parent root = loader.load();*/

        /*CombatController combatController = new CombatController(partie);
        combatController.launchCombatController(partie.getPrimaryStage());*/

    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public InfoFichierSauvegarde getInfoFichierSauvegarde() {
        return infoFichierSauvegarde;
    }

    public void setInfoFichierSauvegarde(InfoFichierSauvegarde infoFichierSauvegarde) {
        this.infoFichierSauvegarde = infoFichierSauvegarde;
    }
}
