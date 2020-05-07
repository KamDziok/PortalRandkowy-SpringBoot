package pl.AILab1PPS.PortalRandkowy.zgloszenie;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZgloszenieId implements Serializable {

    @Column(name = "uzytkownik_a_id")
    private Long uzytkownikAId;

    @Column(name = "uzytkownik_b_id")
    private Long uzytkownikBId;

    public ZgloszenieId() {
    }

    public ZgloszenieId(Long uzytkownikAId, Long uzytkownikBId) {
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
