package view;

import autre.Partie;
import constante.Constante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class LancementDuJeuController {
    private Partie partie;

    @FXML
    private Button btnJouerJeu;

    @FXML
    private Button btnQuitterJeu;

    @FXML
    private Button btnParametreJeu;

    @FXML
    private ImageView imgFond;


    public void initialize() throws MalformedURLException {
        this.imgFond.setImage(new Image((new File(Constante.CHEMIN_IMAGES + "fond_accueil_2.jpg")).toURI().toURL().toString()));
    }

    @FXML
    private void lancementChoixPerso() throws IOException {
        partie.setRoot(new AnchorPane());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Partie.class.getResource("/view/ChoixPersonnage.fxml"));

        partie.setRoot(loader.load());

        ChoixPersonnageController choixPersoCtrl = new ChoixPersonnageController();

        choixPersoCtrl.setPartie(partie);

        partie.getPrimaryStage().setScene(new Scene(partie.getRoot(), 1440, 720));
        partie.getPrimaryStage().show();
    }

    @FXML
    public void quitterJeu(){

    }

    @FXML
    public void choixParametre(){

    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

}
