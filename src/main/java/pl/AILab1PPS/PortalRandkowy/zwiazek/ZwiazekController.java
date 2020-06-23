package pl.AILab1PPS.PortalRandkowy.zwiazek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.AILab1PPS.PortalRandkowy.statics.Relationship;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.UzytkownikRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/zwiazek")
@CrossOrigin
public class ZwiazekController {
    @Autowired
    private ZwiazekRepository zwiazekRepository;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    @GetMapping
    private List<Zwiazek> getAllZwiazek(){
        return (List<Zwiazek>) zwiazekRepository.findAll();
    }

    @GetMapping("/uzytkownik/{id}")
    private List<Zwiazek> getAllUzytkownicy(@PathVariable("id") Long idUser){
        Optional<Uzytkownik> user = uzytkownikRepository.findById(idUser);
        List<Zwiazek> zwiazekList = zwiazekRepository.findAllByUzytkownikA(user.get());
        zwiazekList.addAll(zwiazekRepository.findAllByUzytkownikB(user.get()));
        List<Zwiazek> result = new ArrayList<>();
        zwiazekList.forEach(zwiazek -> {
            if(zwiazek.getZgodaBlokada() > Relationship.PROPOSED){
                result.add(zwiazek);
            }
        });
        return result;
    }

    @GetMapping("/uzytkownikA/{idA}/uzytkownikB/{idB}")
    private Zwiazek getZwiazekUser(@PathVariable("idA") Long idUserA, @PathVariable("idB") Long idUserB){
        Optional<Uzytkownik>userA = uzytkownikRepository.findById(idUserA);
        Optional<Uzytkownik>userB = uzytkownikRepository.findById(idUserB);
        Zwiazek result = null;
        if(!userA.isEmpty() && !userB.isEmpty()){
            result = zwiazekRepository.findByUzytkownikAAndUzytkownikB(userA.get(), userB.get());
            if(result == null){
                result = zwiazekRepository.findByUzytkownikAAndUzytkownikB(userB.get(), userA.get());
            }
        }
        return result;
    }

    @PostMapping
    private Zwiazek addZwiazek(@RequestBody Zwiazek zwiazek){
        Zwiazek isInRelationship = zwiazekRepository.findByUzytkownikAAndUzytkownikB(zwiazek.getUzytkownikB(), zwiazek.getUzytkownikA());
        if(isInRelationship != null){
            isInRelationship.setZgodaBlokada(Relationship.FRIENDS);
            return zwiazekRepository.save(isInRelationship);
        }
        return zwiazekRepository.save(zwiazek);
    }

    @PutMapping
    private Zwiazek updateZwiazek(@RequestBody Zwiazek zwiazek){
        return zwiazekRepository.save(zwiazek);
    }

    @DeleteMapping
    private Zwiazek deleteZwiazek(@RequestBody Zwiazek zwiazek){
        zwiazekRepository.delete(zwiazek);
        return zwiazek;
    }
}
