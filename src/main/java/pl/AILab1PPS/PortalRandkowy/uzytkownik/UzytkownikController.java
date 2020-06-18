package pl.AILab1PPS.PortalRandkowy.uzytkownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/uzytkownik")
@CrossOrigin
public class UzytkownikController {


        @Autowired
        private UzytkownikRepository uzytkownikRepository;

        @GetMapping
        private ArrayList<Uzytkownik> getAllUzytkownik(){

            return (ArrayList<Uzytkownik>) uzytkownikRepository.findAll();
        }

    @GetMapping("/mail/{mail}/password/{password}")
    private Uzytkownik getUzytkownikByMailAndPassword(@PathVariable("mail") String mail, @PathVariable("password") String password){
        return uzytkownikRepository.findByMailAndHaslo(mail, password);
    }

    @GetMapping("/nick/{nick}/password/{password}")
    private Uzytkownik getUzytkownikByNickAndPassword(@PathVariable("nick") String nick, @PathVariable("password") String password){
        return uzytkownikRepository.findByNickAndHaslo(nick, password);
    }

        @PostMapping
        private Uzytkownik addUzytkownik(@RequestBody Uzytkownik uzytkownik){

            return uzytkownikRepository.save(uzytkownik);
        }

        @PutMapping
        private Uzytkownik updateUzytkownik(@RequestBody Uzytkownik uzytkownik){

            return uzytkownikRepository.save(uzytkownik);
        }

        @DeleteMapping
        private Uzytkownik deleteUzytkownik(@RequestBody Uzytkownik uzytkownik){
            uzytkownikRepository.delete(uzytkownik);
            return uzytkownik;
        }
}
