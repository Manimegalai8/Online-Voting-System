import java.util.*;

class Candidate {
    String name;
    int voteCount;

    Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    void vote() {
        voteCount++;
    }
}

public class VotingSystemOOP {
    private static List<Candidate> candidates = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCandidates();
        int voters;

        System.out.println("=== Online Voting System ===");
        System.out.print("Enter number of voters: ");
        voters = scanner.nextInt();

        for (int i = 0; i < voters; i++) {
            System.out.println("\nVoter #" + (i + 1));
            showCandidates();
            System.out.print("Choose a candidate (1-" + candidates.size() + "): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= candidates.size()) {
                candidates.get(choice - 1).vote();
                System.out.println("Vote recorded for " + candidates.get(choice - 1).name);
            } else {
                System.out.println("Invalid vote! Skipping...");
            }
        }

        showResults();
    }

    static void initializeCandidates() {
        candidates.add(new Candidate("Alice"));
        candidates.add(new Candidate("Bob"));
        candidates.add(new Candidate("Charlie"));
    }

    static void showCandidates() {
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).name);
        }
    }

    static void showResults() {
        System.out.println("\n=== Voting Results ===");
        Candidate winner = candidates.get(0);

        for (Candidate candidate : candidates) {
            System.out.println(candidate.name + ": " + candidate.voteCount + " votes");
            if (candidate.voteCount > winner.voteCount) {
                winner = candidate;
            }
        }

        System.out.println("\nWinner: " + winner.name + " with " + winner.voteCount + " votes");
    }
}
