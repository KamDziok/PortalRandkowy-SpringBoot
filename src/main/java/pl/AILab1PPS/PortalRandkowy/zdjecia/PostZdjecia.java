package pl.AILab1PPS.PortalRandkowy.zdjecia;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@JsonDeserialize(as = PostZdjecia.class)
public class PostZdjecia {
    private Zdjecia zdjecia;
    @Autowired
    private MultipartFile file;

    public PostZdjecia() {
    }

    public PostZdjecia(Zdjecia zdjecia, MultipartFile file) {
        this.zdjecia = zdjecia;
        this.file = file;
    }

    public Zdjecia getZdjecia() {
        return zdjecia;
    }

    public void setZdjecia(Zdjecia zdjecia) {
        this.zdjecia = zdjecia;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
