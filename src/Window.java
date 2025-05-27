import javax.swing.*;
import java.util.Stack;

public class Window {
    public static void main(String[] args) {
        FirstWindow firstWindow = new FirstWindow();

        firstWindow.setVisible(true);
    }
}

class FirstWindow extends JFrame{
    private JPanel panel;

    public FirstWindow(){
        setSize(359, 719);
        setTitle("피라미드 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setUndecorated(true);

        addPanel();
    }

    public void addPanel(){
        panel = new PanelFistWindow();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class SecondWindow extends JFrame {
    private JPanel panel;

    public SecondWindow(){
        setSize(359, 719);
        setTitle("피라미드 게임2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        //setUndecorated(true);

        addPanel();
    }

    public void addPanel(){
        panel = new PanelSecondWindow();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class ThirdWindow extends JFrame{
    private JPanel panel;

    public ThirdWindow(){
        setSize(359, 719);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("Vote");
        //setUndecorated(true);

        addPanel();
    }

    public void addPanel(){
        panel = new PanelThirdWindow();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class FourthWindow extends JFrame{
    private JPanel panel;

    public FourthWindow(){
        setSize(359, 719);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("Results");

        addPanel();
    }

    public void addPanel(){
        panel = new PanelFourthWindow();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class ConfirmClose extends JFrame{
    private JPanel panel;

    public ConfirmClose(){
        setBounds(50, 300, 250, 150);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addPanel();
    }

    public void addPanel(){
        panel = new panelConfirmClose();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class InsertUserWindow extends JFrame{
    private JPanel panel;

    public InsertUserWindow(){
        setBounds(50,300, 250, 150);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addPanel();
    }

    public void addPanel(){
        panel = new PanelInsertUser();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}

class PasswordErrorWindow extends JFrame{
    private JPanel panel;

    public PasswordErrorWindow(){
        setBounds(50, 300, 250, 150);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addPanel();
    }

    public void addPanel(){
        panel = new PanelPasswordError();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
}