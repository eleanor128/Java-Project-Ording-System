import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
public class Order_Window extends JFrame implements ActionListener{
    
    private JFrame frame = new JFrame();
    private JButton close_button;
    private static Order Menuorderbuttons[] = new Order[15];//長度取決於有幾種商品可以點
    private static Order Setorderbuttons[] = new Order[6];//負責處理套餐

    //建構
    public Order_Window(){

        frame.setTitle("購物車");
        frame.setSize(317,600);//設定視窗大小
        frame.setVisible(true);//顯示視窗
        frame.setResizable(false);//不能藉著滑鼠改變視窗大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//按右上紅叉叉才會確實關掉視窗
        frame.setLayout(null);//加了這行最後一個鈕就不會亂跳
        ImageIcon mclogo = new ImageIcon("McLogo.jpg");//因為我把照片放在跟程式碼同一個資料夾中
        frame.setIconImage(mclogo.getImage());//改變視窗的圖案

        //最上方的商品、數量、小計
        Menuorderbuttons[0] = new Order();
        frame.add(Menuorderbuttons[0].buttons[0]);
        frame.add(Menuorderbuttons[0].buttons[1]);
        frame.add(Menuorderbuttons[0].buttons[2]);

        //最下面的按鈕
        close_button = new JButton();
        close_button.setText("關閉視窗");
        close_button.setBounds(0,510,300,50);//x, y, width, height
        close_button.setFocusable(false);//取消字的邊框
        close_button.addActionListener(this);
        close_button.setBackground(Color.ORANGE);
        frame.add(close_button);
        
        //印出單點的明細
        int k=1;
        for(int i=1;i<Menuorderbuttons.length;i++){
            for(int j=0;j<3;j++){//印出單點
                if(Menuorderbuttons[i]==null&&i<k){k--;}
                if(Menuorderbuttons[i]!=null){
                    
                    Menuorderbuttons[i].buttons[j].setBounds(100*j,20+31*k,100,30);//x, y, width, height
                    frame.add(Menuorderbuttons[i].buttons[j]);
                    if(j==2){k++;}//向上對齊
                }   
            }

            if(i==Menuorderbuttons.length-1){//印出套餐
                for(int s=1;s<Setorderbuttons.length;s++){
                    for(int j=0;j<3;j++){
                        if(Setorderbuttons[s]==null&&i<k){k--;}
                        if(Setorderbuttons[s]!=null){
                    
                            Setorderbuttons[s].buttons[j].setBounds(100*j,20+31*k,100,30);//x, y, width, height
                            frame.add(Setorderbuttons[s].buttons[j]);
                            if(j==2){k++;}//向上對齊
                        }   
                    }
                }
            }
        }
    }//end constructor
    
    public static void passorder(Menu orders[]){//每傳一次就建一橫排

        for(int i=0;i<Menuorderbuttons.length;i++){ Menuorderbuttons[i] = null;}

        for(int i=1;i<orders.length;i++){
            if(orders[i]!=null&&orders[i].getQuantity()>0){
                Menuorderbuttons[i] = new Order(orders[i].getID(),orders[i].getFood_name(),orders[i].getQuantity(),orders[i].getPrice()*orders[i].getQuantity(),1);
            }
        }
    }

    public static void passorder(Set orders[]){//每傳一次就建一橫排

        for(int i=0;i<Setorderbuttons.length;i++){Setorderbuttons[i] = null;}

        for(int i=1;i<orders.length;i++){
            if(orders[i]!=null&&orders[i].getQuantity()>0){
                Setorderbuttons[i] = new Order(orders[i].getID(),orders[i].getFood_name(),orders[i].getQuantity(),orders[i].getPrice()*orders[i].getQuantity(),1);
            }
        }
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==close_button){frame.dispose();}//關閉視窗
    }
}
