package service;

import entity.DTO.Npc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.NpcRepository;
import utils.NpcFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements Npcservice{

    private final NpcRepository npcRepository;

    @Override
    public List<Npc> findAll() {
        return npcRepository.findAll();
    }

    @Override
    public Npc findById(Integer id) {
        return npcRepository.findById(id).orElse(null);
    }

    @Override
    public Npc findByName(String name) {
        return NpcFactory.createNpc();
    }
}
