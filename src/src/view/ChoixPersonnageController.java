package view;

import autre.Partie;
import constante.Constante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChoixPersonnageController {

    @FXML
    private ImageView imgMage;

    @FXML
    private ImageView imgChasseur;

    @FXML
    private ImageView imgGuerrier;

    @FXML
    private Button btnMage;

    @FXML
    private Button btnChasseur;

    @FXML
    private Button btnGuerrier;

    @FXML
    private Button btnValiderChoixPerso;

    @FXML
    private TextField nomJoueur;

    @FXML
    private Label labErreurNom;

    @FXML
    private Label labErreurPerso;

    private int choixMage;
    private int choixChasseur;
    private int choixGuerrier;
    private Partie partie;

    public int getChoixMage() {
        return choixMage;
    }

    public int getChoixChasseur() {
        return choixChasseur;
    }

    public int getChoixGuerrier() {
        return choixGuerrier;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setChoixMage(int choixMage) {
        this.choixMage = choixMage;
    }

    public void setChoixChasseur(int choixChasseur) {
        this.choixChasseur = choixChasseur;
    }

    public void setChoixGuerrier(int choixGuerrier) {
        this.choixGuerrier = choixGuerrier;
    }

    public void setPartie(Partie partie){
        this.partie = partie;
    }

    public void initialize() throws MalformedURLException {
        File fileArcher = new File(Constante.CHEMIN_IMAGES +"archer.png");
        File fileGuerrier = new File(Constante.CHEMIN_IMAGES + "guerrier.png");
        File fileMage = new File(Constante.CHEMIN_IMAGES + "mage.png");

        String localUrlArcher = fileArcher.toURI().toURL().toString();
        String localUrlGuerrier = fileGuerrier.toURI().toURL().toString();
        String localUrlMage = fileMage.toURI().toURL().toString();

        Image imageArcher = new Image(localUrlArcher);
        Image imageGuerrier = new Image(localUrlGuerrier);
        Image imageMage = new Image(localUrlMage);

        this.imgChasseur.setImage(imageArcher);
        this.imgGuerrier.setImage(imageGuerrier);
        this.imgMage.setImage(imageMage);
        this.choixMage = 0;
        this.choixChasseur = 0;
        this.choixGuerrier = 0;
        this.labErreurNom.setText("");
        this.labErreurPerso.setText("");
    }



    @FXML
    public void choixPersonnageMage(ActionEvent event) throws MalformedURLException {
        this.choixMage = 1;
        this.choixChasseur = 0;
        this.choixGuerrier = 0;
        System.out.println("mage = " + this.choixMage + ", chasseur = " + this.choixChasseur + ", guerrier = " + this.choixGuerrier);
    }

    @FXML
    public void choixPersonnageChasseur(ActionEvent event){
        this.choixMage = 0;
        this.choixChasseur = 1;
        this.choixGuerrier = 0;
        System.out.println("mage = " + this.choixMage + ", chasseur = " + this.choixChasseur + ", guerrier = " + this.choixGuerrier);
    }

    @FXML
    public void choixPersonnageGuerrier(ActionEvent event){
        this.choixMage = 0;
        this.choixChasseur = 0;
        this.choixGuerrier = 1;
        System.out.println("mage = " + this.choixMage + ", chasseur = " + this.choixChasseur + ", guerrier = " + this.choixGuerrier);
    }

    @FXML
    public void validerChoixPerso() throws Exception {
        int verif = 0;
        Boolean valeur = this.nomJoueur.getText().matches("^[a-zA-Z]*$");
        if(this.nomJoueur.getText().equals("") || this.nomJoueur.getText() == null || valeur == false){
            this.labErreurNom.setText("Saisissez un nom uniquement composé de lettres");
            verif +=1;
        }else{
            labErreurNom.setText("");
        }


        if(this.choixMage==0 && this.choixGuerrier == 0 && this.choixChasseur ==0){
            labErreurPerso.setText("Vous devez sélectionner un personnage à jouer");
            verif+=1;
        }
        else{
            labErreurPerso.setText("");
        }

        if (verif==0){
            try {
                DateFormat format = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
                Date date = new Date();
                FileWriter lu = new FileWriter(Constante.CHEMIN_SAUVEGARDES + this.nomJoueur.getText() + "_" + format.format(date) + ".txt");
                BufferedWriter out = new BufferedWriter(lu);
                out.write(this.nomJoueur.getText() + " " + this.choixMage + " " + this.choixChasseur + " " + this.choixGuerrier); //
                out.close();
            }
            catch (IOException er) {;}
        }

        ChoixSauvegardeController sauvegardeController = new ChoixSauvegardeController();
        sauvegardeController.initialize();



    }
}
