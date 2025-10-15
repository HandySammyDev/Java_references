package prob1;

public abstract class Martian implements Comparable<Martian>{

    private int id;
    private int volume;

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public Martian(int id, int volume){
        this.id = id;
        this.volume = volume;
    }

    public abstract int power();

    public abstract String speak();

    @Override
    public int compareTo(Martian o) {
        return this.id - o.getId();
    }

    @Override
    public boolean equals(Object o){
        return this.id == ((Martian)o).getId();
    }

    @Override
    public String toString(){
        return String.format("id=%d, vol=%d", getId(), getVolume());
    }
}
