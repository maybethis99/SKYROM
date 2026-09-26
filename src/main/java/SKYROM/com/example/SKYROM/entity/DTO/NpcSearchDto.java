package SKYROM.com.example.SKYROM.entity.DTO;

import java.io.Serializable;
import java.util.UUID;

import SKYROM.com.example.SKYROM.entity.enums.CharacterClass;
import SKYROM.com.example.SKYROM.entity.enums.Gender;
import SKYROM.com.example.SKYROM.entity.enums.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NpcSearchDto implements Serializable {
    private UUID id;
    private String name;
    private String title;
    private Race race;
    private Gender gender;
    private CharacterClass characterClass;
    private int level;
}
