package SKYROM.com.example.SKYROM.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SKYROM.com.example.SKYROM.entity.DTO.Npc;
import SKYROM.com.example.SKYROM.entity.entities.NpcEntity;

@Repository
public interface NpcRepository extends JpaRepository<NpcEntity, UUID>, JpaSpecificationExecutor<Npc> {

    Page<NpcEntity> findAll(Pageable pageable);

    @Override
    public default Optional<NpcEntity> findById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public default Optional<Npc> findOne(Specification<Npc> spec) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   @Query(value = "SELECT * FROM npc ORDER BY random() LIMIT 1", nativeQuery = true)
    Optional<Npc> findRandom();

    
}
