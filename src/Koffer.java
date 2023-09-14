class Koffer {
    private Packstueck erstesPackstueck;

    public void hinzufuegen(String packstueckName) {
        if (erstesPackstueck == null) {
            erstesPackstueck = new Packstueck(packstueckName);
        } else {
            erstesPackstueck.hinzufuegen(packstueckName);
        }
    }

    public String getPackstueck(int index) {
        if (erstesPackstueck == null) return null;
        return erstesPackstueck.getPackstueck(index);
    }

    public int getAnzahlPackstuecke() {
        if (erstesPackstueck == null) return 0;
        return erstesPackstueck.getAnzahlPackstuecke();
    }

    public void inhaltAnzeigen() {
        if (erstesPackstueck != null) {
            erstesPackstueck.inhaltAnzeigen();
        }
    }
}
