package viewPackage;

import controllerPackage.Controller;
import exceptionPackage.*;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanneauListeSoins extends JPanel {

    private Controller controller;
    private JPanel panneauRecherche, panneauListe;
    private JLabel champTitre, ficheSoin, vide;
    private PanneauSpinnerDate dateDebutRech, dateFinRech;
    private JButton valider, rechercher;
    private JCheckBox dateDebut, dateFin;
    private ButtonGroup critèreRecherche;
    private JRadioButton animaux, vétérinaires, médicaments;
    private JComboBox listeIdentifiants, listeFichesDeSoins;
    private char critère;

    public PanneauListeSoins() {
        controller = new Controller();
        this.setLayout(new BorderLayout());
        panneauRecherche = new JPanel();
        panneauListe = new JPanel();

        this.add(panneauRecherche, BorderLayout.WEST);
        this.add(panneauListe, BorderLayout.CENTER);

        panneauRecherche.setLayout(new GridLayout(20, 2, 10, 5));
        panneauListe.setLayout(new GridLayout(20, 1, 10, 5));

        vide = new JLabel("");

        champTitre = new JLabel("<html><h1>Critères de recherche</h1></html>");
        champTitre.setHorizontalAlignment(SwingConstants.LEFT);
        panneauRecherche.add(champTitre);
        panneauRecherche.add(vide);

        animaux = new JRadioButton("Animaux");
        animaux.setHorizontalAlignment(SwingConstants.LEFT);
        panneauRecherche.add(animaux);
        panneauRecherche.add(vide);

        vétérinaires = new JRadioButton("Vétérinaires");
        vétérinaires.setHorizontalAlignment(SwingConstants.LEFT);
        panneauRecherche.add(vétérinaires);
        panneauRecherche.add(vide);

        médicaments = new JRadioButton("Médicaments");
        médicaments.setHorizontalAlignment(SwingConstants.LEFT);
        panneauRecherche.add(médicaments);
        panneauRecherche.add(vide);

        animaux.addActionListener(new RechercheListener());
        vétérinaires.addActionListener(new RechercheListener());
        médicaments.addActionListener(new RechercheListener());

        critèreRecherche = new ButtonGroup();
        critèreRecherche.add(animaux);
        critèreRecherche.add(vétérinaires);
        critèreRecherche.add(médicaments);

        //Combo Box qui dépend du bouton radio coché
        //switch(critère){
        //case 'a':
        //listeIdentifiantsAnimaux = new JComboBox();
        //liste toString des animauxcase 'a'
        //case 'v':
        //listeIdentifiantsAnimaux = new JComboBox();
        //liste toString des vétérinaires
        //case 'm':
        //listeIdentifiantsAnimaux = new JComboBox();
        //liste toString des médicaments
        //}

        listeIdentifiants = new JComboBox();
        panneauRecherche.add(listeIdentifiants);

        dateDebut = new JCheckBox("Date début");
        dateDebut.setHorizontalAlignment(SwingConstants.CENTER);
        panneauRecherche.add(dateDebut);

        dateDebutRech = new PanneauSpinnerDate();
        panneauRecherche.add(dateDebutRech);

        dateFin = new JCheckBox("Date fin");
        dateFin.setHorizontalAlignment(SwingConstants.CENTER);
        panneauRecherche.add(dateFin);

        dateFinRech = new PanneauSpinnerDate();
        panneauRecherche.add(dateFinRech);

        rechercher = new JButton("Rechercher");
        panneauRecherche.add(rechercher);

        ficheSoin = new JLabel("<html><h1>Fiche de soins</h1></html>");
        ficheSoin.setHorizontalAlignment(SwingConstants.CENTER);
        panneauListe.add(ficheSoin);

        panneauListe.add(vide);

        //Combo Box qui dépend de la recherche
        //liste toString fiches de soins des animaux

        listeFichesDeSoins = new JComboBox();
        panneauListe.add(listeFichesDeSoins);

        valider = new JButton("Valider");
        panneauListe.add(valider);


    }

    private class RechercheListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            listeIdentifiants.removeAllItems();
            if (event.getSource() == animaux){
                try {
                    for (Animal a: controller.getIdentifiantsAnimaux()){
                        String s = " #" + a.getNumRegistre() + " " + a.getNom();
                        listeIdentifiants.addItem(s);
                    }
                }
                catch (AnimalException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                catch (SingletonConnectionException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                catch (ProprietaireException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else if (event.getSource() == vétérinaires){
                try {
                    for (Veterinaire v: controller.getIdentifiantsVeterinaires()){
                        String s = " #" + v.getIdentifiantVeto() + " " + v.getNom();
                        listeIdentifiants.addItem(s);
                    }
                }
                catch (VeterinaireException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                catch (SingletonConnectionException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else if (event.getSource() == médicaments){
                try {
                    for (Medicament m: controller.getIdentifiantsMedicaments()){
                        String s = " #" + m.getIdentifiantMed() + " " + m.getNomMedic();
                        listeIdentifiants.addItem(s);
                    }
                }
                catch (MedicamentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                catch (SingletonConnectionException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            panneauRecherche.repaint();
            panneauRecherche.validate();
        }
    }
}
