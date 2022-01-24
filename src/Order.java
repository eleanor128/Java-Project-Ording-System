import javax.swing.JButton;
import java.awt.Color;
public class Order extends Father{//建立結帳的按鈕
    
    protected int subtotal, total;
    protected JButton buttons[] = new JButton[3];//橫排長度

    public Order(){
        super();
        createInfobutton();
    }

    public Order(int ID, String food_name, int quantity, int subtotal,int price){
        super(ID, food_name, price, quantity);
        setFood_name(food_name);
        setQuantity(quantity);
        setSubtotal(subtotal);
        createButtons();
    }

    public void setQuantity(int quantity) {this.quantity = quantity;}
    public int getQuantity(){return quantity;}

    public void setSubtotal(int subtotal) {this.subtotal = subtotal;}
    public int getSubtotal() {return subtotal;}

    public void createInfobutton(){
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            buttons[i].setBounds(100*i,0,100,50);//x, y, width, height
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.ORANGE);
        }
        buttons[0].setText("商品");
        buttons[1].setText("數量");
        buttons[2].setText("小計");
    }

    public void createButtons(){

        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            //buttons[i].setBounds(100*i,50*(getID()+1),100,50);//x, y, width, height
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.WHITE);
        }
        buttons[0].setText(getFood_name());//商品名
        buttons[1].setText(Integer.toString(getQuantity()));//數量
        buttons[2].setText(Integer.toString(getSubtotal()));//小計
    }

}
