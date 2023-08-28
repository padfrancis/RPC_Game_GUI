package RPC_Game_GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.*;
public class Frames extends JFrame implements ActionListener
{
    int width = 200;
    int height = 200;
    ImageIcon gifIcon = new ImageIcon("src/RPC_Game_GUI/icons/bg.jpg");
    JLabel backgroundLabel = new JLabel(gifIcon);
    Image resetButton = new ImageIcon("src/RPC_Game_GUI/icons/reset.png").getImage().getScaledInstance(200, 70, java.awt.Image.SCALE_DEFAULT);
    ImageIcon rest = new ImageIcon(resetButton);
    ImageIcon im = new ImageIcon("src/RPC_Game_GUI/icons/logo.png");
    Image fistIcon = new ImageIcon("src/RPC_Game_GUI/icons/fist2.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon FI = new ImageIcon(fistIcon);
    Image paperIcon = new ImageIcon("src/RPC_Game_GUI/icons/paper2.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon PI = new ImageIcon(paperIcon);
    Image scissorsIcon = new ImageIcon("src/RPC_Game_GUI/icons/scissors2.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon SI = new ImageIcon(scissorsIcon);
    Image fistIcon2 = new ImageIcon("src/RPC_Game_GUI/icons/fist3.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon FI2 = new ImageIcon(fistIcon2);
    Image paperIcon2 = new ImageIcon("src/RPC_Game_GUI/icons/paper.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon PI2 = new ImageIcon(paperIcon2);
    Image scissorsIcon2 = new ImageIcon("src/RPC_Game_GUI/icons/scissors.png").getImage().getScaledInstance(width,height, java.awt.Image.SCALE_DEFAULT);
    ImageIcon SI2 = new ImageIcon(scissorsIcon2);
    JButton fist = new JButton();
    JButton sci = new JButton();
    JButton paper = new JButton();
    JRadioButton[] themeRadios;
    JPanel choice = new JPanel();
    JPanel up = new JPanel();
    JLabel title = new JLabel();
    Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "", TitledBorder.BOTTOM, TitledBorder.BOTTOM, new Font("Arial", Font.BOLD, 16), Color.BLACK);
    JPanel players = new JPanel();
    JLabel names = new JLabel();
    JLabel user = new JLabel();
    JLabel comp = new JLabel();
    JPanel move = new JPanel();
    JLabel stat = new JLabel();
    JLabel moves = new JLabel();
    int num = 10;
    JPanel bottom = new JPanel();
    JLabel WL = new JLabel();
    SecureRandom rand = new SecureRandom();
    int CoScore = 0;
    int UserScore = 0;
    JLabel sc = new JLabel();
    JButton again = new JButton();
    JLabel winner = new JLabel();
    Frames ()
    {
        setAll();
        this.setLayout(null);
        this.setTitle("Rock Paper & Scissors");
        this.setIconImage(im.getImage());
        this.setResizable(false);
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        //this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.add(choice);
        this.add(again);
        this.add(up);
        this.add(players);
        this.add(move);
        this.add(bottom);
        this.add(winner);
        this.add(backgroundLabel);
        this.setVisible(true);
    }
    void setAll()
    {
        //fist codes
        fist.setIcon(FI);
        fist.setFocusable(false);
        fist.setOpaque(false);
        fist.setFocusPainted(false);
        fist.setBackground(new Color(0,0,0,0));
        //fist.setBorderPainted(false);
        fist.addActionListener(this);
        fist.setUI(new CustomButtonUI());
        fist.setSize(FI.getIconWidth(), FI.getIconHeight());

        //scissors codes
        sci.setIcon(SI);
        sci.setFocusable(false);
        sci.setOpaque(false);
        //sci.setBorderPainted(false);
        sci.setFocusPainted(false);
        sci.addActionListener(this);
        sci.setBackground(new Color(0,0,0,0));
        sci.setSize(SI.getIconWidth(),SI.getIconHeight());
        sci.setUI(new CustomButtonUI());

        //paper codes
        paper.setIcon(PI);
        paper.setFocusable(false);
        paper.setOpaque(false);
        //paper.setBorderPainted(false);
        paper.setFocusPainted(false);
        paper.setUI(new CustomButtonUI());
        paper.setBackground(new Color(0,0,0,0));
        paper.addActionListener(this);
        paper.setSize(PI.getIconWidth(),PI.getIconHeight());

        //Options Panel Codes
        choice.setBounds(110, 400, 780, 220);
        choice.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        choice.add(fist);
        choice.add(sci);
        choice.add(paper);
        choice.setOpaque(false);

        //Themes Codes
        String[] themes = {"Realistic", "Unrealistic"};
        themeRadios = new JRadioButton[themes.length];
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < themes.length; i++)
        {
            themeRadios[i] = new JRadioButton(themes[i]);
            themeRadios[i].setFocusable(false);
            themeRadios[i].setOpaque(false);
            themeRadios[i].setHorizontalAlignment(SwingConstants.RIGHT);
            themeRadios[i].setFont(new Font("Arial", Font.BOLD, 16));
            themeRadios[i].addActionListener(this);
            themeRadios[i].setForeground(Color.BLACK);
            //themeRadios[i].setBackground(new Color(59, 60, 54));
            group.add(themeRadios[i]);
        }
        themeRadios[0].setSelected(true);
        themeRadios[0].addActionListener(this);
        themeRadios[1].addActionListener(this);

        //Top Part Codes
        up.setBounds(0, -10, 1040,50);
        up.add(title);
        up.setOpaque(false);
        up.setBorder(border);
        for (JRadioButton radio : themeRadios)
        {
            up.add(radio);
        }

        //title codes
        title.setBounds(0, 0 , 200, 50);
        title.setText("                         Rock Paper Scissors         ");
        title.setFont(new Font("Comic Sans" , Font.BOLD, 40));
        title.setForeground(Color.BLACK);

        //player codes
        players.setBounds(0, 80, 1024, 100);
        players.add(names);
        players.add(user);
        players.add(comp);
        players.setOpaque(false);
        players.setLayout(null);

        //names code
        names.setText("            Player                                       Computer");
        names.setBounds(0, 0, 1024, 50);
        names.setFont(new Font("Comic Sans" , Font.BOLD, 40));
        names.setForeground(Color.BLACK);
        names.setOpaque(false);

        //UserScore Codes
        user.setText(String.valueOf(UserScore));
        user.setBounds(175,-25, 200,200);
        user.setForeground(Color.BLACK);
        user.setFont(new Font("Comic Sans" , Font.BOLD, 40));

        //computer score codes
        comp.setText(String.valueOf(CoScore));
        comp.setBounds(760,-25, 200,200);
        comp.setForeground(Color.BLACK);
        comp.setFont(new Font("Comic Sans" , Font.BOLD, 40));

        //inner panel code
        move.setBounds(0,180, 1024, 200);
        move.setBackground(Color.LIGHT_GRAY);
        move.add(stat);
        move.add(moves);
        move.add(sc);
        move.setOpaque(false);
        move.setLayout(null);

        //status codes
        stat.setText("Choose a Move");
        stat.setFont(new Font("Sans Serif", Font.BOLD, 45));
        stat.setBounds(330, -30, 400,200);
        stat.setForeground(Color.BLACK);

        //moves code
        moves.setText("Moves left: ");
        moves.setFont(new Font("Sans Serif", Font.BOLD, 30));
        moves.setBounds(400, 20, 500, 200);
        moves.setForeground(Color.BLACK);

        //SC codes
        sc.setFont(new Font("Sans Serif", Font.BOLD, 30));
        sc.setText(String.valueOf(num));
        sc.setBounds(560, 20, 200, 200);
        sc.setForeground(Color.BLACK);
        //bottom panel codes
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom.setBounds(0, 630, 1024, 50);
        bottom.setBackground(Color.WHITE);
        bottom.add(WL);
        bottom.setOpaque(false);

        //WL codes
        WL.setText("");
        WL.setSize(400,50);
        WL.setFont(new Font("Sans Serif", Font.BOLD, 40));
        WL.setForeground(Color.BLACK);

        //again button code
        again.setBounds(387,500,rest.getIconWidth(),rest.getIconHeight());
        again.setIcon(rest);
        again.setForeground(Color.BLACK);
        again.setOpaque(false);
        again.setFocusable(false);
        again.addActionListener(this);
        again.setUI(new CustomButtonUI());
        again.setVisible(false);

        //winner codes
        winner.setFont(new Font("Sans Serif", Font.BOLD, 50));
        winner.setBounds(250,100,700,500);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==themeRadios[0])
        {
            fist.setIcon(FI);
            sci.setIcon(SI);
            paper.setIcon(PI);
        }
        if(e.getSource()==themeRadios[1])
        {
            fist.setIcon(FI2);
            sci.setIcon(SI2);
            paper.setIcon(PI2);
        }
        if(num>0)
        {
            if (e.getSource() == fist) {
                int Comp = rand.nextInt(3) + 1;
                updateMovesLeft();
                switch (Comp)
                {
                    case 1:
                        updateResult("Its a tie!");
                        break;
                    case 2:
                        updateResult("You Win!");
                        updateUserScore();
                        break;
                    case 3:
                        updateResult("You Lose!");
                        updateCompScore();
                        break;
                    default:
                        break;
                }
            }
            else if (e.getSource() == paper)
            {
                int Comp = rand.nextInt(3) + 1;
                updateMovesLeft();
                switch (Comp)
                {
                    case 1:
                        updateResult("You Win!");
                        updateUserScore();
                        break;
                    case 2:
                        updateResult("You Lose!");
                        updateCompScore();
                        break;
                    case 3:
                        updateResult("Its a tie!");
                        break;
                    default:
                        break;
                }
            }
            else if (e.getSource() == sci)
            {
                int Comp = rand.nextInt(3) + 1;
                updateMovesLeft();
                switch (Comp)
                {
                    case 1:
                        updateResult("You Win!");
                        updateUserScore();
                        break;
                    case 2:
                        updateResult("You Lose!");
                        updateCompScore();
                        break;
                    case 3:
                        updateResult("Its a tie!");
                        break;
                    default:
                        break;
                }
            }
        }
        if(e.getSource()==again)
        {
            again.setVisible(false);
            choice.setVisible(true);
            UserScore = 0;
            CoScore = 0;
            num = 10;
            SwingUtilities.invokeLater(() -> user.setText(String.valueOf(UserScore)));
            SwingUtilities.invokeLater(() -> comp.setText(String.valueOf(CoScore)));
            SwingUtilities.invokeLater(() -> sc.setText(String.valueOf(num)));
            stat.setText("Choose a Move");
            moves.setVisible(true);
            sc.setVisible(true);
            winner.setVisible(false);
            WL.setVisible(true);
            WL.setText("");
        }
    }
    private void updateMovesLeft() {
        num--;
        SwingUtilities.invokeLater(() -> sc.setText(String.valueOf(num)));
        if (num==0)
        {
            choice.setVisible(false);
            stat.setText("   Game Over!");
            WL.setVisible(false);
            again.setVisible(true);
            moves.setVisible(false);
            sc.setVisible(false);
            winner.setVisible(true);
            if(UserScore>CoScore)
            {
                winner.setForeground(Color.GREEN);
                winner.setText("You Won The Game!");
            }
            else if(UserScore<CoScore)
            {
                winner.setForeground(Color.RED);
                winner.setText("You Lost The Game!");
            }
            else if(UserScore == CoScore)
            {
                winner.setForeground(Color.YELLOW);
                winner.setText("It's a Tie! No winners");
            }
        }
    }
    private void updateResult(String result) {
        SwingUtilities.invokeLater(() -> WL.setText(result));
    }

    private void updateUserScore() {
        UserScore++;
        SwingUtilities.invokeLater(() -> user.setText(String.valueOf(UserScore)));
    }
    private void updateCompScore() {
        CoScore++;
        SwingUtilities.invokeLater(() -> comp.setText(String.valueOf(CoScore)));
    }
}