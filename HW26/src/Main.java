import java.util.*;
import java.util.stream.Collectors;

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

        Employee employee = employees.stream()
                .max(Comparator.comparing(Employee::getKpi)).get();
        System.out.println(employee);

        Employee employee1 = employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .get();
        System.out.println(employee1);

        Employee employee2 = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get();
        System.out.println(employee2);

        Employee employee3 = employees.stream()
                .filter(h -> !h.getName().matches(ABC))
                .findFirst()
                .get();
        System.out.println(employee3);

        double averageKpi = employees.stream()
                .mapToInt(Employee::getKpi)
                .average().getAsDouble();

        employees.stream()
                .filter(h -> h.getKpi() > averageKpi)
                .forEach(h -> System.out.println("Работник с kpi вышего среднего: "
                        + h.getName() + " " + h.getSurname()));

        double averageKpi2 = employees.stream()
                .filter(h -> h.getAge() < 45)
                .filter(h -> h.getSalary() > 20000)
                .filter(h -> h.getName().matches(ABC) && h.getSurname().matches(ABC))
                .mapToInt(Employee::getKpi)
                .average().orElse(0);
        System.out.println("Средний kpi у определённых работников: " + averageKpi2);

        employees.stream()
                .filter(h -> h.getAge() < 35)
                .filter(h -> h.getSalary() > 10000)
                .collect(Collectors.toMap(e -> e.getName() + e.getSurname(), h-> h))
                .entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

    }
}