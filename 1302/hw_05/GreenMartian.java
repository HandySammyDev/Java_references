package prob1;

public class GreenMartian extends Martian implements Teleporter{

    public GreenMartian(int id, int volume) {
        super(id, volume);
    }

    public GreenMartian(int id){
        super(id, 1);
    }

    public int power(){
        return getVolume() * 3;
    }

    public String speak(){
        return String.format("id=%d, Grobldy Grock", this.getId());
    }

    @Override
    public String toString(){
        return String.format("Green Martian - id=%d, vol=%d", getId(), getVolume());
    }

    @Override
    public String teleport(String dest) {
        return String.format("id=%d teleporting to %s", this.getId(), dest);
    }
}
