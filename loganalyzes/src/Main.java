import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:/Users/mukundhan/IdeaProjects/loganalyzes/src/logfile.txt";
        analyzeLogFile(filePath);
    }

    private static void analyzeLogFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, Integer> errorCount = new HashMap<>();
            Map<String, Integer> userActivities = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(": ", 2);
                if (parts.length < 2) {
                    continue; // Skip lines that don't have a colon followed by a space
                }
                String timestamp = parts[0];
                String logMessage = parts[1];
//                System.out.println(timestamp);
//                System.out.println(logMessage);
                if (timestamp.endsWith("ERROR")) {
                    errorCount.put(logMessage, errorCount.getOrDefault(logMessage, 0) + 1);
                }
                if (timestamp.endsWith("INFO") && logMessage.contains("User")) {
                    String userName = logMessage.split("'")[1];
                    userActivities.put(userName, userActivities.getOrDefault(userName, 0) + 1);
                }
            }
            System.out.println("Error count:");
            errorCount.forEach((error, count) -> System.out.println(error + ": " + count));
            System.out.println("\nUser activities:");
            userActivities.forEach((user, count) -> System.out.println(user + ": " + count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}