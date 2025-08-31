package prob1;

public class BasketballPlayer {

    private int freeThrowsAttempted;
    private int freeThrowsMade;
    private String name;
    private int threePointersAttempted;
    private int threePointersMade;
    private int twoPointersAttempted;
    private int twoPointersMade;

    public BasketballPlayer(String name){
        this.name = name;
        freeThrowsAttempted = 0;
        freeThrowsMade = 0;
    }

    public int getFreeThrowsAttempted(){
        return freeThrowsAttempted;
    }
    public int getFreeThrowsMade(){
        return freeThrowsMade;
    }
    public String getName(){
        return name;
    }
    public int getThreePointersAttempted(){
        return threePointersAttempted;
    }
    public int getThreePointersMade(){
        return threePointersMade;
    }


    public double getFreeThrowPercent(){

        if(freeThrowsAttempted>0){
            return ((double)freeThrowsMade/freeThrowsAttempted) * 100;
        }
        else{
            return 0;
        }
    }

    public double getTwoPointerPercent(){

        if(twoPointersAttempted>0){
            return ((double)twoPointersMade/twoPointersAttempted) * 100;
        }
        else{
            return 0;
        }
    }

    public double getThreePointerPercent(){

        if(threePointersAttempted>0){
            return ((double)threePointersMade/threePointersAttempted) * 100;
        }
        else{
            return 0;
        }
    }


    public int getTotalPoints(){

        return freeThrowsMade + 2*twoPointersMade + 3*threePointersMade;
    }


    public int getTwoPointersAttempted(){
        return twoPointersAttempted;
    }
    public int getTwoPointersMade(){
        return twoPointersMade;
    }


    public void shootFreeThrow(boolean isMade){
        freeThrowsAttempted++;
        if(isMade){
            freeThrowsMade++;
        }
    }
    public void shootThreePointer(boolean isMade){ //Says free throw but imma put three for now
        threePointersAttempted++; //Increments the number of free throws attempted and if isMade is true, then increments the number of 3 point shots made.
        if(isMade){
            threePointersMade++;
        }
    }
    public void shootTwoPointer(boolean isMade){
        twoPointersAttempted++;
        if(isMade){
            twoPointersMade++;
        }
    }


    private int freeThrowsAttempted(){
        return freeThrowsAttempted;
    }
    private int freeThrowsMade(){
        return freeThrowsMade;
    }
    private String name(){
        return name;
    }
    private int threePointersAttempted(){
        return threePointersAttempted;
    }
    private int threePointersMade(){
        return threePointersMade;
    }
    private int twoPointersAttempted(){
        return twoPointersAttempted;
    }
    private int twoPointersMade(){
        return twoPointersMade;
    }

    @Override
    public String toString(){

        return String.format(
                "Player: %s, points: %d\n" +
                "   Free Throws: made: %d, attempted: %d, percent: %.1f%n" +
                "    2 Pointers: made: %d, attempted: %d, percent: %.1f%n" +
                "Three Pointers: made: %d, attempted: %d, percent: %.1f%n",
                name, getTotalPoints(),
                freeThrowsMade, freeThrowsAttempted, getFreeThrowPercent(),
                twoPointersMade, twoPointersAttempted, getTwoPointerPercent(),
                threePointersMade, threePointersAttempted, getTwoPointerPercent()
                );
    }

    public static void main(String[] args){
        BasketballPlayer p = new BasketballPlayer("Walker");
        System.out.println(p + " Hello");
    }
}