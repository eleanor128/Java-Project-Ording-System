import java.awt.Color;
import javax.swing.JButton;
public class Menu extends Father {
    
    protected String type;
    protected boolean breakfast;
    protected JButton buttons[] = new JButton[7];//用來建立橫排的按鈕

    public Menu(){
        super();
        createInfobutton();
    }//產生最上方的標題列

    public Menu(int ID, String food_name, int price, String type, boolean breakfast,int quantity) {
        
        super(ID, food_name, price, quantity);
        settheType(type);
        setBreakfast(breakfast);
        createButtons();
    }

    public void settheType(String type) {this.type = type;}
    public String gettheType(){return type;}
    
    public void setBreakfast(boolean breakfast) {this.breakfast = breakfast;}
    public boolean getBreakfast() {return breakfast;}

    public int getTotalPrice(){return getPrice()*getQuantity();};

    public void createInfobutton(){
        for(int i=0;i<7;i++){
            buttons[i] = new JButton();
            buttons[i].setBounds(90*i,31*getID(),90,30);//x, y, width, height
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.ORANGE);
        }
        buttons[0].setText("商品");
        buttons[1].setText("照片");
        buttons[2].setText("價錢");
        buttons[3].setText("種類");
        buttons[4].setText("數量");
        buttons[5].setText("取消");
        buttons[6].setText("點餐");
    }

    public void createButtons(){
        for(int i=0;i<7;i++){
            buttons[i] = new JButton();
            buttons[i].setBounds(90*i,41*getID()-10,90,40);//x, y, width, height
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.WHITE);
        }
        buttons[0].setText(getFood_name());//編號和商品名
        buttons[0].setBackground(Color.getHSBColor(46, 36, 70));
        buttons[2].setText(Integer.toString(getPrice()));//價錢
        buttons[3].setText(gettheType());//種類
        buttons[4].setText(Integer.toString(getQuantity()));//數量
        buttons[5].setText("-");
        buttons[6].setText("+");
    }
}
