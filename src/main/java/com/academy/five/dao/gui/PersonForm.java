package com.academy.five.dao.gui;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;
import com.academy.four.model.Gender;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PersonForm extends JFrame {
    private JTextField namefield = new JTextField(20);
    private JTextField surnamefield = new JTextField(20);
    private JTextField bithdayField = new JTextField(20);
    private JComboBox<Gender> genderComboBox = new JComboBox<>(Gender.values());
    private JTextField emailField = new JTextField(20);

    private JButton saveButton = new JButton("Sačuvaj Osobu");

    private PersonDao personDao = new PersonDao();

    public PersonForm() {
        setTitle("Person Management");
        setSize(420, 350);

        GridLayout gridLayout = new GridLayout(6, 2, 10, 10);
        JPanel panel = new JPanel(gridLayout);
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        panel.setBorder(emptyBorder);

        panel.add(new JLabel("Name:"));
        panel.add(namefield);

        panel.add(new JLabel("Surname:"));
        panel.add(surnamefield);

        panel.add(new JLabel("Bithday:"));
        panel.add(bithdayField);

        panel.add(new JLabel("Gender:"));
        panel.add(genderComboBox);

        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        panel.add(new JLabel(""));
        panel.add(saveButton);

        // LAMBDA - za kreiranje objekata tipa funkctionalnog interfejsa
//        ActionListener actionListener = (ActionEvent e) -> save(e);
        // METHOD REFERENCIRANJE - Kada lambda ne radi ništa drugo nego poziva neku metodu..onda se možemo samo referencirati na tu metodu
        //pomoćui method referencing operatora   ::
        ActionListener actionListener = this::save;
        saveButton.addActionListener(actionListener);
        add(panel);
    }

    private void save(ActionEvent e){
        Person person = new Person();
        person.setName(namefield.getText());
        person.setSurname(surnamefield.getText());
        LocalDate birthday = LocalDate.parse(bithdayField.getText());
        person.setBirthday(birthday);
        Gender gender = (Gender) genderComboBox.getSelectedItem();
        person.setGender(gender);
        person.setEmailAddress(emailField.getText());
        personDao.create(person);
        clearInputFields();
    }

    private void clearInputFields(){
        namefield.setText("");
        surnamefield.setText("");
        bithdayField.setText("");
        genderComboBox.setSelectedIndex(0);
        emailField.setText("");
    }


}
