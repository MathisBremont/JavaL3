package view;

import autre.*;
import constante.Constante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.InfoFichierSauvegarde;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CombatController {
    private Parent parent;
    private Partie partie;
    private InfoFichierSauvegarde infoFichierSauvegarde;
    private Stage stage;
    private Scene scene;

    @FXML
    private ImageView imgPersoDos;

    @FXML
    private ProgressBar ptsViePerso;

    @FXML
    private ProgressBar ptsManaPerso;

    @FXML
    private Label lvlPerso;

    @FXML
    private Label armePerso;

    @FXML
    private Label nomPerso;

    @FXML
    private AfficherPersoController AfficherPersoConfig;

    public CombatController(Partie partie) throws MalformedURLException {
        this.partie = partie;
        this.lvlPerso=new Label();
        this.armePerso=new Label();
        this.imgPersoDos=new ImageView();
        this.nomPerso=new Label();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Combat.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent, 1280, 720);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nomPerso.setText(partie.getPersonnage().getNom());
        this.lvlPerso.setText(String.valueOf(partie.getPersonnage().getNiveau()));
        System.out.println(partie.getPersonnage().getNiveau());
        System.out.println(partie.getPersonnage().getListeArmes());
        this.armePerso.setText(String.valueOf(partie.getPersonnage().getListeArmes()));
        this.imgPersoDos.setImage(new Image((new File(Constante.CHEMIN_IMAGES + "archer.png")).toURI().toURL().toString()));
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie){
        this.partie = partie;
    }

    public void setInfoFichierSauvegarde(InfoFichierSauvegarde infoFichierSauvegarde) {
    }

    public void launchCombatController(Stage stage) {
        this.stage = stage;
        stage.setTitle("User Login");

        stage.setScene(scene);
        stage.setResizable(true);
        stage.hide();
        stage.show();
    }


    public Personnage genererAdversaire(int niveau){

        switch (niveau){
            case 1:

                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));
            case 2:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 3:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 4:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 5:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 6:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 7:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 8:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 9:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));

            case 10:
                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(null));
               
            default:
                return null;

        }
    }
}