
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class constant {
    public static final String FILE_PATH = "employees.txt";
    public static final String DATA_LOADING = "Loading data ...";
    public static final String DATA_LOADED = "Data Loaded.";
    public static final String INVALID_ARGUMENT = "Invalid argument. Please provide a valid command.";
    public static final String EMPLOYEE_NOT_FOUND = "employee not found.";
    public static final String EMPLOYEE_FOUND = "Employee Found.";
}

public class EmployeeManager {
    public static void main(String[] args) {

        if (args.length > 1) {
            System.out.println("No argument provide");
            return;
        }
        constant cons = new constant();
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(cons.FILE_PATH)));
                String employee = fileReader.readLine();
                String e[] = employee.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].equals("s")) {
            System.out.println(cons.DATA_LOADING);
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
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].contains("+")) {
            System.out.println(cons.DATA_LOADING);
            try {
                BufferedWriter filewriter = new BufferedWriter(new FileWriter("employees.txt", true));
                String newemployee = args[0].substring(1);
                filewriter.write(", " + newemployee);
                filewriter.close();
            } catch (Exception e) {
            }
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].contains("?")) {
            System.out.println(cons.DATA_LOADING);
            try {
                BufferedReader filReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = filReader.readLine();
                String e[] = employee.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(s)) {
                        System.out.println(cons.EMPLOYEE_FOUND);
                        found = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].contains("c")) {
            System.out.println(cons.DATA_LOADING);
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
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].contains("u")) {
            System.out.println(cons.DATA_LOADING);
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
                BufferedWriter w = new BufferedWriter(new FileWriter("employees.txt"));
                w.write(String.join(",", e));
                w.close();
            } catch (Exception e) {
            }
            System.out.println(cons.DATA_LOADED);
        } else if (args[0].contains("d")) {
            System.out.println(cons.DATA_LOADING);
            try {
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String employee = fileReader.readLine();
                String e[] = employee.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);
                BufferedWriter w = new BufferedWriter(new FileWriter("employees.txt"));
                w.write(String.join(",", list));
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
