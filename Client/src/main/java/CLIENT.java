import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class CLIENT {
    public static void main(String[] args) {
        try {
            CRUDInterface crud = (CRUDInterface) Naming.lookup("rmi://" + Config.IP_SERVER + ":" + Config.PORT_SERVER + "/crud");
            CRUDInterface crud_2 = (CRUDInterface) Naming.lookup("rmi://" + Config.IP_SERVER_2 + ":" + Config.PORT_SERVER + "/crud");
            boolean flag = true;
            Scanner scanner = new Scanner(System.in);
            while (flag) {
                printMenu();
                int n = 0;
                try {
                    System.out.print("Please select menu: ");
                    n = scanner.nextInt();
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("your input invalid");
                }
                switch (n) {
                    case 1:
                        System.out.print("New student: ");
                        scanner.nextLine();
                        String student1 = scanner.nextLine();
                        printList(crud.addStudent(student1, false));
                        break;
                    case 2:
                        System.out.print("Delete student: ");
                        scanner.nextLine();
                        String student2 = scanner.nextLine();
                        printList(crud.deleteStudents(student2, false));
                        break;
                    case 3:
                        printList(crud.getStudents(false));
                        break;
                    default: flag = false;
                }

            }
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printList(List<String> strings) {
        System.out.println(strings);
        System.out.println("==================================");
    }

    private static void printMenu() {
        System.out.println("" +
                "1. Add new student\n" +
                "2. Delete student\n" +
                "3. Get students\n" +
                "4. Exit"
        );
    }
}
