package view;

import autre.*;
import constante.Constante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.InfoFichierSauvegarde;

import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

    //1 = mage, 2 = guerrier, 3 = chasseur
    private int choixPerso;

    private Partie partie;
    private  InfoFichierSauvegarde infoFichierSauvegarde;


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
        this.choixPerso = 0;

        this.labErreurNom.setText("");
        this.labErreurPerso.setText("");
    }



    @FXML
    public void choixPersonnageMage(ActionEvent event) throws MalformedURLException {
        this.choixPerso = 1;
    }

    @FXML
    public void choixPersonnageChasseur(ActionEvent event){
        this.choixPerso = 2;
    }

    @FXML
    public void choixPersonnageGuerrier(ActionEvent event){
        this.choixPerso = 3;
    }

    //On vérifie que les champs ont été saisi correctement
    //On valide le choix du personnage
    //Et on sauvegarde les informations du joueur dans un fichier
    @FXML
    public void validerChoixPerso() throws Exception {
        int verif = 0;
        //regex pseudo composé de lettre uniquement
        Boolean valeur = this.nomJoueur.getText().matches("^[a-zA-Z]*$");

        //vérifie pesudo correct
        if(this.nomJoueur.getText().equals("") || this.nomJoueur.getText() == null || valeur == false){
            this.labErreurNom.setText("Saisissez un nom uniquement composé de lettres");
            verif +=1;
        }else{
            labErreurNom.setText("");
        }

        //Vérifie que le joueur a bien choisi un type de personnage
        if(this.choixPerso != 1 && this.choixPerso !=2 && this.choixPerso!=3){
            labErreurPerso.setText("Vous devez sélectionner un personnage à jouer");
            verif+=1;
        }
        else{
            labErreurPerso.setText("");
        }

        //Si les champs au dessus sont bons, on enregistre le personnage choisi
        if (verif==0){
            try {
                if(this.choixPerso==1){
                    File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+this.nomJoueur.getText());

                    ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
                    partie.setPersonnage(new Mage(this.nomJoueur.getText()));
                    System.out.println(new Mage(this.nomJoueur.getText()));
                    oos.writeObject(partie.getPersonnage());
                    oos.close();
                }
                if(this.choixPerso==2){
                    File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+this.nomJoueur.getText());

                    ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
                    partie.setPersonnage(new Chasseur(this.nomJoueur.getText()));
                    oos.writeObject(partie.getPersonnage());
                    oos.close();
                }
                if(this.choixPerso==3){
                    File fichier =  new File(Constante.CHEMIN_SAUVEGARDES+this.nomJoueur.getText());

                    ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
                    partie.setPersonnage(new Guerrier(this.nomJoueur.getText()));
                    oos.writeObject(partie.getPersonnage());
                    oos.close();
                }


                CombatController combatController = new CombatController(partie);
                combatController.launchCombatController(partie.getPrimaryStage());
                //On charge la page d'après
                /*FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));

                partie.setRoot(loader.load());

                CombatController combatCtrl = loader.getController();


                combatCtrl.setPartie(partie);

                partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
                partie.getPrimaryStage().show();*/
                /*DateFormat format = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
                Date date = new Date();

                String titreFichierSauvegarde = this.nomJoueur.getText() + "_" + format.format(date);

                FileWriter lu = new FileWriter(Constante.CHEMIN_SAUVEGARDES + titreFichierSauvegarde + ".txt");
                BufferedWriter out = new BufferedWriter(lu);
                infoFichierSauvegarde = null;
                if(this.choixPerso == 1){
                    Mage mage = new Mage();
                    infoFichierSauvegarde = new InfoFichierSauvegarde(titreFichierSauvegarde,
                            this.nomJoueur.getText(), this.choixPerso, mage.getPtsDeVie(),
                            mage.getMana(), mage.getNiveau(), mage.getListeArmes());
                }
                if(this.choixPerso == 2){
                    Chasseur chasseur = new Chasseur();
                    infoFichierSauvegarde = new InfoFichierSauvegarde(titreFichierSauvegarde,
                            this.nomJoueur.getText(), this.choixPerso, chasseur.getPtsDeVie(),
                            chasseur.getMana(), chasseur.getNiveau(), chasseur.getListeArmes());
                }
                if(this.choixPerso == 3){
                    Guerrier guerrier = new Guerrier();
                    infoFichierSauvegarde = new InfoFichierSauvegarde(titreFichierSauvegarde,
                            this.nomJoueur.getText(), this.choixPerso, guerrier.getPtsDeVie(),
                            guerrier.getMana(), guerrier.getNiveau(), guerrier.getListeArmes());
                }
                out.write(infoFichierSauvegarde.toString());
                out.close();

                //On charge la page d'après
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));

                partie.setRoot(loader.load());

                CombatController combatCtrl = loader.getController();


                combatCtrl.setPartie(partie);

                partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
                partie.getPrimaryStage().show();
            */}
            catch (Exception e) {;}
        }

    }


    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie){
        this.partie = partie;
    }

}
