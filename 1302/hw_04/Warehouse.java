package prob1;
//“This homework represents my own work. I understand that I may receive help,
// but I did not copy any portion of this assignment from anywhere.
// I understand that a violation of this will result in a Report of Academic Dishonesty.
// —Samuel Perez-Hernandez”

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Warehouse {

    protected ArrayList<Item> items = new ArrayList<>(10);
    private int numItems = 0;

    public int getNumItems(){
        return numItems;
    }

    public Warehouse(){}

    public boolean addItem(Item item){
        if(!items.contains(item) && numItems < 10){
            items.add(item);
            numItems++;
            return true;
        }
        return false;
    }
    public Item getItem(int i){
        if(i>=0 && i<10){
            return items.get(i);
        }
        else{
            return null;
        }
    }
    public Item getItem(String name){
        Item item = new Item(name, 0.0);
        int pos = items.indexOf(item);
        if(pos>=0){
            return items.get(pos);
        }
        return null;
    }
    public double getAverageTemp(){
        double averageTemp = 0.0;
        int count = 0;

        for(int i=0; i<numItems; i++){
            if(items.get(i) instanceof RefrigeratedItem){
                averageTemp += ((RefrigeratedItem) items.get(i)).getTemp();
                count++;
            }
        }
        if(averageTemp == 0){
            return 0;
        }
        else{
            return averageTemp/count;
        }
    }
    public double getTotalCost(){
        double totalCost = 0.0;

        for(int i=0; i<numItems; i++){
            totalCost += items.get(i).cost();
        }
        return totalCost;
    }
    public double getTotalCostRefrigerated(){
        double totalCost = 0.0;

        for(int i=0; i<numItems; i++){
            if(items.get(i) instanceof RefrigeratedItem){
                totalCost += items.get(i).cost();
            }
        }
        return totalCost;
    }
    public ArrayList<RefrigeratedItem> getRefrigeratedItems(){
        ArrayList<RefrigeratedItem> r;
        int count = 0;

        for(int i=0; i<numItems; i++){
            if(items.get(i) instanceof RefrigeratedItem){
                count++;
            }
        }

        if(count==0){
            return null;
        }

        r = new ArrayList<>(count);

        int j = 0;
        while(j<count){
            for(int i=0; i<numItems; i++){
                if(items.get(i) instanceof RefrigeratedItem){
                    r.add((RefrigeratedItem) items.get(i));
                    j++;
                }
            }
        }
        return r;
    }
    public Item removeItem(int i){
        if(i>numItems || i<0){
                return null;
        }
        Item item = items.get(i);
        items.remove(i);
        numItems--;
        return item;
    }
    public Item removeItem(String name){
        Item item = new Item(name, 0.0);
        Item ri = null;
        for(Item i : items){
            if(i.equals(item)){
                ri = i;
            }
        }
        items.remove(ri);
        return ri;
    }
    public ArrayList<Item> getItemsWithName(String partialName){
        ArrayList<Item> i = new ArrayList<>();
        for(Item item : items){
            if(item.getName().startsWith(partialName)){
                i.add(item);
            }
        }
        return i;
    }
    public boolean hasItem(String name){
        Item i = new Item(name, 0.0);
        for(Item item : items){
            if(item.equals(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numItems; i++){
            if(items.get(i) instanceof RefrigeratedItem){
                sb.append(String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees\n",
                        items.get(i).getName(), items.get(i).cost(), items.get(i).getWeight(), ((RefrigeratedItem) items.get(i)).getTemp()));
            }
            else {
                sb.append(String.format("name=%s, cost=$%.2f, weight=%.2f\n",
                        items.get(i).getName(), items.get(i).cost(), items.get(i).getWeight()));
            }
        }

        return sb.toString();
    }
}