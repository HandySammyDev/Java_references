package prob1;

public class Warehouse {

    protected Item[] items = new Item[10];
    private int numItems = 0;

    public int getNumItems(){
        return numItems;
    }

    public Warehouse(){}

    public void addItem(Item item){
        if(numItems < 10){
            items[numItems] = item;
            numItems++;
        }
    }
    public Item getItem(int i){
        if(i>=0 && i<10){
            return items[i];
        }
        else{
            return null;
        }
    }
    public Item getItem(String name){
        for(int i=0; i<numItems; i++){
            if(items[i].getName().equals(name)){
                return items[i];
            }
        }
        return null;
    }
    public double getAverageTemp(){
        double averageTemp = 0.0;
        int count = 0;

        for(int i=0; i<numItems; i++){
            if(items[i] instanceof RefrigeratedItem){
                averageTemp += ((RefrigeratedItem) items[i]).getTemp();
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
            if(!(items[i] instanceof RefrigeratedItem)){
                totalCost += items[i].cost();
            }
        }
        return totalCost;
    }
    public double getTotalCostRefrigerated(){
        double totalCost = 0.0;

        for(int i=0; i<numItems; i++){
            if(items[i] instanceof RefrigeratedItem){
                totalCost += items[i].cost();
            }
        }
        return totalCost;
    }
    public RefrigeratedItem[] getRefrigeratedItems(){
        RefrigeratedItem[] r;
        int count = 0;

        for(int i=0; i<numItems; i++){
            if(items[i] instanceof RefrigeratedItem){
                count++;
            }
        }

        if(count==0){
            return null;
        }

        r = new RefrigeratedItem[count];

        int j = 0;
        while(j<count){
            for(int i=0; i<numItems; i++){
                if(items[i] instanceof RefrigeratedItem){
                    r[j] = (RefrigeratedItem) items[i];
                    j++;
                }
            }
        }
        return r;
    }
//    public Item removeItem(int i){
//        if(items[i] != null){
//            Item item = items[i];
//            for(int j = i; j>=0; j--){
//                Item itemTemp = items[j];
//                items[j-1] = itemTemp;
//            }
//            numItems--;
//            return items[i];
//        }
//        else{
//            return null;
//        }
//    }
//    public Item removeItem(String name){
//        if(){
//
//        }
//    }
}
