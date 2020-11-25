package view;

import constante.Constante;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ChoixSauvegardeController {
    @FXML
    private VBox vboxListeSauvegarde;

    public void initialize() throws Exception {
        int nbSauvegarde = compterNbSauvegarde(Constante.CHEMIN_SAUVEGARDES);
        for(int i=0; i<nbSauvegarde; i++){
            Button btnSauvegarde;
        }
    }
    public int compterNbSauvegarde (String parent) throws Exception {
        File file = new File (parent);

        if (!file.exists ())
            throw new FileNotFoundException();
        return file.list ().length;
    }
}
