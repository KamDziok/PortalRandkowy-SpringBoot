package pl.AILab1PPS.PortalRandkowy.zdjecia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/zdjecia")
@CrossOrigin
public class ZdjeciaController {


    @Autowired
    private ZdjeciaRepository zdjeciaRepository;

    @GetMapping
    private ArrayList<Zdjecia> getAllZdjecia(){

        return (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
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
