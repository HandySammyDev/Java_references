package animals2;

public class Bird2 implements Flyer {

    private String name;

    public Bird2(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String fly() {
        return "flap-flap";
    }
}
