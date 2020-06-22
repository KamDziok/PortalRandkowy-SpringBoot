package pl.AILab1PPS.PortalRandkowy.wiadomosci;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import java.util.List;

public interface WiadomosciRepository extends PagingAndSortingRepository<Wiadomosci, Long> {
    List<Wiadomosci> findAllByNadawcaAndOdbiorca(Uzytkownik nadawca, Uzytkownik odbiorca);
}
