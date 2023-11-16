package org.Formatieren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    private JPanel panel;
    private JLabel lblVorname, lblName, lblRegion, lblDatum, lblGeschlecht, lblKinder, lblAHV;
    private JLabel textVorname, textName, textRegion, textDatum, textGeschlecht, textKinder, textAHV;
    private JButton links, rechts, bearbeiten;


    private Testverbindung testverbindung;

    private ArrayList<Person> personen;
    private Person person;
    private int index;

    public MainGUI() {
        panel = new JPanel(new GridLayout(0,2));

        index = 0;
        personen = new ArrayList<>();
        testverbindung = new Testverbindung(personen);

        initLabels();
        initButtons();

        updatePerson();

        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    private void initButtons() {
        links = new JButton("<<");
        rechts = new JButton(">>");
        bearbeiten = new JButton("bearbeiten");
        MainGUI mainGui = this;

        panel.add(new JLabel());
        panel.add(bearbeiten);
        panel.add(links);
        panel.add(rechts);

        links.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index--;
                updatePerson();
            }
        });

        rechts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                updatePerson();
            }
        });

        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditGUI(person, mainGui);
            }
        });
    }

    private void initLabels() {
        panel.setLayout(new GridLayout(0, 2));

        lblVorname = new JLabel("Vorname:");
        textVorname = new JLabel();

        lblName = new JLabel("Name:");
        textName = new JLabel();

        lblRegion = new JLabel("Region:");
        textRegion = new JLabel();

        lblDatum = new JLabel("Datum:");
        textDatum = new JLabel();

        lblGeschlecht = new JLabel("Geschlecht:");
        textGeschlecht = new JLabel();

        lblKinder = new JLabel("Kinder:");
        textKinder = new JLabel();

        lblAHV = new JLabel("AHV:");
        textAHV = new JLabel();


        panel.add(lblVorname);
        panel.add(textVorname);
        panel.add(lblName);
        panel.add(textName);
        panel.add(lblRegion);
        panel.add(textRegion);
        panel.add(lblDatum);
        panel.add(textDatum);
        panel.add(lblGeschlecht);
        panel.add(textGeschlecht);
        panel.add(lblKinder);
        panel.add(textKinder);
        panel.add(lblAHV);
        panel.add(textAHV);
    }


    public void updatePerson() {
        person = personen.get(index);

        textVorname.setText(person.getVorname());
        textName.setText(person.getName());
        textRegion.setText(person.getRegion());
        textDatum.setText(person.getGeburtsdatum());
        textGeschlecht.setText(person.getGeschlecht());
        textKinder.setText(String.valueOf(person.getKinder()));
        textAHV.setText(person.getAhvNummer());
    }



}
