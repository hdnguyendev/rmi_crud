import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static String FILE_PATH = getDirectoryPath() + "/Server/src/main/java/data.txt";
    public static String getDirectoryPath() {
        String currentDirectory = System.getProperty("user.dir");
        return currentDirectory;
    }
    public static void saveListToFile(List<String> list) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (String item : list) {
                writer.write(item + "\n");
            }
            System.out.println("List saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error saving list to file: " + e.getMessage());
        }
    }

    public static List<String> loadListFromFile() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            System.out.println("List loaded from file successfully.");
        } catch (IOException e) {
            System.err.println("Error loading list from file: " + e.getMessage());
        }
        return list;
    }

    public static void addToList(String newItem) {
        List<String> list = loadListFromFile();
        list.add(newItem);
        saveListToFile(list);
        System.out.println("Item added to list successfully.");
    }

    public static void removeFromList(String itemToRemove) {
        List<String> list = loadListFromFile();
        list.remove(itemToRemove);
        saveListToFile(list);
        System.out.println("Item removed from list successfully.");
    }

    public static List<String> getAllItems() {
        return loadListFromFile();
    }

}
