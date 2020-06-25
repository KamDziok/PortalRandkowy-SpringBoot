package pl.AILab1PPS.PortalRandkowy.zdjecia;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import java.util.List;


public interface ZdjeciaRepository extends JpaRepository<Zdjecia, Long> {
    boolean deleteAllByUzytkownikAndStatus(Uzytkownik user, Integer status);
    Zdjecia findByUzytkownikAndStatus(Uzytkownik user, Integer status);
    List<Zdjecia> findByStatus(Integer status);
}
