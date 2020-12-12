package view;

import autre.Partie;
import constante.Constante;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class AfficherPersoController {

    private Partie partie;
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

    private ChoixSauvegardeController choixSauvegardeController;


    public void initialize() throws MalformedURLException {
        this.imgPersoDos.setImage(new Image((new File(Constante.CHEMIN_IMAGES + "archerDos.jpg")).toURI().toURL().toString()));
        this.ptsViePerso = new ProgressBar(1);
        this.ptsManaPerso = new ProgressBar(1);
        this.lvlPerso.setText(String.valueOf(this.partie.getPersonnage().getNiveau()));
        this.armePerso.setText("arc");

    }


    public AfficherPersoController(Partie partie){
        this.partie=partie;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }
}