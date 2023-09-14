Es soll das Spiel [Kofferpacken](https://de.wikipedia.org/wiki/Kofferpacken) für einen Spieler auf der Konsole umgesetzt werden.

In der Main-Funktion soll zu Beginn abgefragt werden nach wie vielen Fehlern das Spiel endet und es abgespeichert werden (selbst entscheiden wie es gespeichert wird). Danach läuft eine Schleife bis die Fehleranzahl erreicht ist.

- Da die Konsole in IntelliJ nicht gelöscht werden kann, geben Sie 20 leere Zeilen aus um die alte Ausgabe auszublenden.
- Dann wird ausgegeben, dass eine neue Runde beginnt und wie viele Fehler noch erlaubt sind
- Danach folgt das Einpacken des Koffers
  - Ist der Koffer noch leer, darf der Spieler gleich ein neues Stück einpacken (in der Funktion abfragen) und seine Runde ist erfolgreich beendet
  - Sind bereits Stücke im Koffer muss der Spieler jedes Stück eingeben (in der Funktion des Packstücks abfragen)
  - Ist die Eingabe falsch wird das ausgegeben und die Fehleranzahl erhöht bzw. die möglichen Fehler reduziert.
  - Ist es korrekt, geht es mit dem nächsten Stück weiter wenn es eines gibt
  - Wenn es das Letzte war, darf der Spieler hier ein neues Stück einpacken und seine Runde endet
  - Es wird zurück gegeben ob erfolgreich eingepackt wurde (neues Packstück) oder nicht
- Beim Ende der Runde wird, falls ein Fehler gemacht wurde, der aktuelle Inhalt des Koffers ausgegeben.
- Sind keine Fehler mehr möglich, wird das ausgegeben und die Schleife verlassen (Spielende). Zusätzlich wird nun noch ausgegeben, wie viele Packstücke erfolgreich eingepackt wurden.