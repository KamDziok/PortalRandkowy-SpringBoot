package pl.AILab1PPS.PortalRandkowy.zgloszenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/zgloszenie")
@CrossOrigin
public class ZgloszenieController {
    @Autowired
    private ZgloszenieRepository zgloszenieRepository;

    @GetMapping
    private List<Zgloszenie> getAllZgloszenie(){
        return (List<Zgloszenie>) zgloszenieRepository.findAll();
    }

    @PostMapping
    private Zgloszenie addZgloszenie(@RequestBody Zgloszenie zgloszenie){
        return zgloszenieRepository.save(zgloszenie);
    }

    @PutMapping
    private Zgloszenie updateZgloszenie(@RequestBody Zgloszenie zgloszenie){
        return zgloszenieRepository.save(zgloszenie);
    }

    @DeleteMapping
    private Zgloszenie deleteZgloszenie(@RequestBody Zgloszenie zgloszenie){
        zgloszenieRepository.delete(zgloszenie);
        return zgloszenie;
    }
}
