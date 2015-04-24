package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton cell1;
    private JButton cell2;
    private JButton cell3;
    private JButton cell4;
    private JButton cell5;
    private JButton cell6;
    private JButton cell7;
    private JButton cell8;
    private JButton cell9;
    private JButton newGame;
    private JButton exit;

    public void buildGUI() {
        JFrame mainFrame = new JFrame("Крестики-Нолики");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(400, 200, 300, 350);
        cell1 = new JButton();
        cell2 = new JButton();
        cell3 = new JButton();
        cell4 = new JButton();
        cell5 = new JButton();
        cell6 = new JButton();
        cell7 = new JButton();
        cell8 = new JButton();
        cell9 = new JButton();
        newGame = new JButton("Новая игра");
        exit = new JButton("Выход");
        GridLayout grid1 = new GridLayout(3,3);
        GridLayout grid2 = new GridLayout(1,2);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        mainFrame.add(BorderLayout.CENTER, panel1);
        mainFrame.add(BorderLayout.SOUTH, panel2);
        panel1.setLayout(grid1);
        panel1.add(cell1);
        panel1.add(cell2);
        panel1.add(cell3);
        panel1.add(cell4);
        panel1.add(cell5);
        panel1.add(cell6);
        panel1.add(cell7);
        panel1.add(cell8);
        panel1.add(cell9);
        panel2.setLayout(grid2);
        panel2.add(newGame);
        panel2.add(exit);
        mainFrame.setVisible(true);
    }
}
