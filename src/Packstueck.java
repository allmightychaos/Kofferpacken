class Packstueck {
    private final String name;
    private Packstueck naechstesPackstueck;

    public Packstueck(String name) {
        this.name = name;
    }

    public void hinzufuegen(String packstueckName) {
        if (naechstesPackstueck == null) {
            naechstesPackstueck = new Packstueck(packstueckName);
        } else {
            naechstesPackstueck.hinzufuegen(packstueckName);
        }
    }

    public String getPackstueck(int index) {
        if (index == 0) return name;
        if (naechstesPackstueck == null) return null;
        return naechstesPackstueck.getPackstueck(index - 1);
    }

    public int getAnzahlPackstuecke() {
        if (naechstesPackstueck == null) return 1;
        return 1 + naechstesPackstueck.getAnzahlPackstuecke();
    }

    public void inhaltAnzeigen() {
        System.out.print(name);
        if (naechstesPackstueck != null) {
            System.out.print(" → ");
            naechstesPackstueck.inhaltAnzeigen();
        } else {
            System.out.println();
        }
    }
}
