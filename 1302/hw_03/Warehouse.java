package prob1;

public class Warehouse {

    protected Item[] items = new Item[10];
    private int numItems = 0;

    public int getNumItems(){
        return numItems;
    }

    public Warehouse(){

    }
    public void addItem(Item item){
        if(numItems >= 10){
            return;
        }
        items[numItems] = item;
        numItems++;
    }
}
