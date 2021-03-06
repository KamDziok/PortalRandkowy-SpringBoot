package pl.AILab1PPS.PortalRandkowy.uzytkownik;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UzytkownikRepository extends PagingAndSortingRepository<Uzytkownik, Long> {
    Uzytkownik findByNickAndHaslo(String nick, String password);
    Uzytkownik findByMailAndHaslo(String mail, String password);
    Uzytkownik findByMailAndNick(String mail, String nick);
    Uzytkownik findByMail(String mail);
    Uzytkownik findByNick(String nick);
    Uzytkownik getOne(Long id);
}
