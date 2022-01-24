import javax.swing.JOptionPane;
public class CheckPage {//最後明細的部分
    
    private static String message="";
    private int total=0;
    private static boolean discount;
    static Order Menuorderbuttons[] = new Order[15];//長度取決於有幾種商品可以點
    static Order Setorderbuttons[] = new Order[6];//負責處理套餐

    public CheckPage(){

        setMessage();
        JOptionPane.showMessageDialog(null, getMessage(), "明細", 1);
        System.exit(0);
    }

    public void setMessage(){
        
        for(int k=1;k<Menuorderbuttons.length;k++){
            if(Menuorderbuttons[k]!=null){
                message += String.format("%d份 %-7s\n",Menuorderbuttons[k].getQuantity(),Menuorderbuttons[k].getFood_name());
                total += Menuorderbuttons[k].getSubtotal();
            }
        }
        
        for(int k=1;k<Setorderbuttons.length;k++){
            if(Setorderbuttons[k]!=null){
                message += String.format("%d份 %-7s\n",Setorderbuttons[k].getQuantity(),Setorderbuttons[k].getFood_name());
                total += Setorderbuttons[k].getSubtotal();
            }
        }
        if(getDiscount()==true){total *= 0.8;}
        message += "總共"+total+"元";
    }
    
    public String getMessage(){return message;}

    public static void passorder(Menu orders[]){

        for(int i=0;i<Menuorderbuttons.length;i++){
            Menuorderbuttons[i] = null;
        }

        for(int i=1;i<orders.length;i++){
            if(orders[i]!=null&&orders[i].getQuantity()>0){
                Menuorderbuttons[i] = new Order(orders[i].getID(),orders[i].getFood_name(),orders[i].getQuantity(),orders[i].getPrice()*orders[i].getQuantity(),1);
            }
        }
    }

    public static void passorder(Set orders[]){

        for(int i=0;i<Setorderbuttons.length;i++){
            Setorderbuttons[i] = null;
        }

        for(int i=1;i<orders.length;i++){
            if(orders[i]!=null&&orders[i].getQuantity()>0){
                Setorderbuttons[i] = new Order(orders[i].getID(),orders[i].getFood_name(),orders[i].getQuantity(),orders[i].getPrice()*orders[i].getQuantity(),1);
            }
        }
    }

    public static void setDiscount(int a){
        if(a==0){discount = false;}
        if(a==1){discount = true;}
    }
    public boolean getDiscount(){return discount;}

}
