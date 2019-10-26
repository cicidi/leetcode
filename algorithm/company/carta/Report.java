package company.carta;

import java.util.*;

public class Report {

    public List<Person> allEmployees = new ArrayList<>();

    public static void main(String[] args) {
        Person A = new Person(0, "A");
        Person B = new Person(1, "B");
        Person C = new Person(2, "C");
        Person D = new Person(3, "D");
        Person E = new Person(4, "E");
        Person F = new Person(5, "F");
        Person G = new Person(6, "G");

        Report report = new Report();
        report.allEmployees.add(A);
        report.allEmployees.add(B);
        report.allEmployees.add(C);
        report.allEmployees.add(D);
        report.allEmployees.add(E);
        report.allEmployees.add(F);
        report.allEmployees.add(G);

        A.add(B);
        A.add(C);
        B.add(D);
        B.add(E);
        C.add(F);
        C.add(G);
        System.out.println(report.dfs(A, 1));
    }

    public String dfs(Person p, int t) {
        String dfsResult = p.name + "\n";
        if (p.employees.size() == 0) {
            return dfsResult;
        }
        for (Person emp : p.employees) {
            dfsResult += this.tier(t) + dfs(emp, t + 1);
        }
        return dfsResult;
    }


    public String tier(int tier) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tier; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

class Person {
    int id;
    String name;
    List<Person> employees;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void add(Person p) {
        this.employees.add(p);
    }
}
