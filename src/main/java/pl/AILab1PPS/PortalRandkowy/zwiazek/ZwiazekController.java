package pl.AILab1PPS.PortalRandkowy.zwiazek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/zwiazek")
@CrossOrigin
public class ZwiazekController {


    @Autowired
    private ZwiazekRepository zwiazekRepository;

    @GetMapping
    private ArrayList<Zwiazek> getAllZgloszenie(){

        return (ArrayList<Zwiazek>) zwiazekRepository.findAll();
    }

    @PostMapping
    private Zwiazek addZgloszenie(@RequestBody Zwiazek zwiazek){

        return zwiazekRepository.save(zwiazek);
    }

    @PutMapping
    private Zwiazek updateZgloszenie(@RequestBody Zwiazek zwiazek){

        return zwiazekRepository.save(zwiazek);
    }

    @DeleteMapping
    private Zwiazek deleteZgloszenie(@RequestBody Zwiazek zwiazek){
        zwiazekRepository.delete(zwiazek);
        return zwiazek;
    }
}
