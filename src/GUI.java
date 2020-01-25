
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tehreem
 */


public class GUI extends JApplet {

    JFrame fr;
    JLabel inputLb, amountLb1, outputLb, amountLb2, title;
    JButton btn1, btn2, currencies;
    JTextField tf1, tf2;
    JComboBox c1, c2;
    String[] currency = {"US Dollar", "Indian Rupee", "British Pound", "Euro", "Canadian Dollar", "Emirati Driham", "Chinese Yuan"};
    BtnHnd hnd;

    public GUI() {
        initGUI();
    }

    private void initGUI() {

        fr = new JFrame("Conversion Calculator");

        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        fr.setLayout(gbag);

        initComponents();
        addComponents();

        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbag.setConstraints(title, gbc);

        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(inputLb, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(c1, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(amountLb1, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(tf1, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(outputLb, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(c2, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(amountLb2, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(tf2, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbag.setConstraints(btn1, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(btn2, gbc);
        gbc.gridwidth = GridBagConstraints.PAGE_END;
        gbag.setConstraints(currencies, gbc);

        fr.setVisible(true);
        fr.setSize(500, 400);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        inputLb = new JLabel("Select the input currency: ");
        outputLb = new JLabel("Select the output currency: ");
        amountLb1 = new JLabel("Enter the amount: ");
        amountLb2 = new JLabel("Converted Amount: ");
        title = new JLabel("Currency Converter");
        btn1 = new JButton("Convert");
        btn2 = new JButton("Clear");
        currencies = new JButton("Currencies");
        tf1 = new JTextField(12);
        tf2 = new JTextField(12);
        c1 = new JComboBox(currency);
        c1.setSelectedIndex(0);
        c2 = new JComboBox(currency);
        c2.setSelectedIndex(1);
        hnd = new BtnHnd(this);
        btn1.addActionListener(hnd);
        btn2.addActionListener(hnd);
        currencies.addActionListener(hnd);
    }

    private void addComponents() {
        fr.add(title);
        fr.add(inputLb);
        fr.add(c1);
        fr.add(amountLb1);
        fr.add(tf1);
        fr.add(outputLb);
        fr.add(c2);
        fr.add(amountLb2);
        fr.add(tf2);
        fr.add(btn1);
        fr.add(btn2);
        fr.add(currencies);
    }

}
