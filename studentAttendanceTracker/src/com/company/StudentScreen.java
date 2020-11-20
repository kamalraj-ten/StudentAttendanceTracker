package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentScreen {
    // data members
    private JPanel rootPanel;
    private JLabel nametext;
    private JLabel datetext;
    private JLabel classtext;
    private JTable tab;
    private String rollno;
    Student S;

    public StudentScreen(String rollno) throws Exception {
        this.rollno = rollno;
        // creating a Student object for the given roll no
        // by default the month is set to the most recent month
        S = new Student(rollno,StudentAttendance.fileNames[2]);
        createTable();
        getNametext();
        getClasstext();
        getDatetext();
    }

    public static void createGUI(String rollno) throws Exception {
        StudentScreen ui = new StudentScreen(rollno);
        JPanel root = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private JLabel getClasstext() {
        // initializes the classtext
        classtext.setText("BE.CSE-G2");
        return classtext;
    }

    private JLabel getNametext() throws Exception {
        // initializes the nametext
        nametext.setText(S.getName());
        return nametext;
    }

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
    Date date = new Date();

    public JLabel getDatetext() {
        // initializes and returns datatext
        datetext.setText(dateFormat.format(date));
        return datetext;
    }

    private void createTable() throws Exception {
        Object[] columns = {"Subject", "Present", "Absent", "Precentage"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tab.setModel(model);
        AttendanceData[] arr = S.getTotalAttendance();
        Object[] rows = new Object[4];
        for (AttendanceData x : arr) {
            rows[1] = x.getData()[0];
            rows[2] = x.getData()[1];
            rows[3] = x.getPercentage();
            rows[0] = x.getSubject();//Separate methods for accessing separate data
            model.addRow(rows);
        }
        tab.setDefaultRenderer(Object.class, new CustomTableRenderer(3));

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
        $$$setupUI$$$(); // call to set the element is position in the screen
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() { // sets the layout and positions for components
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        rootPanel.setPreferredSize(new Dimension(1500, 500));
        final JScrollPane scrollPane1 = new JScrollPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 12;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.gridheight = 20;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(scrollPane1, gbc);
        tab = new JTable();
        tab.setEnabled(false);
        tab.setForeground(new Color(-16777216));
        tab.setSelectionForeground(new Color(-16777216));
        scrollPane1.setViewportView(tab);
        final JLabel label1 = new JLabel();
        label1.setText("Date : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 20;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(label1, gbc);
        datetext = new JLabel();
        datetext.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 10;
        gbc.gridy = 20;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(datetext, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 11;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(spacer1, gbc);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Calibri Light", Font.BOLD, 22, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("ATTENDANCE TRACKER");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 10;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        rootPanel.add(label2, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer2, gbc);
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Calibri", -1, 18, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Class : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 17;
        rootPanel.add(label3, gbc);
        classtext = new JLabel();
        Font classtextFont = this.$$$getFont$$$("Calibri", Font.BOLD, 25, classtext.getFont());
        if (classtextFont != null) classtext.setFont(classtextFont);
        classtext.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 17;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(classtext, gbc);
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Calibri", Font.BOLD, 18, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText(" Name : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.EAST;
        rootPanel.add(label4, gbc);
        nametext = new JLabel();
        Font nametextFont = this.$$$getFont$$$("Calibri", Font.BOLD, 25, nametext.getFont());
        if (nametextFont != null) nametext.setFont(nametextFont);
        nametext.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(nametext, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer3, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
