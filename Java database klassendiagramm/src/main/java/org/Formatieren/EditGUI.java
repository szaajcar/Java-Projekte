package org.Formatieren;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EditGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField vornameField, nameField, geschlechtField, geburtsdatumField, ahv_nummerField, regionField, kinderField;
    private JButton saveButton;
    private Person person;
    private MainGUI mainGUI;

    public EditGUI(Person person,MainGUI mainGUI) {
        this.person = person;
        this.mainGUI = mainGUI;

        frame = new JFrame("Bearbeiten");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        vornameField = new JTextField(person.getVorname(), 20);
        panel.add(new JLabel("Vorname:"));
        panel.add(vornameField);

        nameField = new JTextField(person.getName(), 20);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        geschlechtField = new JTextField(person.getGeschlecht(), 20);
        panel.add(new JLabel("Geschlecht:"));
        panel.add(geschlechtField);

        geburtsdatumField = new JTextField(person.getGeburtsdatum(), 20);
        panel.add(new JLabel("Geburtsdatum:"));
        panel.add(geburtsdatumField);

        ahv_nummerField = new JTextField(person.getAhvNummer(), 20);
        panel.add(new JLabel("AHV Nummer:"));
        panel.add(ahv_nummerField);

        regionField = new JTextField(person.getRegion(), 20);
        panel.add(new JLabel("Region:"));
        panel.add(regionField);

        kinderField = new JTextField(String.valueOf(person.getKinder()), 20);
        panel.add(new JLabel("Kinder:"));
        panel.add(kinderField);

        saveButton = new JButton("Speichern");
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hier sollten die korrekten set-Methoden der Person-Klasse aufgerufen werden
                person.setVorname(vornameField.getText());
                person.setName(nameField.getText());
                person.setGeschlecht(geschlechtField.getText());
                person.setGeburtsdatum(geburtsdatumField.getText());
                person.setAhvNummer(ahv_nummerField.getText());
                person.setRegion(regionField.getText());
                person.setKinder(Integer.parseInt(kinderField.getText()));
                mainGUI.updatePerson();
                frame.dispose();

            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void showEditWindow() {
        frame.setVisible(true);
    }
}
