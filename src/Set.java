import javax.swing.JButton;
import java.awt.Color;
public class Set extends Father{//建立套餐的按鈕

    protected String ID_string, mainmeal, sidemeal, drink;
    protected int  total;//count用來排出先後順序
    protected JButton buttons[] = new JButton[9];//橫排長度

    public Set(){
        super();
        createInfobutton();
    }

    public Set(int ID, String ID_string, String food_name, String mainmeal, String sidemeal, String drink, int price, int quantity){

        super(ID, food_name, price, quantity);
        setID_string(ID_string);
        setMainmeal(mainmeal);
        setSidemeal(sidemeal);
        setDrink(drink);
        createButtons();
    }

    public void setID_string(String ID_string){this.ID_string = ID_string;}
    public String getID_string(){return ID_string;}

    public void setMainmeal(String mainmeal){this.mainmeal = mainmeal;}
    public String getMainmeal(){return mainmeal;}

    public void setSidemeal(String sidemeal){this.sidemeal = sidemeal;}
    public String getSidemeal(){return sidemeal;}

    public void setDrink(String drink){this.drink = drink;}
    public String getDrink(){return drink;}

    public void createInfobutton(){
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            if(i<3){buttons[i].setBounds(100*i,51*getID(),100,50);}
            if(i==3){buttons[i].setBounds(100*i,51*getID(),120,50);}
            if(i>3){buttons[i].setBounds(20+100*i,51*getID(),100,50);}
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.ORANGE);

        }
        buttons[0].setText("ID");
        buttons[1].setText("名稱");
        buttons[2].setText("主餐");
        buttons[3].setText("副餐");
        buttons[4].setText("飲料");
        buttons[5].setText("價格");
        buttons[6].setText("數量");
        buttons[7].setText("取消");
        buttons[8].setText("點餐");
    }

    public void createButtons(){
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton();
            if(i<3){buttons[i].setBounds(100*i,51*getID(),100,50);}
            if(i==3){buttons[i].setBounds(100*i,51*getID(),120,50);}
            if(i>3){buttons[i].setBounds(20+100*i,51*getID(),100,50);}
            buttons[i].setFocusable(false);//取消字的邊框
            buttons[i].setBackground(Color.WHITE);
        }

        buttons[0].setText(getID_string());//編號和商品名
        buttons[0].setBackground(Color.getHSBColor(46, 36, 70));
        buttons[1].setText(getFood_name());
        buttons[1].setBackground(Color.getHSBColor(46, 36, 70));
        buttons[2].setText(getMainmeal());
        buttons[3].setText(getSidemeal());
        buttons[4].setText(getDrink());
        buttons[5].setText(Integer.toString(getPrice()));//價錢
        buttons[6].setText(Integer.toString(getQuantity()));//數量
        buttons[7].setText("-");
        buttons[8].setText("+");
    }
}







    

