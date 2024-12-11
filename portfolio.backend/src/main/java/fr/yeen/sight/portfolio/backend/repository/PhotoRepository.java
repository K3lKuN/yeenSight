package fr.yeen.sight.portfolio.backend.repository;

import fr.yeen.sight.portfolio.backend.entity.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
