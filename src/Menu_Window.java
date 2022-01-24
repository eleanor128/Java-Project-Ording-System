import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
public class Menu_Window extends JFrame implements ActionListener {

    private Menu allbuttons[] = new Menu[14];
    private Menu passarray[] = new Menu[15];
    private int menus_order=0;//總金額
    private JButton total_button,gotoSet_button,car_button;

    public Menu_Window(){

        //產生出視窗
        this.setTitle("菜單");
        this.setSize(646,648);//設定視窗大小
        this.setVisible(true);//顯示視窗
        this.setResizable(false);//不能藉著滑鼠改變視窗大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//按右上紅叉叉才會確實關掉視窗
        this.setLayout(null);//加了這行最後一個鈕就不會亂跳
        ImageIcon mclogo = new ImageIcon("McLogo.jpg");//因為我把照片放在跟程式碼同一個資料夾中
        this.setIconImage(mclogo.getImage());//改變視窗的圖案
        
        //產生Menu物件，傳回menu class以產生按鈕
        allbuttons[0] = new Menu();
        allbuttons[1] = new Menu(1,"薯條(小)",33,"副餐",false,0);
        allbuttons[2] = new Menu(2,"麥香雞",44,"主餐",false,0);
        allbuttons[3] = new Menu(3,"可樂(小)",28,"飲料",false,0);
        allbuttons[4] = new Menu(4,"雪碧(小)",28,"飲料",false,0);
        allbuttons[5] = new Menu(5,"薯條(中)",44,"副餐",false,0);
        allbuttons[6] = new Menu(6,"薯餅",30,"副餐",false,0);
        allbuttons[7] = new Menu(7,"滿福堡",48,"主餐",false,0);
        allbuttons[8] = new Menu(8,"薯條(大)",55,"副餐",true,0);
        allbuttons[9] = new Menu(9,"大麥克",72,"主餐",false,0);
        allbuttons[10] = new Menu(10,"玉米濃湯",40,"飲料",false,0);
        allbuttons[11] = new Menu(11,"雞胸沙拉",80,"主餐",false,0);
        allbuttons[12] = new Menu(12,"水果盒",50,"副餐",false,0);
        allbuttons[13] = new Menu(13,"柳橙汁",28,"飲料",false,0);

        //匯入照片
        ImageIcon smallfries = new ImageIcon("smallfries.jpg");
        ImageIcon mcchicken = new ImageIcon("mcchicken.png");
        ImageIcon coke = new ImageIcon("coke.jpg");
        ImageIcon sprite = new ImageIcon("sprite.jpg");
        ImageIcon midfries = new ImageIcon("midfries.jpg");
        ImageIcon hashbrown = new ImageIcon("hashbrown.jpg");
        ImageIcon mcmuffin = new ImageIcon("mcmuffin.png");
        ImageIcon bigfries = new ImageIcon("bigfries.jpg");
        ImageIcon bigmac = new ImageIcon("bigmac.jpg");
        ImageIcon cornsoup = new ImageIcon("cornsoup.png");
        ImageIcon salad = new ImageIcon("salad.jpg");
        ImageIcon fruits = new ImageIcon("fruits.png");
        ImageIcon lemonade = new ImageIcon("lemonade.png");

        //放照片
        allbuttons[1].buttons[1].setIcon(smallfries);
        allbuttons[2].buttons[1].setIcon(mcchicken);
        allbuttons[3].buttons[1].setIcon(coke);
        allbuttons[4].buttons[1].setIcon(sprite);
        allbuttons[5].buttons[1].setIcon(midfries);
        allbuttons[6].buttons[1].setIcon(hashbrown);
        allbuttons[7].buttons[1].setIcon(mcmuffin);
        allbuttons[8].buttons[1].setIcon(bigfries);
        allbuttons[9].buttons[1].setIcon(bigmac);
        allbuttons[10].buttons[1].setIcon(cornsoup);
        allbuttons[11].buttons[1].setIcon(salad);
        allbuttons[12].buttons[1].setIcon(fruits);
        allbuttons[13].buttons[1].setIcon(lemonade);

        //把所有的按鈕加進視窗
        for(int i=0;i<allbuttons.length;i++){
            for(int j=0;j<7;j++){
                this.add(allbuttons[i].buttons[j]);
                allbuttons[i].buttons[j].setVisible(true);
                allbuttons[i].buttons[j].addActionListener(this);//按按鈕就有動作
                
                if(i>0){allbuttons[i].buttons[5].setEnabled(false);}
            }
        }

        //產生最下面的三個按鈕
        total_button = new JButton();
        total_button.setText("目前金額: "+menus_order);
        total_button.setBounds(0, 564, 180, 45);
        total_button.setFocusable(false);
        total_button.setBackground(Color.ORANGE);
        total_button.addActionListener(this);
        this.add(total_button);

        gotoSet_button = new JButton();
        gotoSet_button.setText("前往套餐/結帳");
        gotoSet_button.setBounds(180, 564, 180, 45);
        gotoSet_button.setFocusable(false);
        gotoSet_button.setBackground(Color.ORANGE);
        gotoSet_button.addActionListener(this);
        this.add(gotoSet_button);
        
        car_button = new JButton();
        car_button.setText("儲存至購物車");
        car_button.setBounds(360, 564, 270, 45);
        car_button.setFocusable(false);
        car_button.setBackground(Color.getHSBColor(46, 36, 77));
        car_button.addActionListener(this);
        this.add(car_button);
    
    }//ends constructor

    //override
    public void actionPerformed(ActionEvent e){

        //  點餐的部分
        for(int i=1;i<allbuttons.length;i++){
            
            if(e.getSource()==allbuttons[i].buttons[5]){//點到-

                if(allbuttons[i].getQuantity()==1){allbuttons[i].buttons[5].setEnabled(false);}
                if(allbuttons[i].getQuantity()>0){
                    allbuttons[i].setQuantity(-1);
                    allbuttons[i].buttons[4].setText(Integer.toString(allbuttons[i].getQuantity()));
                    menus_order -= allbuttons[i].getPrice();
                    total_button.setText("目前金額: "+menus_order);
                } 
            }

            if(e.getSource()==allbuttons[i].buttons[6]){//點到+
                
                allbuttons[i].buttons[5].setEnabled(true);
                allbuttons[i].setQuantity(1);
                allbuttons[i].buttons[4].setText(Integer.toString(allbuttons[i].getQuantity()));
                menus_order += allbuttons[i].getPrice();
                total_button.setText("單點小計: "+menus_order);
            }
        }

        //前往套餐的部分
        if(e.getSource()==gotoSet_button){new Set_Window();}
            
        //結帳的部分
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
    }
}


