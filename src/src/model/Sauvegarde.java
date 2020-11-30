package model;

import constante.Constante;

import java.io.File;
import java.io.FileNotFoundException;

public class Sauvegarde {
    String[] listeSauvegarde;

    public Sauvegarde() throws Exception {
        listeSauvegarde = listNbSauvegarde(Constante.CHEMIN_SAUVEGARDES);
    }

    public String[] listNbSauvegarde (String parent) throws Exception {
        File file = new File (parent);

        if (!file.exists ())
            throw new FileNotFoundException();
        return file.list();
    }

    public String[] getListeSauvegarde() {
        return listeSauvegarde;
    }



    public void setListeSauvegarde(String[] listeSauvegarde) {
        this.listeSauvegarde = listeSauvegarde;
    }
}