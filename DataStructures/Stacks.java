package Learning;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args){
        //stack = LIFO data structure. Last-In First-Out
        //        Stores objects into a sort of vertical tower

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
        System.out.println(tower.search('R'));
        System.out.println(tower);
        System.out.println(tower.size());

        //uses of stacks?

        /*
        1. undo/redo features in text editors
        2. moving back/forward through browser history
        3. backtracking algorithms (maze, file directories)
        4. calling functions (call stack)
         */
    }
}
