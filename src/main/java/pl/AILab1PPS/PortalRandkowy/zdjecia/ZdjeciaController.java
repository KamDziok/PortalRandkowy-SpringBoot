package pl.AILab1PPS.PortalRandkowy.zdjecia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity.BodyBuilder;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/zdjecia")
@CrossOrigin
public class ZdjeciaController {

    private final String mainDirectory = System.getProperty("user.dir");
    private final String imagesDirectory = mainDirectory + "\\serverPHP\\img";

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

//    @PostMapping
//    private Zdjecia addZdjecia(@RequestBody Zdjecia zdjecia){
//
//        return zdjeciaRepository.save(zdjecia);
//    }

    @PostMapping
    public Zdjecia uplaodImage(
//            @RequestParam("file") MultipartFile file, @RequestParam("zdjecia") Zdjecia zdjecia
//            @RequestBody MyWebRequestObject postZdjecia
            @RequestBody PostZdjecia postZdjecia
//            @RequestParam  Map<Zdjecia, MultipartFile> requestParams
            ) throws IOException {
//        System.out.println(file);
//        System.out.println(file.getName());
//        System.out.println(zdjecia);
        Zdjecia zdjecia = postZdjecia.getZdjecia();
        MultipartFile file = postZdjecia.getFile();

//        System.out.println(requestParams);
//        Map.Entry<Zdjecia, MultipartFile> entry = requestParams.entrySet().iterator().next();
//        Zdjecia zdjecia = entry.getKey();
//        MultipartFile file = entry.getValue();

//        Zdjecia zdjecia = (Zdjecia) requestParams.get("zdjecia");
//        MultipartFile file = requestParams.get("file");

//        System.out.println("Original Image Byte Size - " + file.getBytes().length);
//        System.out.println(mainDirectory);
//        System.out.println(imagesDirectory);
        File imageDirectory = new File(imagesDirectory);
        if (!Files.exists(imageDirectory.toPath())) {
            System.out.println("nie istnieje");
            imageDirectory.mkdir();
        }

//        String userName = "\\" + zdjecia.getUzytkownik().getId();
//        String userDirectory = imagesDirectory + userName;
//        File userImagesDirectory = new File(userDirectory);
//        if (!Files.exists(userImagesDirectory.toPath())) {
//            userImagesDirectory.mkdir();
//        }
//
//        String nameFile = new Date().toString();
//        String imgName = "\\" + nameFile;
//        String imgDirectory = userDirectory + imgName;
////        file.transferTo(new File(imgDirectory));
//        if(writeByte(file.getBytes(), new File(imgDirectory + imgName)))
//
//        zdjecia.setLink("http://localhost:8000/img/" + zdjecia.getUzytkownik().getId() + "/" + nameFile);

//        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//                compressBytes(file.getBytes()));
//        imageRepository.save(img);

//        return zdjeciaRepository.save(zdjecia);
        return null;
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
}
