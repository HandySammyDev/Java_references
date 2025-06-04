package Learning;

public class DynamicArray_Main {
    public static void main(String[] args){
        DynamicArray1 dynamicArray = new DynamicArray1(5);

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");

        dynamicArray.insert(0,"X");
        dynamicArray.delete("A");

        //System.out.println(dynamicArray.capacity);
        System.out.println(dynamicArray);
        System.out.println("Size: " + dynamicArray.size);
        System.out.println("Capacity " + dynamicArray.capacity);
        System.out.println("Empty list: " + dynamicArray.isEmpty());
        System.out.println("Searched at: " + dynamicArray.search("C"));

        dynamicArray.delete("A");
        dynamicArray.delete("B");
        dynamicArray.delete("C");
        dynamicArray.delete("D");
        System.out.println("Capacity " + dynamicArray.capacity);
    }
}
