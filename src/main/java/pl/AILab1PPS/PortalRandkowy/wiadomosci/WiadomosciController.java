package pl.AILab1PPS.PortalRandkowy.wiadomosci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;
import pl.AILab1PPS.PortalRandkowy.zwiazek.Zwiazek;
import pl.AILab1PPS.PortalRandkowy.zwiazek.ZwiazekRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/wiadomosci")
@CrossOrigin
public class WiadomosciController {

    @Autowired
    private WiadomosciRepository wiadomosciRepository;
    @Autowired
    ZwiazekRepository zwiazekRepository;

    @GetMapping
    private List<Wiadomosci> getAllWiadomosci(){
        return (List<Wiadomosci>) wiadomosciRepository.findAll();
    }

    @GetMapping("/zwiazek/{id}")
    private List<Wiadomosci> getZwiazekWiadomosic(@PathVariable Long id){
        Optional<Zwiazek> zwiazek = (Optional<Zwiazek>) zwiazekRepository.findById(id);
        List<Wiadomosci> uzytkownikA = wiadomosciRepository.findAllByNadawcaAndOdbiorca(zwiazek.get().getUzytkownikA(), zwiazek.get().getUzytkownikB());
        List<Wiadomosci> uzytkownikB = wiadomosciRepository.findAllByNadawcaAndOdbiorca(zwiazek.get().getUzytkownikB(), zwiazek.get().getUzytkownikA());
        List<Wiadomosci> result = new ArrayList<>();
        result.addAll(uzytkownikA);
        result.addAll(uzytkownikB);
        result = sortWiadomosci(result);
        return result;
    }

    private List<Wiadomosci> sortWiadomosci(List<Wiadomosci> result){
        List<Wiadomosci> wynik = new ArrayList<>();
        if(!result.isEmpty()){
            wynik.add(result.get(0));
            for(int i = 1; i < result.size(); i++){
                Wiadomosci wiadomoscResult = result.get(i);
                for(int j = 0; j < wynik.size(); j++){
                    Wiadomosci wiadomoscWynik = wynik.get(j);
                    if(wiadomoscWynik.getDataNadeslania().compareTo(wiadomoscResult.getDataNadeslania()) > 0){
                        wynik = insertBefore(wynik, wiadomoscResult, j);
                        break;
                    }
                    if(j == (wynik.size() - 1)){
                        wynik.add(wiadomoscResult);
                        break;
                    }
                }
            }
        }
        return wynik;
    }

    private List<Wiadomosci> insertBefore(List<Wiadomosci> result, Wiadomosci insert, int index){
        int size = result.size();
        Wiadomosci tmp;
        for(; index < size; index++){
            tmp = result.get(index);
            result.set(index, insert);
            insert = tmp;
        }
        result.add(insert);
        return result;
    }

    @PostMapping
    private Wiadomosci addWiadomosci(@RequestBody Wiadomosci wiadomosci){
        return wiadomosciRepository.save(wiadomosci);
    }

    @PutMapping
    private Wiadomosci updateWiadomosci(@RequestBody Wiadomosci wiadomosci){
        return wiadomosciRepository.save(wiadomosci);
    }

    @DeleteMapping
    private Wiadomosci deleteWiadomosci(@RequestBody Wiadomosci wiadomosci){
        wiadomosciRepository.delete(wiadomosci);
        return wiadomosci;
    }
}
