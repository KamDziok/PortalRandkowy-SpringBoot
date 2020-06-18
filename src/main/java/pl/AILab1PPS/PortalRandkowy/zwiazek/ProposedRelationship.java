package pl.AILab1PPS.PortalRandkowy.zwiazek;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

public class ProposedRelationship {
    private Uzytkownik uzytkownik;
    private int points;

    public ProposedRelationship() {
    }

    public ProposedRelationship(Uzytkownik uzytkownik, int points) {
        this.uzytkownik = uzytkownik;
        this.points = points;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
