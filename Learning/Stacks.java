package Learning;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args){
        //Y;
        //B;
        //R;

        Stack<Character> tower = new Stack<>();

        tower.add('R');
        tower.add('B');
        tower.add('Y');

        System.out.println(tower.contains('R'));
        System.out.println(tower.empty());
        System.out.println(tower.set(1, 'P'));
        System.out.println(tower);
        System.out.println(tower.size());
    }
}
