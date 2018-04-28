package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanneauAccueil extends JPanel {
    //private JLabel texte;
    private JPanel panneauFormulaire;
    private JPanel panneauBoutons;
    private JLabel lieuxSPALabel, celluleLabel, numeroRegistreLabel, rempliParLabel, dateRemplissageLabel, aEuthanasierLabel, raisonEuthanasieLabel;
    private JLabel dateArriveLabel, dateDepartLabel, especeLabel, raceLabel, pelagePeauLabel, dateNaissanceLabel, numeroPuceLabel, localisationLabel;
    private JLabel attributionLabel, numeroTatouageLabel, incertainLocalisationTatouageLabel, incertainDateTatouageLabel, dateTatouageLabel, titreProprietaireLabel;
    private JLabel remarqueLabel;
    private JTextField lieuxSPA, cellule, numeroRegistre, rempliPar, raisonEuthanasie, espece, race, pelagePeau, numeroPuce, localisation, numeroTatouage;
    private PanneauSpinnerDate dateRemplissage, dateEuthanasie, dateArrive, dateDepart, dateNaissance, dateAttribution, dateTatouage;
    private JButton  retour, validation, reinnitialiser;
    private JCheckBox aEuthanasier, estIncertainDateTatouage, estIncertainLocalisationTatouage;
    private ButtonGroup sexeGroupeBouton, steriliseGroupeBouton;
    private JRadioButton boutonMale, boutonFemelle, boutonOuiSterilise, boutonNonSterilise;
    private JComboBox listeProprios;
    private JButton ajoutProprio;
    private JTextArea remarque;
    private JScrollPane scroll;

    public PanneauAccueil() {
        this.setLayout(new BorderLayout());

        panneauFormulaire = new JPanel();
        panneauBoutons = new JPanel();
        this.add(panneauFormulaire, BorderLayout.CENTER);
        this.add(panneauBoutons, BorderLayout.SOUTH);
        panneauFormulaire.setLayout(new GridLayout(15,4,5,5));
        scroll = new JScrollPane();
        this.add(scroll, BorderLayout.EAST);

        dateRemplissageLabel = new JLabel("Date actuelle :");
        dateRemplissageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(dateRemplissageLabel);
        dateRemplissage = new PanneauSpinnerDate();
        panneauFormulaire.add(dateRemplissage);

        panneauFormulaire.add(new JLabel(""));
        panneauFormulaire.add(new JLabel(""));

        lieuxSPALabel = new JLabel("SPA de :");
        lieuxSPALabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(lieuxSPALabel);
        lieuxSPA = new JTextField();
        panneauFormulaire.add(lieuxSPA);

        celluleLabel = new JLabel("N° de cellule :");
        celluleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(celluleLabel);
        cellule = new JTextField();
        panneauFormulaire.add(cellule);

        numeroRegistreLabel = new JLabel("N° de registre :");
        numeroRegistreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(numeroRegistreLabel);
        numeroRegistre = new JTextField();
        panneauFormulaire.add(numeroRegistre);

        rempliParLabel = new JLabel("Rempli par :");
        rempliParLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(rempliParLabel);
        rempliPar = new JTextField();
        panneauFormulaire.add(rempliPar);

        aEuthanasier = new JCheckBox("à euthanasier :");
        aEuthanasier.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(aEuthanasier);

        aEuthanasierLabel = new JLabel("prévu pour le :");
        dateEuthanasie = new PanneauSpinnerDate();
        panneauFormulaire.add(dateEuthanasie);

        raisonEuthanasieLabel = new JLabel("Raison de l'ethanasie :");
        raisonEuthanasieLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(raisonEuthanasieLabel);
        raisonEuthanasie = new JTextField();
        panneauFormulaire.add(raisonEuthanasie);

        dateArriveLabel = new JLabel("Date d'arrivée :");
        dateArriveLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(dateArriveLabel);
        dateArrive = new PanneauSpinnerDate();
        panneauFormulaire.add(dateArrive);

        dateDepartLabel = new JLabel("Date de départ :");
        dateDepartLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(dateDepartLabel);
        dateDepart = new PanneauSpinnerDate();
        panneauFormulaire.add(dateDepart);

        especeLabel = new JLabel("Espèce :");
        especeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(especeLabel);
        espece = new JTextField();
        panneauFormulaire.add(espece);

        raceLabel = new JLabel("Race :");
        raceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(raceLabel);
        race = new JTextField();
        panneauFormulaire.add(race);

        boutonMale = new JRadioButton("Male");
        boutonMale.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(boutonMale);
        boutonFemelle = new JRadioButton("Femelle");
        boutonFemelle.setHorizontalAlignment(SwingConstants.LEFT);
        panneauFormulaire.add(boutonFemelle);
        sexeGroupeBouton = new ButtonGroup();
        sexeGroupeBouton.add(boutonMale);
        sexeGroupeBouton.add(boutonFemelle);

        boutonOuiSterilise = new JRadioButton("Stérilisé.e");
        boutonOuiSterilise.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(boutonOuiSterilise);
        boutonNonSterilise = new JRadioButton("Non stérilisé.e");
        boutonNonSterilise.setHorizontalAlignment(SwingConstants.LEFT);
        panneauFormulaire.add(boutonNonSterilise);
        steriliseGroupeBouton = new ButtonGroup();
        steriliseGroupeBouton.add(boutonOuiSterilise);
        steriliseGroupeBouton.add(boutonNonSterilise);

        dateNaissanceLabel = new JLabel("Date de naissance :");
        dateNaissanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dateNaissance = new PanneauSpinnerDate();
        panneauFormulaire.add(dateNaissanceLabel);
        panneauFormulaire.add(dateNaissance);

        pelagePeauLabel = new JLabel("Pelage/Peau :");
        pelagePeauLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(pelagePeauLabel);
        pelagePeau = new JTextField();
        panneauFormulaire.add(pelagePeau);

        numeroPuceLabel = new JLabel("Numéro de puce :");
        numeroPuceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(numeroPuceLabel);
        numeroPuce = new JTextField();
        panneauFormulaire.add(numeroPuce);

        numeroTatouageLabel = new JLabel("Numéro de tatouage :");
        numeroTatouageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(numeroTatouageLabel);
        numeroTatouage = new JTextField();
        panneauFormulaire.add(numeroTatouage);

        localisationLabel = new JLabel("Localisation de la puce:");
        localisationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(localisationLabel);
        localisation = new JTextField();
        panneauFormulaire.add(localisation);

        incertainLocalisationTatouageLabel = new JLabel("Incertain :");
        incertainLocalisationTatouageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(incertainLocalisationTatouageLabel);
        estIncertainLocalisationTatouage = new JCheckBox();
        panneauFormulaire.add(estIncertainLocalisationTatouage);

        attributionLabel = new JLabel("Date d'attribution de la puce :");
        attributionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(attributionLabel);
        dateAttribution = new PanneauSpinnerDate();
        panneauFormulaire.add(dateAttribution);

        dateTatouageLabel = new JLabel("Date d'attribution du tatouage :");
        dateTatouageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(dateTatouageLabel);
        dateTatouage = new PanneauSpinnerDate();
        panneauFormulaire.add(dateTatouage);

        panneauFormulaire.add(new JLabel(""));
        panneauFormulaire.add(new JLabel(""));

        incertainDateTatouageLabel = new JLabel("Incertain :");
        incertainDateTatouageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(incertainDateTatouageLabel);
        estIncertainDateTatouage = new JCheckBox();
        panneauFormulaire.add(estIncertainDateTatouage);

        titreProprietaireLabel = new JLabel("<html><h1>Propriétaire (si connu)</h1></html>");
        titreProprietaireLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(titreProprietaireLabel);

        String values[] = {"Faire la recherche dans la BD"};
        listeProprios = new JComboBox(values);
        panneauFormulaire.add(listeProprios);

        ajoutProprio = new JButton("Ajouter un propriétaire");
        ajoutProprio.addActionListener(new NouveauProprio());
        panneauFormulaire.add(ajoutProprio);

        panneauFormulaire.add(new JLabel(""));

        remarqueLabel = new JLabel("<html><h1>Remarques</h1></html>");
        remarqueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panneauFormulaire.add(remarqueLabel);

        remarque = new JTextArea(1,15);
        panneauFormulaire.add(remarque);

        panneauBoutons.setLayout(new FlowLayout());
        retour = new JButton("Retour");
        panneauBoutons.add(retour);
        validation = new JButton("Valider");
        panneauBoutons.add(validation);
        reinnitialiser = new JButton("Reinnitialiser");
        panneauBoutons.add(reinnitialiser);
    }


    private class NouveauProprio implements ActionListener {
        private FenetreProprio fenetreProprio;
        public void actionPerformed(ActionEvent event){
            fenetreProprio = new FenetreProprio();
        }
    }
}
