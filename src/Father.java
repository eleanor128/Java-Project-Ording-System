import javax.swing.JFrame;
public abstract class Father extends JFrame{

    protected int ID, price, quantity;
    protected String food_name;

    public Father(){}
    public Father(int ID, String food_name, int price, int quantity){

        setID(ID);
        setFood_name(food_name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setID(int ID){this.ID = ID;}
    public int getID(){return ID;}

    public void setFood_name(String food_name){this.food_name = food_name;}
    public String getFood_name(){return food_name;}

    public void setPrice(int price){this.price = price;}
    public int getPrice(){return price;}

    public void setQuantity(int quantity) {this.quantity += quantity;}
    public int getQuantity(){return quantity;}

    public abstract void createInfobutton();
    public abstract void createButtons();

}