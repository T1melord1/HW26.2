import java.util.*;

public class Main {

    private static final String ABC = "[А-я]+";
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

        int sum = sets.stream()
                .flatMapToInt(s -> s.stream()
                        .mapToInt(h -> h.replaceAll(" ", "").length()))
                .sum();
        int max = sets.stream()
                .flatMapToInt(s -> s.stream()
                        .mapToInt(h -> h.replaceAll(" ", "").length()))
                .max()
                .orElse(0);
        System.out.println(sum);
        System.out.println(max);

        //Task2
                List<Employee> employees = EmployeeFactory.createEmployee();
        //todo решения дз 2 тут

        int maxKpi = employees.stream()
                .mapToInt(Employee::getKpi)
                .max()
                .orElse(0);
        System.out.println(maxKpi);

        int maxAge = employees.stream()
                .mapToInt(Employee::getAge)
                .max()
                .orElse(0);

        employees.stream()
                .filter(h -> h.getAge() == maxAge)
                .map(Employee::getName)
                .forEach(h -> System.out.println("Самый старый работник: " + h)  );

        int maxSalary = employees.stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElse(0);

        employees.stream()
                .filter(h -> h.getSalary() == maxSalary)
                .map(Employee::getName)
                .forEach(h -> System.out.println("Работник с самой большой заработной платой: " + h));

        employees.stream()
                .filter(h -> !h.getName().matches(ABC))
                .forEach(h -> System.out.println("Нерусский работник: " + h.getName() + " " + h.getSurname()));
    }
}