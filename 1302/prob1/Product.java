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

        return Integer.parseInt(code.substring(indexDateBegins+8));
    }
    private String extractDate(){

        int i = indexDateBegins;

        return code.substring(i,i+2) + "/" + code.substring(i+2,i+4) + "/" + code.substring(i+4,i+8);
    }
    private String extractPlant(){
        if(Character.isLetter(code.charAt(2))){
            indexDateBegins = 2;
            return code.substring(0,2);
        }
        else{
            indexDateBegins = 1;
            return code.substring(0,1);
        }
    }

    public int getBatch(){
        return batch = extractBatch();
    }
    public String getCode(){
        return code;
    }
    public String getDate(){
        return date = extractDate();
    }
    public String getPlant(){
        return plant = extractPlant();
    }

    public boolean isAfter2000(){

        return batch >= 2000;
    }
    public boolean isMonthEqual(int month){
        return Integer.parseInt(getDate().substring(0,2)) == month;
    }

    @Override
    public String toString(){
//        code=VLD040419367, plant=VLD, date=04/04/1936, batch=7
//        code=SF0404193643, plant=SF, date=04/04/1936, batch=43

        return String.format("code=%s, plant=%s, date=%s, batch%d",
                            getCode(), getPlant(), getDate(), getBatch());
    }
}
