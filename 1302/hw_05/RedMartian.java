package prob1;

public class RedMartian extends Martian implements Comparable<Martian>{

    private int tenacity;

    public int getTenacity(){
        return tenacity;
    }

    public RedMartian(int id, int volume, int tenacity) {
        super(id, volume);
        this.tenacity = tenacity;
    }

    public RedMartian(int id, int tenacity) {
        super(id, 1);
        this.tenacity = tenacity;
    }

    public int power(){
        return (getVolume() * 2) + getTenacity();
    }

    public void setTenacity(int tenacity){
        this.tenacity = tenacity;
    }

    public String speak(){
        return String.format("id=%d, Rubldy Rock", this.getId());
    }

    @Override
    public String toString(){
        return String.format("Red Martian - id=%d, vol=%d, ten=%d",
                getId(), getVolume(), getTenacity());
    }
}
