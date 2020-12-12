package view;

import autre.*;
import com.sun.jdi.DoubleValue;
import constante.Constante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.InfoFichierSauvegarde;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Button;

public class CombatController {
    private Parent parent;
    private Partie partie;
    private InfoFichierSauvegarde infoFichierSauvegarde;
    private Stage stage;
    private Scene scene;

    private Personnage perso;
    private Personnage adversaire;

    @FXML
    private ImageView imgPersoDos;

    @FXML
    private ProgressBar ptsViePerso;

    @FXML
    private ProgressBar ptsManaPerso;

    @FXML
    private ProgressBar ptsVieAdvers;

    @FXML
    private ProgressBar ptsManaAdvers;

    @FXML
    private Label lvlPerso;

    @FXML
    private Label armePerso;

    @FXML
    private Label nomPerso;



    @FXML
    private Button btnAttaqueBasique;

    @FXML
    private Button btnAttaqueSpéciale;

    @FXML
    private Button btnAbandonner;


    public void initialize() throws MalformedURLException {


        this.partie=partie;
        System.out.println(partie.getPersonnage().getNom());
        this.nomPerso.setText("pd");
        this.lvlPerso.setText(String.valueOf(partie.getPersonnage().getNiveau()));
        System.out.println(partie.getPersonnage().getNiveau());
        System.out.println(partie.getPersonnage().getListeArmes());
        this.armePerso.setText(String.valueOf(partie.getPersonnage().getListeArmes()));
        this.imgPersoDos.setImage(new Image((new File(Constante.CHEMIN_IMAGES + "archer.png")).toURI().toURL().toString()));
        adversaire = genererAdversaire(this.getPartie().getPersonnage().getNiveau());

        ptsViePerso = new ProgressBar();
        ptsManaPerso = new ProgressBar();


    }


    public CombatController(Partie partie) throws MalformedURLException {
        this.partie = partie;
        this.perso=partie.getPersonnage();

    }




    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie){
        this.partie = partie;
    }

    public void setNomPerso(String nomPerso){
        this.nomPerso.setText(nomPerso);
        System.out.println("ui");
    }

    public void setInfoFichierSauvegarde(InfoFichierSauvegarde infoFichierSauvegarde) {
    }

    public void launchCombatController(Stage stage) {



        adversaire = genererAdversaire(this.getPartie().getPersonnage().getNiveau());

        while(adversaire.getPtsDeVie()>0 && perso.getPtsDeVie()>0){

        }


    }




    @FXML
    public void attaqueBasique(ActionEvent event) {

        this.perso.attaqueBasique(adversaire);
        System.out.println(perso.getNom());
        ptsManaPerso.setProgress(perso.getMana());

        ptsVieAdvers.setProgress((adversaire.getPtsDeVie()));
    }

    @FXML
    public void attaqueSpéciale(ActionEvent event){
        this.perso.attaqueBasique(adversaire);

    }

    @FXML
    public void giveUp(ActionEvent event){

    }


    public Personnage genererAdversaire(int niveau){

        switch (niveau){
            case 1:

                return new Mage("Grutendre",100,100,1,new ArrayList<Arme>(Arrays.asList()));
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