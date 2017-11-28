package transport;
//"Avrora", "700 years square", "Sedova market", "Druzgba narodiv", "Dom torgovli", "University", "Hospital"
//"Bazar", "Tabac factory", "Forest street", "Luna district" "Mytnyza", "University", "Dnipro"

public enum Stop {
    AVRORA, SEVEN_YEARS_SQUARE, SEDOVA_MARKET, DRUZGBA_NARIDIV, DOM_TORGOVLI, UNIVERSITY, HOSPITAL, CENTRAL_MARKET,
    TABAC_FACTORY, FOREST_STREET, LUNA_DISTRICT, MYTNUTSA, DNIPRO, GRUZ_PORT;

    public String getDirection1() {
        return this.toString() + " 1";
    }

    public String getDirection2() {
        return this.toString() + " 2";
    }
}
