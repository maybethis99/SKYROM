package SKYROM.com.example.SKYROM.utils;

import java.util.Optional;

import SKYROM.com.example.SKYROM.entity.DTO.Npc;
import SKYROM.com.example.SKYROM.repository.NpcRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
public class DoThings {

    private final NpcRepository npcRepository;

    public Optional<Npc> getRandomNpc() {
        var npc =npcRepository.findRandom();
        return npc;
    }
    
}
