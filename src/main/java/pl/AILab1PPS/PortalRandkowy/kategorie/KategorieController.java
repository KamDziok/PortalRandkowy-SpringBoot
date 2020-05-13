package pl.AILab1PPS.PortalRandkowy.kategorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/kategorie")
@CrossOrigin
public class KategorieController {

    @Autowired
    private KategorieRepository kategorieRepository;

    @GetMapping
    private ArrayList<Kategorie> getAllKategorie(){
        return (ArrayList<Kategorie>) kategorieRepository.findAll();
    }

    @PostMapping
    private Kategorie addKategorie(@RequestBody Kategorie kategorie){
        return kategorieRepository.save(kategorie);
    }

    @PutMapping
    private Kategorie updateKategorie(@RequestBody Kategorie kategorie){
        return kategorieRepository.save(kategorie);
    }

    @DeleteMapping
    private Kategorie deleteKategorie(@RequestBody Kategorie kategorie){
        kategorieRepository.delete(kategorie);
        return kategorie;
    }
}
