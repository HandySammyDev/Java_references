package Syntax;

public class Multithreading {
    public static void main(String[] args){

//        MultithreadingThing myThing = new MultithreadingThing();
//        MultithreadingThing myThing2 = new MultithreadingThing();

        // This doesn't run them at the same time, it calls the method but myThing will go first and
        // once that is finished, myThing2 will run its code.

        //myThing.run();
        //myThing2.run();

        // This will run at the same time
//        myThing.start();
//        myThing2.start();

        //------------------------------------------------------------------------------------------

        // We can also use more than one thread
        // These would all run at the same time
        for(int i = 0; i <= 3; i++){
            MultithreadingThing myThing = new MultithreadingThing(i);
            myThing.start();
        }
        throw new RuntimeException();

        //------------------------------------------------------------------------------------------\
    }
}
