package entity.DTO;

import entity.enums.CharacterClass;
import entity.enums.Gender;
import entity.enums.Race;
import lombok.Builder;

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
        Integer level,
        Integer experience,

        Integer strength,
        Integer intelligence,
        Integer willpower,
        Integer agility,
        Integer speed,
        Integer endurance,
        Integer personality,
        Integer luck,

        Integer health,
        Integer healthMax,
        Integer magicka,
        Integer magickaMax,
        Integer stamina,
        Integer staminaMax,

        Map<String, Integer> skills,
        List<String> spells,
        List<String> perks,
        List<String> inventory,
        Integer gold
) {}
