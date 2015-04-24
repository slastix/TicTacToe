package TicTacToe;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton[] cells;
    private JButton newGame;
    private JButton exit;
    public boolean xoro = true;

    public void buildGUI() {
        JFrame mainFrame = new JFrame("Крестики-Нолики");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(400, 200, 300, 350);

        newGame = new JButton("Новая игра");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCells();
            }
        });
        exit = new JButton("Выход");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        GridLayout grid1 = new GridLayout(3,3);
        GridLayout grid2 = new GridLayout(1,2);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        mainFrame.add(BorderLayout.CENTER, panel1);
        mainFrame.add(BorderLayout.SOUTH, panel2);

        panel1.setLayout(grid1);

        cells = new JButton[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new JButton("");
            Font f = new Font("Arial", Font.BOLD, 36);
            cells[i].setFont(f);
            cells[i].addActionListener(new ButtonStepActionListener(cells[i]));
            panel1.add(cells[i]);
        }

        panel2.setLayout(grid2);

        panel2.add(newGame);
        panel2.add(exit);

        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newGameMenuItem = new JMenuItem("New Game");

        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCells();
            }
        });

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        JMenuItem aboutMenuItem = new JMenuItem("About");

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(gameMenu);
        gameMenu.add(newGameMenuItem);
        gameMenu.add(quitMenuItem);
        menuBar.add(helpMenu);
        helpMenu.add(aboutMenuItem);

        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);
    }

    public void clearCells () {
        for (int i = 0; i < cells.length; i++) {
        cells[i].setText("");
        }
        xoro = true;
    }

    private String checkWinner () {
        if (cells[0].getText().equals(cells[1].getText()) && cells[1].getText().equals(cells[2].getText()) && !cells[0].getText().equals("")) return cells[0].getText();
        else if (cells[3].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[5].getText()) && !cells[3].getText().equals("")) return cells[3].getText();
        else if (cells[6].getText().equals(cells[7].getText()) && cells[7].getText().equals(cells[8].getText()) && !cells[6].getText().equals("")) return cells[6].getText();
        else if (cells[0].getText().equals(cells[3].getText()) && cells[3].getText().equals(cells[6].getText()) && !cells[0].getText().equals("")) return cells[0].getText();
        else if (cells[1].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[7].getText()) && !cells[1].getText().equals("")) return cells[1].getText();
        else if (cells[2].getText().equals(cells[5].getText()) && cells[5].getText().equals(cells[8].getText()) && !cells[2].getText().equals("")) return cells[2].getText();
        else if (cells[0].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[8].getText()) && !cells[0].getText().equals("")) return cells[0].getText();
        else if (cells[2].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[6].getText()) && !cells[2].getText().equals("")) return cells[6].getText();
        else return null;

    }

    private class ButtonStepActionListener implements ActionListener {
        private JButton button;

        public ButtonStepActionListener (JButton button) {
            this.button = button;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (xoro) {
                if (button.getText().equals("")) {
                    button.setText("X");
                    xoro = false;
                }
            }
            else {
                if (button.getText().equals("")) {
                    button.setText("O");
                    xoro = true;
                }
                if (checkWinner() != null) {
                    // JFrame winFrame
                }

            }
        }
    }
}
