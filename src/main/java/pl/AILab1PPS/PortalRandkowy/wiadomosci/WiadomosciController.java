package pl.AILab1PPS.PortalRandkowy.wiadomosci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/wiadomosci")
@CrossOrigin
public class WiadomosciController {

    @Autowired
    private WiadomosciRepository wiadomosciRepository;

    @GetMapping
    private List<Wiadomosci> getAllWiadomosci(){
        return (List<Wiadomosci>) wiadomosciRepository.findAll();
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
