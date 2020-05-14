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
