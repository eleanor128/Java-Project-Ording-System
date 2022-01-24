import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Welcome_Window extends JFrame implements ActionListener{

    JFrame welcome;
    private JButton button,enter;

    public Welcome_Window(){

        welcome = new JFrame();
        welcome.setTitle("素食點餐機");
        welcome.setSize(700,650);
        welcome.setVisible(true);//顯示視窗
        welcome.setResizable(false);//不能藉著滑鼠改變視窗大小
        welcome.setLayout(null);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon mclogo = new ImageIcon("McLogo.jpg");//因為我把照片放在跟程式碼同一個資料夾中
        welcome.setIconImage(mclogo.getImage());//改變視窗的圖案

        button = new JButton();
        button.setBounds(0, 0, 700, 700);
        button.setText("歡迎光臨\n點擊以開始點餐");
        ImageIcon background = new ImageIcon("background.jpg");
        button.setIcon(background);
        
        enter = new JButton();
        enter.setBounds(175, 550, 350, 50);
        enter.setText("開始點餐");
        enter.setBackground(Color.ORANGE);
        enter.addActionListener(this);
        button.add(enter);
        welcome.add(button);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enter){
            welcome.dispose();
            new Menu_Window();
        }
    }
}
