package fr.yeen.sight.portfolio.backend.repository;

import fr.yeen.sight.portfolio.backend.entity.CollectionPhoto;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<CollectionPhoto, Integer> {
}
