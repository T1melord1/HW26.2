import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Task1
        Set<Set<String>> sets = new HashSet<>();
        Set<String> strings = new HashSet<>();
        strings.add("раз");
        strings.add("два");
        strings.add("три");
        Set<String> strings2 = new HashSet<>();
        strings2.add("Первое");
        strings2.add("Второе");
        strings2.add("Семьдесят шестое");
        Set<String> strings3 = new HashSet<>();
        strings3.add("12");
        strings3.add("783");
        strings3.add("37288736");
        Set<String> strings4 = new HashSet<>();
        strings4.add("Проверка");
        strings4.add("Струн");
        strings4.add("Раз-Два");

        sets.add(strings);
        sets.add(strings2);
        sets.add(strings3);
        sets.add(strings4);

        //todo Решение дз 1 тут

        int sum = sets.stream().flatMapToInt(s -> s.stream().flatMapToInt(h -> IntStream.of(h.length()))).sum();
        System.out.println(sum);

        //Task2
                List<Employee> employees = EmployeeFactory.createEmployee();
        //todo решения дз 2 тут
    }
}