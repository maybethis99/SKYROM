package service;

import entity.DTO.Npc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Npcservice {

    public List<Npc> findAll();

    public Npc findById(Integer id);

    public Npc findByName(String name);
}
