package pl.AILab1PPS.PortalRandkowy.zwiazek;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import java.util.List;

public interface ZwiazekRepository extends PagingAndSortingRepository<Zwiazek, Long> {
    List<Zwiazek> findAllByUzytkownikA(Uzytkownik user);
    List<Zwiazek> findAllByUzytkownikB(Uzytkownik user);
    Zwiazek findByUzytkownikAAndUzytkownikB(Uzytkownik userA, Uzytkownik userB);
}
