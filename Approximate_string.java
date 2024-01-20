import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Approximate_string {
    private static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        // Read the text file and store its content in memory
        readFile("output.txt");

        // Wait for user input and return suitable suggestions
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine().trim();
        System.out.println("enter the value of k");
        int k=scanner.nextInt();
        List<String> suggestions = findApproximateMatches(input, k);
        System.out.println("Suggestions: " + suggestions);
    }

    private static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> findApproximateMatches(String input, int k) {
        Map<String, Integer> similarityMap = new HashMap<>();
        for (String str : stringList) {
            int distance = levenshteinDistance(input, str);
            similarityMap.put(str, distance);
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(similarityMap.entrySet());
        sortedList.sort(Comparator.comparing(Map.Entry::getValue));
        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < Math.min(k, sortedList.size()); i++) {
            suggestions.add(sortedList.get(i).getKey());
        }
        return suggestions;
    }

    private static int levenshteinDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
