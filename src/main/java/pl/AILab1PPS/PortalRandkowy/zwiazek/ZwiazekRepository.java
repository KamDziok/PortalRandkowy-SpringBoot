package pl.AILab1PPS.PortalRandkowy.zwiazek;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

public interface ZwiazekRepository extends PagingAndSortingRepository<Zwiazek, Long> {
    Zwiazek findByUzytkownikAAndUzytkownikB(Uzytkownik userA, Uzytkownik userB);
}
