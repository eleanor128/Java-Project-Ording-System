import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public  class Set_Window extends JFrame implements ActionListener{
    
    private Set allbuttons[] = new Set[6];//總共幾列
    private JButton total_button, discount_button, checkout_button, car_button, enter_button;
    private JTextField textfield;
    private Set passarray[] = new Set[6];
    private int sets_order=0;
    
    public Set_Window(){

        //產生出視窗
        this.setTitle("套餐");
        this.setSize(936, 395);//設定視窗大小   
        this.setVisible(true);//顯示視窗
        this.setResizable(false);//不能藉著滑鼠改變視窗大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//按右上紅叉叉才會確實關掉視窗
        this.setLayout(null);//加了這行最後一個鈕就不會亂跳
        ImageIcon mclogo = new ImageIcon("McLogo.jpg");//因為我把照片放在跟程式碼同一個資料夾中
        this.setIconImage(mclogo.getImage());//改變視窗的圖案

        //產生Set物件，傳回set class以產生按鈕
        allbuttons[0] = new Set();
        allbuttons[1] = new Set(1,"A","普通套餐","無","薯條(中)","雪碧(小)",60,0);
        allbuttons[2] = new Set(2,"B","薯餅套餐","無","薯條(小) 薯餅","可樂(小)",70,0);
        allbuttons[3] = new Set(3,"C","吃很飽套餐","無","薯條(大)","雪碧(小)",70,0);
        allbuttons[4] = new Set(4,"D","學生套餐","麥香雞","薯條(小)","可樂(小)",90,0);//可用來做加分 ex輸入學生證號
        allbuttons[5] = new Set(5,"E","健康套餐","雞胸沙拉","水果盒","柳橙汁",120,0);//記得去增加Menu的按鈕

        //把所有的按鈕加進視窗
        for(int i=0;i<6;i++){//直的幾個
            for(int j=0;j<9;j++){//橫的幾個
                this.add(allbuttons[i].buttons[j]);
                allbuttons[i].buttons[j].addActionListener(this);//按按鈕才有動作
                if(i>0){allbuttons[i].buttons[7].setEnabled(false);}
            }
        }

        //產生目前金額按鈕
        total_button = new JButton();  
        total_button.setText("套餐小計: "+sets_order);
        total_button.setBounds(0, 306, 234, 50);
        total_button.setFocusable(false);
        total_button.setBackground(Color.ORANGE);
        total_button.addActionListener(this);
        this.add(total_button);

        //產生儲存至購物車案鈕
        car_button = new JButton();
        car_button.setText("儲存至購物車");
        car_button.setBounds(234, 306, 234, 50);
        car_button.setFocusable(false);
        car_button.setBackground(Color.getHSBColor(46, 36, 77));
        car_button.addActionListener(this);
        this.add(car_button);

        //產生輸入優惠碼按鈕
        discount_button = new JButton();
        discount_button.setText("輸入優惠碼(12345)");
        discount_button.setBounds(468, 306, 258, 29);
        discount_button.setFocusable(false);
        discount_button.setBackground(Color.ORANGE);
        discount_button.addActionListener(this);
        this.add(discount_button);

        //輸入優惠碼的地方
        textfield = new JTextField();
        textfield.setBounds(468, 331, 192, 25);
        this.add(textfield);
        
        //送出按鈕
        enter_button = new JButton();
        enter_button.setText("確認");
        enter_button.setBounds(660, 331, 66, 25);
        enter_button.setFocusable(false);
        enter_button.setBackground(Color.RED);
        enter_button.addActionListener(this);
        this.add(enter_button);

        //產生結帳按鈕
        checkout_button = new JButton();
        checkout_button.setText("結帳");
        checkout_button.setBounds(726, 306, 210, 50);
        checkout_button.setFocusable(false);
        checkout_button.setBackground(Color.RED);
        checkout_button.addActionListener(this);
        this.add(checkout_button);

    }//end constructor

    public void actionPerformed(ActionEvent e){

        //點餐的部分
        for(int i=1;i<allbuttons.length;i++){
            
            if(e.getSource()==allbuttons[i].buttons[7]){//點到-

                if(allbuttons[i].getQuantity()==1){allbuttons[i].buttons[7].setEnabled(false);}
                if(allbuttons[i].getQuantity()>0){
                    allbuttons[i].setQuantity(-1);
                    allbuttons[i].buttons[6].setText(Integer.toString(allbuttons[i].getQuantity()));
                    sets_order -= allbuttons[i].getPrice();
                    total_button.setText("套餐: "+sets_order);
                } 
            }

            if(e.getSource()==allbuttons[i].buttons[8]){//點到+
                
                allbuttons[i].buttons[7].setEnabled(true);
                allbuttons[i].setQuantity(1);
                allbuttons[i].buttons[6].setText(Integer.toString(allbuttons[i].getQuantity()));
                sets_order += allbuttons[i].getPrice();
                total_button.setText("套餐: "+sets_order);
            }
        }

        //儲存至購物車的部分
        if(e.getSource()==car_button){

            for(int i=1;i<allbuttons.length;i++){
                if(allbuttons[i].getQuantity()>0){
                    passarray[i] = allbuttons[i];//把點的商品傳過去
                }
            }
            Order_Window.passorder(passarray);
            CheckPage.passorder(passarray);//也傳一份給最後明細頁面
            new Order_Window();
        }

        //優惠碼的部分
        if(e.getSource()==enter_button){

            if(Integer.parseInt(textfield.getText())==12345){
                System.out.println("Yes");
                JOptionPane.showMessageDialog(null,"已獲得8折優惠","訊息",1);
                CheckPage.setDiscount(1);
            }
            if(Integer.parseInt(textfield.getText())!=12345){
                System.out.println(textfield.getText());
                JOptionPane.showMessageDialog(null,"優惠碼無效","訊息",1);
                CheckPage.setDiscount(0);
            }
        }
        
        //結帳的部分
        if(e.getSource()==checkout_button){new CheckPage();}
    }
}
