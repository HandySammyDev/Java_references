package comparable_examples;

public class Box implements Comparable<Box>{

    int x,y,z;
    int volume;

    public Box(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.volume = x*y*z;
    }

    @Override
    public int compareTo(Box other) {
        return this.volume - other.volume;
    }

    @Override
    public boolean equals( Object o ) {
        return this.volume == ((Box)o).volume;
    }

    @Override
    public String toString(){
        return "Box: x=" + x + ", y=" + y + ", z=" + z + ", vol=" + volume;
    }
}
