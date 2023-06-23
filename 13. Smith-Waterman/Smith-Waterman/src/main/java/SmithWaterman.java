public class SmithWaterman {

    public static int smithWaterman(String sequence1, String sequence2, int matchScore, int mismatchScore, int gapScore) {
        int[][] matrix = new int[sequence1.length() + 1][sequence2.length() + 1];

        int maxScore = 0;
        int maxI = 0;
        int maxJ = 0;

        // Inicjalizacja pierwszego wiersza i kolumny macierzy
        for (int i = 0; i <= sequence1.length(); i++) {
            matrix[i][0] = 0;
        }

        for (int j = 0; j <= sequence2.length(); j++) {
            matrix[0][j] = 0;
        }

        // Wypełnienie macierzy
        for (int i = 1; i <= sequence1.length(); i++) {
            for (int j = 1; j <= sequence2.length(); j++) {
                int match = matrix[i - 1][j - 1] + (sequence1.charAt(i - 1) == sequence2.charAt(j - 1) ? matchScore : mismatchScore);
                int delete = matrix[i - 1][j] + gapScore;
                int insert = matrix[i][j - 1] + gapScore;

                matrix[i][j] = Math.max(0, Math.max(match, Math.max(delete, insert)));
                System.out.print(matrix[i][j] + "\t");

                if (matrix[i][j] > maxScore) {
                    maxScore = matrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
            System.out.println();
        }

        // Odtworzenie lokalnego dopasowania
        StringBuilder alignment1 = new StringBuilder();
        StringBuilder alignment2 = new StringBuilder();

        int i = maxI;
        int j = maxJ;

        while (i > 0 && j > 0 && matrix[i][j] > 0) {
            if (matrix[i][j] == matrix[i - 1][j - 1] + (sequence1.charAt(i - 1) == sequence2.charAt(j - 1) ? matchScore : mismatchScore)) {
                alignment1.insert(0, sequence1.charAt(i - 1));
                alignment2.insert(0, sequence2.charAt(j - 1));
                i--;
                j--;
            } else if (matrix[i][j] == matrix[i - 1][j] + gapScore) {
                alignment1.insert(0, sequence1.charAt(i - 1));
                alignment2.insert(0, "-");
                i--;
            } else {
                alignment1.insert(0, "-");
                alignment2.insert(0, sequence2.charAt(j - 1));
                j--;
            }
        }

        System.out.println("Dopasowanie: ");
        System.out.println(alignment1);
        System.out.println(alignment2);

        return maxScore;
    }

    public static void main(String[] args) {
//        String sequence1 = "AGTACGCA";
//        String sequence2 = "TATGC";
        String sequence1 = "AGACTACT";
        String sequence2 = "TACATAGTA";
//        int matchScore = 2;
        int matchScore = 1;
        int mismatchScore = -1;
        int gapScore = -1;
//        int gapScore = -2;

        int score = smithWaterman(sequence1, sequence2, matchScore, mismatchScore, gapScore);
        System.out.println("Najwyższy wynik: " + score);
    }
}
