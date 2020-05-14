package pl.AILab1PPS.PortalRandkowy.podKategorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/podkategorie")
@CrossOrigin
public class PodKategorieController {
    @Autowired
    private PodKategorieRepository podKategorieRepository;

    @GetMapping
    private ArrayList<PodKategorie> getAllPodKategorie(){
        return (ArrayList<PodKategorie>) podKategorieRepository.findAll();
    }

    @PostMapping
    private PodKategorie addPodKategorie(@RequestBody PodKategorie podkategorie){
        return podKategorieRepository.save(podkategorie);
    }

    @PutMapping
    private PodKategorie updatePodKategorie(@RequestBody PodKategorie podkategorie)
    {
        return podKategorieRepository.save(podkategorie);
    }

    @DeleteMapping
    private PodKategorie deletePodKategorie(@RequestBody PodKategorie podkategorie){
        podKategorieRepository.delete(podkategorie);
        return podkategorie;
    }

}
