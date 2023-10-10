import java.util.Scanner;

public class Player {
    private String name;
    private String marker;

    public Player(Scanner s, String defaultMarker, String playerName) {
        this.name = playerName;
        selectMarker(s, defaultMarker);
    }

    // Updated selectMarker method in Player class

    private void selectMarker(Scanner s, String defaultMarker) {
        String selectedMarker;
        String opponentMarker = defaultMarker.equals("X") ? "O" : "X"; // Determine the opponent's marker

        while (true) {
            System.out.print("Select marker " + this.name + ": (" + defaultMarker + "): ");
            selectedMarker = s.next().trim().toUpperCase(); // Convert to uppercase for case-insensitive comparison

            if (!selectedMarker.equals("X") && !selectedMarker.equals("O")) {
                System.out.println("Invalid marker. Please enter X or O.");
            } else if (selectedMarker.equals(opponentMarker)) {
                System.out.println("Marker already chosen by Player 1. Please choose a different marker.");
            } else {
                break; // Break the loop if a valid and unique marker is selected
            }
        }

        this.marker = selectedMarker;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }
}
