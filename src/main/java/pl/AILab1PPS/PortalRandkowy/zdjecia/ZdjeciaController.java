package pl.AILab1PPS.PortalRandkowy.zdjecia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/zdjecia")
@CrossOrigin
public class ZdjeciaController {


    @Autowired
    private ZdjeciaRepository zdjeciaRepository;

    @GetMapping
    private ArrayList<Zdjecia> getAllZdjecia(){
        List<Zdjecia> zdjeciaList = (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
        ArrayList<Zdjecia> zdjeciaListToSend = new ArrayList<>();
        zdjeciaList.forEach(zdjecie -> {
            Zdjecia zdjecieToSend = new Zdjecia();
            zdjecieToSend.setId(zdjecie.getId());
            zdjecieToSend.setLink(zdjecie.getLink());
            zdjecieToSend.setOpis(zdjecie.getOpis());
            zdjecieToSend.setStatus(zdjecie.getStatus());
            zdjecieToSend.setUzytkownik(zdjecie.getUzytkownik().basicUzytkownik());
            zdjeciaListToSend.add(zdjecieToSend);
        });
        return zdjeciaListToSend;
    }

    @PostMapping
    private Zdjecia addZdjecia(@RequestBody Zdjecia zdjecia){

        return zdjeciaRepository.save(zdjecia);
    }

    @PutMapping
    private Zdjecia updateZdjecia(@RequestBody Zdjecia zdjecia){

        return zdjeciaRepository.save(zdjecia);
    }

    @DeleteMapping
    private Zdjecia deleteZdjecia(@RequestBody Zdjecia zdjecia){
        zdjeciaRepository.delete(zdjecia);
        return zdjecia;
    }
}
