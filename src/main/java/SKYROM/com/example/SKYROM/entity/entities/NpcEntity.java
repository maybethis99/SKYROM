package SKYROM.com.example.SKYROM.entity.entities;

import SKYROM.com.example.SKYROM.entity.enums.CharacterClass;
import SKYROM.com.example.SKYROM.entity.enums.Gender;
import SKYROM.com.example.SKYROM.entity.enums.Race;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "npc")
@Getter
@Setter
public class NpcEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String title;

    @Enumerated(EnumType.STRING)
    private Race race;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClass characterClass;

    private int level;
    private int experience;

    private int strength;
    private int intelligence;
    private int willpower;
    private int agility;
    private int speed;
    private int endurance;
    private int personality;
    private int luck;

    private int health;
    private int healthMax;
    private int magicka;
    @Column(name = "magicka_max")
    private int magickaMax;
    private int stamina;
    @Column(name = "stamina_max")
    private int staminaMax;
    private int gold;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> skills;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> spells;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> perks;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> inventory;


}
