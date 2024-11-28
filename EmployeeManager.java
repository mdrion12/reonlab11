
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {

        if (args.length > 1) {
            System.out.println("No argument provide");
            return;
        }
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = fileReader.readLine();
                String e[] = employee.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = fileReader.readLine();
                System.out.println(employee);
                String e[] = employee.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(e.length);
                System.out.println(e[idx]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter filewriter = new BufferedWriter(new FileWriter("employees.txt", true));
                String newemployee = args[0].substring(1);
                filewriter.write(", " + newemployee);
                filewriter.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = fileReader.readLine();
                char[] chars = employee.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String l = fileReader.readLine();
                String e[] = l.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (e[i].equals(n)) {
                        e[i] = "Updated";
                    }
                }
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", e));
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = fileReader.readLine();
                String e[] = employee.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", list));
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
