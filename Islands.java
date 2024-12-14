import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Islands implements ActionListener {
    JFrame frame;
    JTextField field;
    JButton[][] gridButtons = new JButton[9][9];
    JButton[] functionButtons = new JButton[10];
    JButton areaButton, periButton, noButton;
    JPanel panel;
    Font myFont = new Font("Cascadia Code", Font.BOLD, 16);
    double num1 = 0, num2 = 0, res = 0;
    char op;
    int[][] map = new int[9][9];

    Islands() {
        frame = new JFrame();
        frame.setTitle("Map of Islands");
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(490, 550);
        frame.setResizable(false);
        frame.setLayout(null);

        field = new JTextField();
        field.setBounds(50, 25, 375, 50);
        field.setFont(myFont);
        field.setBackground(Color.lightGray);
        field.setEditable(false);

        areaButton = new JButton("Area");
        periButton = new JButton("Perimeter");
        noButton = new JButton("No of islands");

        functionButtons[0] = areaButton;
        functionButtons[1] = periButton;
        functionButtons[2] = noButton;
        for (int i = 0; i < 3; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gridButtons[i][j] = new JButton();
                gridButtons[i][j].setBackground(Color.BLUE);
                gridButtons[i][j].addActionListener(this);
                gridButtons[i][j].setFont(myFont);
                gridButtons[i][j].setFocusable(false);
            }
        }
        noButton.setBounds(50, 430, 100, 50);
        periButton.setBounds(170, 430, 100, 50);
        areaButton.setBounds(290, 430, 100, 50);
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(9, 9, 10, 10));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                panel.add(gridButtons[i][j]);
            }
        }
        frame.add(panel);
        frame.add(field);
        frame.add(areaButton);
        frame.add(periButton);
        frame.add(noButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Islands c = new Islands();
    }
    void dfs(int[][] map2, int i, int j) {
            int rows = map2.length;
            int cols = map2[0].length;
            if (i < 0 || j < 0 || i >= rows || j >= cols || map2[i][j] != 1) {
                return;
            }
            map2[i][j] = -1;
            dfs(map2, i + 1, j);
            dfs(map2, i - 1, j);
            dfs(map2, i, j + 1);
            dfs(map2, i, j - 1);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (e.getSource() == gridButtons[i][j]) {
                    if (gridButtons[i][j].getBackground().equals(Color.BLUE)) {
                        map[i][j] = 1;
                        gridButtons[i][j].setBackground(Color.YELLOW);
                    } else {
                        map[i][j] = 0;
                        gridButtons[i][j].setBackground(Color.BLUE);
                    }
                }
            }
        }
        if (e.getSource() == areaButton) {
            int area = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (map[x][y] == 1) {
                        area += 1;
                    }
                }
            }
            field.setText(Integer.toString(area));
        }
        if (e.getSource() == periButton) {
            int perimeter = 0;
            int rows = map.length;
            int cols = map[0].length;
            
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (map[r][c] == 1) {
                        perimeter += 4;
                        if (r > 0 && map[r-1][c] == 1) {
                            perimeter -= 2;
                        }
                        if (c > 0 && map[r][c-1] == 1) {
                            perimeter -= 2;
                        }
                    }
                }
            }
            field.setText(Integer.toString(perimeter));
        }
        if (e.getSource() == noButton) {
            int[][] map2 = new int[9][9];
            for (int i=0; i<9; i++) {
                for (int j=0;j<9;j++) {
                    map2[i][j]=map[i][j];
                }
            }
        
            int count = 0;
            int rows = map2.length;
            int cols = map2[0].length;
        
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map2[i][j] == 1) { 
                        count++;
                        dfs(map2, i, j);
                    }
                }
            }
            field.setText(Integer.toString(count));
        }
    }
    }

