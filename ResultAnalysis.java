import java.util.Scanner;

public class ResultAnalysis {

    static int countA = 0, countB = 0, countC = 0, countF = 0;

    static void HighestScrorer(int[] marks) {

        int highscore = marks[0];
        int rollno = 1;

        for (int i = 1; i < marks.length; i++) {

            if (marks[i] > highscore) {
                highscore = marks[i];
                rollno = i + 1;
            }
        }

        System.out.println("Highest Score: " + highscore +
                           " Roll no: " + rollno);
    }

    static void GradeFrequency(char a) {

        switch (a) {

            case 'A':
                countA++;
                break;

            case 'B':
                countB++;
                break;

            case 'C':
                countC++;
                break;

            case 'F':
                countF++;
                break;
        }
    }

    static void RepeatedMarks(int[] marks) {

        System.out.println("\nRepeated Marks:");

        boolean found = false;

        for (int i = 0; i < marks.length; i++) {

            boolean alreadyCounted = false;

            for (int k = 0; k < i; k++) {

                if (marks[k] == marks[i]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (alreadyCounted) {
                continue;
            }

            int frequency = 0;

            for (int j = 0; j < marks.length; j++) {

                if (marks[j] == marks[i]) {
                    frequency++;
                }
            }

            if (frequency > 1) {

                System.out.println("Marks: " + marks[i] +
                                   " Frequency: " + frequency);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No repeated marks.");
        }
    }

    static void Reversedmarks(int[] marks) {

        int[] reversedmarks = new int[marks.length];

        for (int i = 0; i < marks.length; i++) {

            reversedmarks[i] = marks[marks.length - 1 - i];
        }

        System.out.println("\nReversed Marks:");

        for (int i = 0; i < reversedmarks.length; i++) {

            System.out.println(reversedmarks[i]);
        }
    }

    static int[] BackupMarks(int[] marks) {

        int[] backupMarks = new int[marks.length];

        for (int i = 0; i < marks.length; i++) {

            backupMarks[i] = marks[i];
        }

        return backupMarks;
    }

    static int[] MergeMarks(int[] marks, int[] reExamMarks) {

        int[] combinedMarks =
                new int[marks.length + reExamMarks.length];

        for (int i = 0; i < marks.length; i++) {

            combinedMarks[i] = marks[i];
        }

        for (int i = 0; i < reExamMarks.length; i++) {

            combinedMarks[marks.length + i] = reExamMarks[i];
        }

        return combinedMarks;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int N = sc.nextInt();

        int[] marks = new int[N];

        for (int i = 0; i < marks.length; i++) {

            System.out.println("Enter marks of student " + (i + 1));

            marks[i] = sc.nextInt();
        }

        HighestScrorer(marks);

        for (int i = 0; i < marks.length; i++) {

            if (marks[i] > 90)
                GradeFrequency('A');

            else if (marks[i] > 75)
                GradeFrequency('B');

            else if (marks[i] > 50)
                GradeFrequency('C');

            else
                GradeFrequency('F');
        }

        System.out.println("\nGrade Frequency:");

        System.out.println("Grade A: " + countA);
        System.out.println("Grade B: " + countB);
        System.out.println("Grade C: " + countC);
        System.out.println("Grade F: " + countF);

        RepeatedMarks(marks);
        Reversedmarks(marks);

        int[] backupMarks = BackupMarks(marks);

        System.out.println("\nBackup Array:");

        for (int i = 0; i < backupMarks.length; i++) {

            System.out.println(backupMarks[i]);
        }

        System.out.println("\nEnter the number of re-exam marks: ");

        int M = sc.nextInt();

        int[] reExamMarks = new int[M];

        for (int i = 0; i < reExamMarks.length; i++) {

            System.out.println("Enter re-exam mark " + (i + 1));

            reExamMarks[i] = sc.nextInt();
        }

        int[] combinedMarks = MergeMarks(marks, reExamMarks);

        System.out.println("\nCombined Marks:");

        for (int i = 0; i < combinedMarks.length; i++) {

            System.out.println(combinedMarks[i]);
        }

        sc.close();
    }
}