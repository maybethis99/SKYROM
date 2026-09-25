package repository;

import entity.DTO.Npc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NpcRepository extends JpaRepository<Npc,Integer>, JpaSpecificationExecutor<Npc> {

    @Override
    List<Npc> findAll();

    @Override
    Optional<Npc> findById(Integer integer);

    @Override
    Npc save(Npc npc);

    @Override
    void deleteById(Integer integer);
}
