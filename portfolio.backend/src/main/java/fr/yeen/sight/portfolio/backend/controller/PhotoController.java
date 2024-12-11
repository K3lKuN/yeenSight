package fr.yeen.sight.portfolio.backend.controller;

import fr.yeen.sight.portfolio.backend.entity.Photo;
import fr.yeen.sight.portfolio.backend.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/photo")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;


    @PostMapping(path = "/add")
    public @ResponseBody String addPhoto(@RequestParam String name, @RequestParam String description){
        Photo photo = new Photo();
        photo.setTitle(name);
        photo.setDescription(description);

        photoRepository.save(photo);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Photo> getAllUsers() {
        // This returns a JSON or XML with the users
        return photoRepository.findAll();
    }

    @GetMapping(path="/findById")
    public @ResponseBody Optional<Photo> getAllUsers(@RequestParam int id) {
        // This returns a JSON or XML with the users
        return photoRepository.findById(id);
    }
}
