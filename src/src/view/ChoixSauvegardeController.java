package view;

import autre.Arme;
import autre.Partie;
import constante.Constante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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


    public void lancerPartie1() throws IOException {
        if(!btnPartie1.getText().equals("Nouvelle Partie")){
            //lecture du fichier texte
            String chaine ="";
            try{
                InputStream ips=new FileInputStream(Constante.CHEMIN_SAUVEGARDES + btnPartie1.getText());
                InputStreamReader ipsr=new InputStreamReader(ips);
                BufferedReader br=new BufferedReader(ipsr);
                String ligne;
                while ((ligne=br.readLine())!=null){
                    chaine += ligne;
                }
                br.close();
                chargerCombat();
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
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

    public void lancerPartie2() throws IOException {
        if(!btnPartie2.getText().equals("Nouvelle Partie")){
            //lecture du fichier texte
            String chaine ="";
            String chaine2 = "";
            try{
                InputStream ips=new FileInputStream(Constante.CHEMIN_SAUVEGARDES + btnPartie2.getText());
                InputStreamReader ipsr=new InputStreamReader(ips);
                BufferedReader br=new BufferedReader(ipsr);
                String ligne;
                String ligne2 = "";

                while ((ligne=br.readLine())!=null){
                    chaine += ligne + '\n';
                }
                while((ligne=br.readLine())!="\n"){
                    chaine2 = ligne;
                }
                for(String element : chaine.split("\n")){
                    ligne = element;
                }
                for(String element : chaine2.split("-")){
                    ligne2 = element;
                }
                System.out.println(ligne2);
                br.close();
                chargerCombat();
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
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

    public void lancerPartie3() throws IOException {
        if(!btnPartie3.getText().equals("Nouvelle Partie")){
            //lecture du fichier texte
            String chaine ="";
            try{
                InputStream ips=new FileInputStream(Constante.CHEMIN_SAUVEGARDES + btnPartie3.getText());
                InputStreamReader ipsr=new InputStreamReader(ips);
                BufferedReader br=new BufferedReader(ipsr);
                String ligne;
                while ((ligne=br.readLine())!=null){
                    chaine += ligne;
                }
                br.close();
                chargerCombat();
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Partie.class.getResource("/view/Combat.fxml"));

        partie.setRoot(loader.load());

        CombatController combatCtrl = loader.getController();

        combatCtrl.setPartie(partie);

        partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1280, 720));
        partie.getPrimaryStage().show();
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
