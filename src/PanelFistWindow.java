import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFistWindow extends JPanel {
    private Image image;
    JTextField User = new JTextField();

    public PanelFistWindow() {
        image = Toolkit.getDefaultToolkit().getImage("img/Paneles/SecondWindow.jpg ");
        addCompoents();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(), getHeight(),this);
    }

    public void addCompoents(){
        JButton start = new JButton("시작");
        JLabel nameUser = new JLabel("이름을 입릭하세요");
        JLabel userIcon = new JLabel();
        MatteBorder matteBorder = new MatteBorder(0,0,2,0, Color.white);
        MatteBorder iconBorder = new MatteBorder(2,2,2,2, Color.white);
        JButton close = new JButton();
        String[] languajes = {"Korean" , "English", "Spanish"};
        JComboBox selectLanguaje = new JComboBox(languajes);


        nameUser.setBounds(50, 270, 300, 35);
        nameUser.setForeground(Color.WHITE);
        nameUser.setOpaque(false);
        nameUser.setFont(new Font("", Font.CENTER_BASELINE, 25));

        ImageIcon icon = new ImageIcon("img/User.jpg");
        Image img = icon.getImage().getScaledInstance(63, 60, Image.SCALE_SMOOTH);
        userIcon.setIcon(new ImageIcon(img));
        userIcon.setBounds(120,320, 63, 60);
        userIcon.setBorder(iconBorder);

        User.setOpaque(false);
        User.setBorder(matteBorder);
        User.setBounds(80, 400, 150, 30);
        User.setForeground(Color.WHITE);
        User.setFont(new Font("", Font.CENTER_BASELINE, 25));

        start.setBounds(80, 450, 150, 40);
        start.setForeground(Color.WHITE);
        start.setFont(new Font("", Font.CENTER_BASELINE, 25));
        start.setBackground(Color.darkGray);
        start.addActionListener(e->{
            if(!User.getText().isEmpty()){
                start.addActionListener(f->{
                    FirstWindow firstWindow = (FirstWindow) getTopLevelAncestor();
                    firstWindow.dispose();

                    SecondWindow secondWindow = new SecondWindow();
                });
            }else {
                InsertUserWindow insertUserWindow = new InsertUserWindow();
                insertUserWindow.setVisible(true);
            }
        });

        ImageIcon closeIcon = new ImageIcon("img/Close.jpg");
        Image Close = closeIcon.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        close.setIcon(new ImageIcon(Close));
        close.setBounds(10,10, 27, 27);
        close.setBorder(null);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmClose confirmClose = new ConfirmClose();
                confirmClose.setVisible(true);
            }
        });

        selectLanguaje.setBounds(250,20, 100, 40);
        selectLanguaje.setBackground(Color.BLACK);
        selectLanguaje.setEditable(false);


        add(start);
        add(nameUser);
        add(User);
        add(userIcon);
        add(close);
        add(selectLanguaje);
    }
}

class panelConfirmClose extends JPanel{
    MatteBorder matteBorder = new MatteBorder(2,2,2,2, Color.white);

    public panelConfirmClose(){
        setBorder(matteBorder);
        setBackground(Color.BLACK);
        addComponent();
    }

    public void addComponent(){
        JButton yes = new JButton("닫다");
        yes.setBackground(Color.darkGray);
        yes.setBounds(30, 100, 85, 25);
        yes.setForeground(Color.WHITE);
        yes.setFont(new Font("", Font.CENTER_BASELINE, 15));
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton no = new JButton("뒤따르다");
        no.setBackground(Color.darkGray);
        no.setBounds(130, 100, 85, 25);
        no.setForeground(Color.WHITE);
        no.setFont(new Font("", Font.CENTER_BASELINE, 12));
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmClose confirmClose = (ConfirmClose) getTopLevelAncestor();
                confirmClose.dispose();
            }
        });

        JLabel confirmText = new JLabel("닫으시겠습니까?");
        confirmText.setBackground(Color.BLACK);
        confirmText.setForeground(Color.WHITE);
        confirmText.setBounds(47, 35, 200, 30);
        confirmText.setFont(new Font("",Font.CENTER_BASELINE, 20));

        add(yes);
        add(no);
        add(confirmText);
    }
}

class PanelInsertUser extends JPanel{
    MatteBorder matteBorder = new MatteBorder(2,2,2,2, Color.WHITE);

    public PanelInsertUser(){
        setBackground(Color.black);
        setBorder(matteBorder);
        addComponent();
    }

    public void addComponent(){
        JButton acept = new JButton("받아들이다");
        acept.setBounds(70,90, 100, 35);
        acept.setBackground(Color.darkGray);
        acept.setForeground(Color.WHITE);
        acept.setFont(new Font("", Font.CENTER_BASELINE, 11));
        acept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertUserWindow insertUserWindow = (InsertUserWindow) getTopLevelAncestor();
                insertUserWindow.dispose();
            }
        });

        JLabel insertUserText = new JLabel("사용자 이름을");
        JLabel insertUserText2 = new JLabel("입력합니다.");

        insertUserText.setBounds(48, 25,200,30);
        insertUserText.setBackground(Color.BLACK);
        insertUserText.setForeground(Color.WHITE);
        insertUserText.setFont(new Font("", Font.CENTER_BASELINE, 20));

        insertUserText2.setBounds(65, 50, 200, 30);
        insertUserText2.setBackground(Color.BLACK);
        insertUserText2.setForeground(Color.WHITE);
        insertUserText2.setFont(new Font("", Font.CENTER_BASELINE, 20));

        add(acept);
        add(insertUserText);
        add(insertUserText2);
    }
}