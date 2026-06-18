package betr.intern.model;

public class CartItem {

    private final Item item;
    private int quantity;

    public CartItem(Item item, int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("Nu poti insera un numar negativ de item-uri!");
        }
        if(item==null){
            throw new IllegalArgumentException("Nu poti adauga un item care nu exista!");
        }
        this.item=item;
        this.quantity=quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity(){
        return quantity;
    }

    public void incrementQuantity(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("Nu putem insera o cantitate negativa!");
        }

        this.quantity+=quantity;
    }

    public double getSubtotal(){
        return item.getPrice()*this.quantity;
    }



}
