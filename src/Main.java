import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Koffer koffer = new Koffer();
        int fehlerCounter = 0;

        System.out.println("Willkommen zu Kofferpacken! Beenden mit \"exit\" oder \"end\".");
        System.out.print("Möchtest du die Reihenfolge nach jeder richtigen Eingabe sehen? (Ja/Nein): ");
        String antwort = scanner.nextLine();
        if (antwort.equalsIgnoreCase("exit") || antwort.equalsIgnoreCase("end")) {
            System.out.println("Spiel beendet!");
            return;
        }

        promptAndAddPackstueck("erstes", koffer, scanner);
        promptAndAddPackstueck("zweites", koffer, scanner);

        while (true) {
            clearScreen();

                for (int i = 0; i < koffer.getAnzahlPackstuecke(); i++) {
                    if (checkLoose(fehlerCounter)) {
                        EndGame(koffer);
                    } else {
                        System.out.println("Bitte gib das " + (i + 1) + ". Packstück ein:");
                        String eingegebenesPackstueck = scanner.nextLine();

                        checkExit(eingegebenesPackstueck, koffer);

                        if (!eingegebenesPackstueck.equals(koffer.getPackstueck(i))) {
                            fehlerCounter++;
                            i = -1; // Reset the loop
                            clearScreen();
                            System.out.println("Falsche Eingabe! Du hast noch " + (3 - fehlerCounter) + " Versuche übrig.");
                        }
                    }
                }

            clearScreen();

            if (!checkLoose(fehlerCounter)) {
                System.out.println("Richtig, dies ist die vollständige Reihenfolge deines Koffers:");
                koffer.inhaltAnzeigen();
                System.out.println("\nDrücke 'Enter' um fortzufahren");
                scanner.nextLine();
                clearScreen();

                if (fehlerCounter > 0 && fehlerCounter < 3) {
                    System.out.println("Du hast " + (3 - fehlerCounter) + " Fehler übrig.");
                }
            }
            else {
                EndGame(koffer);
            }

            System.out.println("Bitte gib dein neues Stück ein:");

            String neuesPackstueck = scanner.nextLine();
            if (neuesPackstueck.equalsIgnoreCase("exit") || neuesPackstueck.equalsIgnoreCase("end")) {
                System.out.println("Spiel beendet! Du hast " + koffer.getAnzahlPackstuecke() + " Packstücke erfolgreich eingepackt.");
                return;
            }
            koffer.hinzufuegen(neuesPackstueck);
        }
    }

    private static void promptAndAddPackstueck(String stueck, Koffer koffer, Scanner scanner) {
        clearScreen();

        System.out.println("Gib dein " + stueck + " Stück in deinen Koffer:");
        String packstueck = scanner.nextLine();
        checkExit(packstueck, koffer);
        koffer.hinzufuegen(packstueck);
    }

    private static boolean checkLoose(int fehlerCounter) { return fehlerCounter == 3; }

    private static void checkExit(String input, Koffer koffer) {
        if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("end")) {
            System.out.println("Spiel beendet! Du hast " + koffer.getAnzahlPackstuecke() + " Packstücke erfolgreich eingepackt.");
            System.exit(0); // Beendet das Programm
        }
    }

    private static void EndGame(Koffer koffer) {
        clearScreen();
        System.out.println("Du hast leider verloren, das Spiel wird beendet. ");
        System.out.println("\nFolgende Packstücke hast du in deinem Koffer eingepackt:");
        koffer.inhaltAnzeigen();

        System.exit(0);
    }

    private static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}