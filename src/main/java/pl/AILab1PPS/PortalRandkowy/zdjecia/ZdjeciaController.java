package pl.AILab1PPS.PortalRandkowy.zdjecia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.AILab1PPS.PortalRandkowy.statics.TypeOfImage;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.UzytkownikRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/zdjecia")
@CrossOrigin(origins = "http://localhost:4200")
public class ZdjeciaController {

    private final String mainDirectory = System.getProperty("user.dir");
    private final String imagesDirectory = mainDirectory + "\\serverPHP\\img";

    @Autowired
    private ZdjeciaRepository zdjeciaRepository;
    @Autowired
    private UzytkownikRepository uzytkownikRepository;
    @Autowired
    private ZdjeciaRepositoryDelete zdjeciaRepositoryDelete;

    @GetMapping
    private ArrayList<Zdjecia> getAllZdjecia(){
//        List<Zdjecia> zdjeciaList = (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
//        ArrayList<Zdjecia> zdjeciaListToSend = new ArrayList<>();
//        zdjeciaList.forEach(zdjecie -> {
//            Zdjecia zdjecieToSend = new Zdjecia();
//            zdjecieToSend.setId(zdjecie.getId());
//            zdjecieToSend.setLink(zdjecie.getLink());
//            zdjecieToSend.setOpis(zdjecie.getOpis());
//            zdjecieToSend.setStatus(zdjecie.getStatus());
//            zdjecieToSend.setUzytkownik(zdjecie.getUzytkownik().basicUzytkownik());
//            zdjeciaListToSend.add(zdjecieToSend);
//        });
//        return zdjeciaListToSend;
        return (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
    }

    @GetMapping("/profil/uzytkownik/{id}")
    private Zdjecia getZdjecieProfilowe(@PathVariable Long id){
//        ArrayList<Zdjecia> zdjeciaList = (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
//        Optional<Zdjecia> result = zdjeciaRepository.findAll().stream()
//                .filter(zdjecia -> (zdjecia.getUzytkownik().getId().intValue() == id.intValue() && zdjecia.getStatus() == TypeOfImage.PROFILE)).findFirst();
//        if(result.isEmpty()){
//            return null;
//        }
//        return result.get();
        Optional<Uzytkownik> user = uzytkownikRepository.findById(id);
        if(!user.isEmpty()){
            return zdjeciaRepository.findByUzytkownikAndStatus(user.get(), TypeOfImage.PROFILE);w
        }
        return null;
    }

    @GetMapping("/profil")
    private List<Zdjecia> getAllZdjecieProfilowe(){
        return (List<Zdjecia>) zdjeciaRepository.findByStatus(TypeOfImage.PROFILE);
    }

    @GetMapping("/uzytkownik/{id}")
    private ArrayList<Zdjecia> getAllUzytkownicyZdjecia(@PathVariable Long id){
        ArrayList<Zdjecia> zdjeciaList = (ArrayList<Zdjecia>) zdjeciaRepository.findAll();
        ArrayList<Zdjecia> result = new ArrayList<>();
        zdjeciaList.forEach(zdjecia -> {
            if(zdjecia.getUzytkownik().getId().intValue() == id.intValue()){
                result.add(zdjecia);
            }
        });
        return result;
    }

    private Zdjecia getOne(Long id){
        Optional<Zdjecia> result =  ( (ArrayList<Zdjecia>) zdjeciaRepository.findAll()).stream().
                filter(img -> img.getId().intValue() == id.intValue()).findFirst();
        return result.get();
    }

    @PostMapping
    private Zdjecia addZdjecia(@RequestBody Zdjecia zdjecia){
        return zdjeciaRepository.save(zdjecia);
    }

    @PostMapping("/{id}")
    public Zdjecia uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        Zdjecia zdjecia = getOne(id);
        File imageDirectory = new File(imagesDirectory);
        if (!Files.exists(imageDirectory.toPath())) {
            imageDirectory.mkdir();
        }

        String userName = "\\" + zdjecia.getUzytkownik().getId();
        String userDirectory = imagesDirectory + userName;
        File userImagesDirectory = new File(userDirectory);
        if (!Files.exists(userImagesDirectory.toPath())) {
            userImagesDirectory.mkdir();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String nameFile = (simpleDateFormat.format(new Date())) + "." + file.getContentType().split("/" )[1];
        String imgName = "\\" + nameFile;
        String imgDirectory = userDirectory + imgName;
        if(writeByte(file.getBytes(), new File(imgDirectory)))

        zdjecia.setLink("http://localhost:8000/img/" + zdjecia.getUzytkownik().getId() + "/" + nameFile);

        return zdjeciaRepository.save(zdjecia);
    }

    private boolean writeByte(byte[] bytes, File file) {
        boolean result = false;
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
            result = true;
        }

        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return result;
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

//    @DeleteMapping("/uzytkownik/{id}")
//    private boolean deleteZdjecia(@PathVariable("id") Long id){
//        boolean result = false;
//        Optional<Uzytkownik> user = uzytkownikRepository.findById(id);
//        if(!user.isEmpty()){
//            result = zdjeciaRepository.deleteAllByUzytkownikAndStatus(user.get(), TypeOfImage.PROFILE);
//        }
//        return result;
//    }

    @DeleteMapping("/uzytkownik/{id}")
    private boolean deleteZdjecia(@PathVariable("id") Long id){
        boolean result = false;
        Optional<Uzytkownik> user = uzytkownikRepository.findById(id);
        Zdjecia zdjecia = zdjeciaRepository.findByUzytkownikAndStatus(user.get(), TypeOfImage.PROFILE);
        zdjeciaRepositoryDelete.delete(zdjecia);
        result = true;
        return result;
    }
}
