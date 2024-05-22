import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class PanelSecondWindow extends JPanel {
    private Image image;
    private ValidatePassoword validator = new ValidatePassoword();
    JTextField R,A,N,K;

    public PanelSecondWindow(){
        image = Toolkit.getDefaultToolkit().getImage("img/Paneles/SecondWindow.jpg ");
        password();
        goBack();

        JLabel message = new JLabel();
        message.setText("앱을 설치하려면 보안코드를 입력하셔요");
        message.setBounds(30, 250, 300, 20);
        message.setForeground(Color.WHITE);
        message.setOpaque(false);
        message.setFont(new Font("", Font.CENTER_BASELINE, 15));
        add(message);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(), getHeight(),this);
    }

    public void password(){
        R = new JTextField();
        A = new JTextField();
        N = new JTextField();
        K = new JTextField();
        JButton sign = new JButton();
        MatteBorder textBorder = new MatteBorder(0,0,2,0,Color.WHITE);

        R.setBounds(70, 300, 40, 45);
        R.setFont(new Font("arial", Font.CENTER_BASELINE, 40));
        R.setOpaque(false);
        R.setForeground(Color.WHITE);
        R.setBorder(textBorder);
        add(R);
        R.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                R.transferFocus();
            }
        });
        R.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int maxLength = 1;
                if(R.getText().length()>=maxLength) e.consume();
            }
        });

        A.setBounds(120, 300, 40, 45);
        A.setFont(new Font("arial",Font.CENTER_BASELINE, 40));
        A.setOpaque(false);
        A.setForeground(Color.WHITE);
        A.setBorder(textBorder);
        add(A);
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A.transferFocus();
            }
        });
        A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int maxLength = 1;
                if(A.getText().length()>=maxLength) e.consume();
            }
        });

        N.setBounds(170, 300, 40, 45);
        N.setFont(new Font("arial",Font.CENTER_BASELINE, 40));
        N.setOpaque(false);
        N.setForeground(Color.WHITE);
        N.setBorder(textBorder);
        add(N);
        N.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                N.transferFocus();
            }
        });
        N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int maxLength = 1;
                if(N.getText().length()>=maxLength) e.consume();
            }
        });

        K.setBounds(220, 300, 40, 45);
        K.setFont(new Font("arial",Font.CENTER_BASELINE, 40));
        K.setOpaque(false);
        K.setForeground(Color.WHITE);
        K.setBorder(textBorder);
        add(K);
        K.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int maxLength = 1;
                if(K.getText().length()>=maxLength) e.consume();
            }
        });

        sign.setBounds(120, 400, 100, 40);
        sign.setText("확인");
        sign.setFont(new Font("", Font.CENTER_BASELINE, 20));
        sign.setBorder(null);
        sign.setForeground(Color.WHITE);
        sign.setBackground(Color.darkGray);

        add(sign);

        sign.addActionListener(e ->{
            if(validator.validatePassWord(R,A,N,K)){
                sign.addActionListener(f -> {
                   SecondWindow secondWindow = (SecondWindow)getTopLevelAncestor();
                   secondWindow.dispose();

                   ThirdWindow thirdWindow = new ThirdWindow();
                });
            }else {
                PasswordErrorWindow passwordErrorWindow = new PasswordErrorWindow();
                passwordErrorWindow.setVisible(true);
            }
        });
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
                FirstWindow firstWindow = new FirstWindow();
                firstWindow.setVisible(true);
                SecondWindow secondWindow = (SecondWindow)getTopLevelAncestor();
                secondWindow.dispose();
            }
        });

        add(back);
    }
}

class ValidatePassoword{
    public ValidatePassoword(){}
    public boolean validatePassWord(JTextField R,JTextField A,JTextField N,JTextField K){
        String password = R.getText()+A.getText()+N.getText()+K.getText();

        return password.equals("RANK");
    }
}

class PanelPasswordError extends JPanel{
    MatteBorder matteBorder = new MatteBorder(2,2,2,2, Color.WHITE);

    public PanelPasswordError(){
        setBackground(Color.BLACK);
        setBorder(matteBorder);
        addComponent();
    }

    public void addComponent(){
        JButton acept = new JButton("받아들이다");
        acept.setBounds(70,90, 100,35);
        acept.setBackground(Color.darkGray);
        acept.setForeground(Color.WHITE);
        acept.setFont(new Font("",Font.CENTER_BASELINE, 11));
        acept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordErrorWindow passwordErrorWindow = (PasswordErrorWindow) getTopLevelAncestor();
                passwordErrorWindow.dispose();
            }
        });

        JLabel passwordErrorText = new JLabel("비밀번호가");
        JLabel passwordErrorText2 = new JLabel("잘못되었습니다.");

        passwordErrorText.setBackground(Color.BLACK);
        passwordErrorText.setForeground(Color.WHITE);
        passwordErrorText.setBounds(65,25,200, 30);
        passwordErrorText.setFont(new Font("", Font.CENTER_BASELINE, 20));

        passwordErrorText2.setBackground(Color.black);
        passwordErrorText2.setForeground(Color.WHITE);
        passwordErrorText2.setBounds(48, 50, 200, 30);
        passwordErrorText2.setFont(new Font("", Font.CENTER_BASELINE, 20));

        add(acept);
        add(passwordErrorText);
        add(passwordErrorText2);
    }
}