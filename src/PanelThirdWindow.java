import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;

public class PanelThirdWindow extends JPanel{
    private Image image;
    JTextField A, B, C, D, F;
    private VoteValidator validator = new VoteValidator();

    public PanelThirdWindow(){
        image = Toolkit.getDefaultToolkit().getImage("img/Paneles/ThirdWindow.jpg");

        Voting();
        addBotton();
        addLabels();
        goBack();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0, getWidth(), getHeight(), this);
    }

    public void Voting(){
        A = new JTextField();
        B = new JTextField();
        C = new JTextField();
        D = new JTextField();
        F = new JTextField();
        JButton toVotar = new JButton();
        MatteBorder textBorder = new MatteBorder(0, 0, 2, 0, Color.WHITE);

        A.setForeground(Color.WHITE);
        A.setBounds(140, 275, 100, 35);
        A.setOpaque(false);
        A.setBorder(textBorder);
        A.setFont(new Font("", Font.CENTER_BASELINE, 30));
        A.setText("이름");
        A.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(A.getText().equals("이름")) A.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(A.getText().isEmpty()) A.setText("이름");
            }
        });
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A.transferFocus();
            }
        });

        B.setBounds(140, 330, 100, 35);
        B.setForeground(Color.WHITE);
        B.setOpaque(false);
        B.setFont(new Font("", Font.CENTER_BASELINE, 30));
        B.setBorder(textBorder);
        B.setText("이름");
        B.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(B.getText().equals("이름")) B.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(B.getText().isEmpty()) B.setText("이름");
            }
        });
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.transferFocus();
            }
        });

        C.setBounds(140, 380, 100, 35);
        C.setOpaque(false);
        C.setBorder(textBorder);
        C.setForeground(Color.WHITE);
        C.setFont(new Font("",Font.CENTER_BASELINE, 30));
        C.setText("이름");
        C.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(C.getText().equals("이름")) C.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(C.getText().isEmpty()) C.setText("이름");
            }
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                C.transferFocus();
            }
        });

        D.setBounds(140, 430, 100, 35);
        D.setForeground(Color.WHITE);
        D.setOpaque(false);
        D.setBorder(textBorder);
        D.setFont(new Font("", Font.CENTER_BASELINE, 30));
        D.setText("이름");
        D.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(D.getText().equals("이름")) D.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(D.getText().isEmpty()) D.setText("이름");
            }
        });
        D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                D.transferFocus();
            }
        });

        F.setBounds(140, 480, 100, 35);
        F.setForeground(Color.WHITE);
        F.setOpaque(false);
        F.setBorder(textBorder);
        F.setFont(new Font("", Font.CENTER_BASELINE, 30));
        F.setText("이름");
        F.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(F.getText().equals("이름")) F.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(F.getText().isEmpty()) F.setText("이름");
            }
        });
        F.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                F.transferFocus();
            }
        });

        add(A);
        add(B);
        add(C);
        add(D);
        add(F);
    }

    public void addBotton(){
        JButton voteComplete = new JButton("투표 완료");

        voteComplete.setBounds(63, 550, 220, 45);
        voteComplete.setBorder(null);
        voteComplete.setFont(new Font("", Font.CENTER_BASELINE, 20));
        voteComplete.setBackground(Color.DARK_GRAY);
        voteComplete.setForeground(Color.WHITE);

        voteComplete.addActionListener(e->{
            if(validator.voteValidator(A,B,C,D,F)){
                voteComplete.addActionListener(f->{
                    ThirdWindow thirdWindow = (ThirdWindow) getTopLevelAncestor();
                    thirdWindow.dispose();

                    FourthWindow fourthWindow = new FourthWindow();
                });
            }else{
                JOptionPane.showMessageDialog(null,"No se pueden repetir los nombres");
            }
        });

        add(voteComplete);
    }

    public void addLabels(){
        JLabel NoGame;
        JLabel name = new JLabel("이름을 입릭하세요");

        NoGame = new JLabel("제 1 회 피라미드 게임");
        NoGame.setBounds(45,180, 400, 35);
        NoGame.setForeground(Color.WHITE);
        NoGame.setOpaque(false);
        NoGame.setFont(new Font("", Font.CENTER_BASELINE, 25));

        name.setBounds(77, 225, 300, 30);
        name.setForeground(Color.WHITE);
        name.setOpaque(false);
        name.setFont(new Font("", Font.CENTER_BASELINE, 20));

        add(NoGame);
        add(name);
    }

    public void goBack(){
        JButton back = new JButton();

        ImageIcon icon = new ImageIcon("img/Back.jpg");
        Image img = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        back.setIcon(new ImageIcon(img));
        back.setBounds(10,10, 35, 35);
        back.setBorder(null);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondWindow secondWindow = new SecondWindow();
                secondWindow.setVisible(true);
                ThirdWindow thirdWindow = (ThirdWindow) getTopLevelAncestor();
                thirdWindow.dispose();
            }
        });

        add(back);
    }
}

class VoteValidator{

    public VoteValidator(){}

    public boolean voteValidator(JTextField A, JTextField B, JTextField C, JTextField D, JTextField F){
        if((A.getText().equals(B.getText())) || (A.getText().equals(C.getText())) || (A.getText().equals(D.getText()))
         ||(A.getText().equals(F.getText())) || (B.getText().equals(C.getText())) || (B.getText().equals(D.getText()))
         ||(B.getText().equals(F.getText())) || (C.getText().equals(D.getText())) || (C.getText().equals(F.getText()))
         || (D.getText().equals(F.getText()))){return false;}

        if (((A.getText().equals("이름")) || (B.getText().equals("이름")) || (C.getText().equals("이름")) ||
                (D.getText().equals("이름")) || (F.getText().equals("이름")))){return false;}

        return true;
    }
}