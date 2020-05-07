package pl.AILab1PPS.PortalRandkowy.zwiazek;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZwiazekId implements Serializable {

    @Column(name = "uzytkownik_a_id")
    private Long uzytkownikAId;

    @Column(name = "uzytkownik_b_id")
    private Long uzytkownikBId;

    public ZwiazekId() {
    }

    public ZwiazekId(Long uzytkownikAId, Long uzytkownikBId) {
        this.uzytkownikAId = uzytkownikAId;
        this.uzytkownikBId = uzytkownikBId;
    }

    public Long getUzytkownikAId() {
        return uzytkownikAId;
    }

    public void setUzytkownikAId(Long uzytkownikAId) {
        this.uzytkownikAId = uzytkownikAId;
    }

    public Long getUzytkownikBId() {
        return uzytkownikBId;
    }

    public void setUzytkownikBId(Long uzytkownikBId) {
        this.uzytkownikBId = uzytkownikBId;
    }
}
