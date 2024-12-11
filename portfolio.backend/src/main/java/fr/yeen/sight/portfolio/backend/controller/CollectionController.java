package fr.yeen.sight.portfolio.backend.controller;

import fr.yeen.sight.portfolio.backend.entity.CollectionPhoto;
import fr.yeen.sight.portfolio.backend.entity.Photo;
import fr.yeen.sight.portfolio.backend.repository.CollectionRepository;
import fr.yeen.sight.portfolio.backend.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/collection")
public class CollectionController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    PhotoRepository photoRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addPhoto(@RequestParam String name, @RequestParam String description){
        CollectionPhoto collectionPhoto = new CollectionPhoto();
        collectionPhoto.setName(name);
        collectionPhoto.setDescription(description);

        collectionRepository.save(collectionPhoto);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CollectionPhoto> getAllUsers() {
        // This returns a JSON or XML with the users
        return collectionRepository.findAll();
    }

    @GetMapping(path="/getCollection")
    public @ResponseBody Optional<CollectionPhoto> getCollection(@RequestParam int id){
        return collectionRepository.findById(id);
    }

    @PostMapping(path="/addPhoto")
    public @ResponseBody String addPhotoToCollection(@RequestParam int idPhoto, @RequestParam int idCollection){
        Optional<CollectionPhoto> collectionPhoto = collectionRepository.findById(idCollection);
        Optional<Photo> photo = this.photoRepository.findById(idPhoto);
        if(collectionPhoto.isPresent() && photo.isPresent()){
            collectionPhoto.get().getPhotoSet().add(photo.get());
              collectionRepository.save(collectionPhoto.get());
        }

        return "save";
    }
}
