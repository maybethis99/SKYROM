package SKYROM.com.example.SKYROM.entity.DTO;

import SKYROM.com.example.SKYROM.entity.enums.CharacterClass;
import SKYROM.com.example.SKYROM.entity.enums.Gender;
import SKYROM.com.example.SKYROM.entity.enums.Race;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
public record Npc(
        UUID id,
        String name,
        String title,

        Race race,
        Gender gender,
        CharacterClass characterClass,
        int level,
        int experience,

        int strength,
        int intelligence,
        int willpower,
        int agility,
        int speed,
        int endurance,
        int personality,
        int luck,

        int health,
        int healthMax,
        int magicka,
        int magickaMax,
        int stamina,
        int staminaMax,

        Map<String, Integer> skills,
        List<String> spells,
        List<String> perks,
        List<String> inventory,
        int gold
) implements Serializable {
}
