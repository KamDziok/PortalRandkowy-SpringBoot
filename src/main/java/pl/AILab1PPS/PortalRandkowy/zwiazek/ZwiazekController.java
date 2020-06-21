package pl.AILab1PPS.PortalRandkowy.zwiazek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/zwiazek")
@CrossOrigin
public class ZwiazekController {
    @Autowired
    private ZwiazekRepository zwiazekRepository;

    @GetMapping
    private List<Zwiazek> getAllZwiazek(){
        return (List<Zwiazek>) zwiazekRepository.findAll();
    }

    @PostMapping
    private Zwiazek addZwiazek(@RequestBody Zwiazek zwiazek){
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
