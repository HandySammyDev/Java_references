package prob1;

public class Product {

    private int batch;
    private String code;
    private String date;
    private int indexDateBegins;
    private String plant;

    public Product(String code){
        this.code = code;
    }

    private int extractBatch(){
        return Integer.parseInt(extractDate());
    }
    private String extractDate(){
        indexDateBegins = date.indexOf(date.length()-4);

        return date.substring(indexDateBegins);
    }
    private String extractPlant(){
        return plant;
    }

    public int getBatch(){
        return batch;
    }
    public String getCode(){
        return code;
    }
    public String getDate(){
        return date;
    }
    public String getPlant(){
        return plant;
    }

    public boolean isAfter2000(){

        return extractBatch() >= 2000;
    }
    public boolean isMonthEqual(int month){
        //Returns true if month the product was produced is equal to the input month.
        return false;
    }

    @Override
    public String toString(){
//        code=VLD040419367, plant=VLD, date=04/04/1936, batch=7
//        code=SF0404193643, plant=SF, date=04/04/1936, batch=43   <---????

        return String.format("code=%s, plant=%s, date=%s, batch%d",
                            getCode(), getPlant(), getDate(), getBatch());
    }
}
