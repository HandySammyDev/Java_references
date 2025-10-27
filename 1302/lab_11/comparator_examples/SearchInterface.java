package comparator_examples;

import java.util.Comparator;
import java.util.List;

public interface SearchInterface {

    public int search(List<Employee> emps, Employee key, Comparator<Employee> comp);
}