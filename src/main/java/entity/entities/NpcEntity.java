package entity.entities;

import entity.enums.CharacterClass;
import entity.enums.Gender;
import entity.enums.Race;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class NpcEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(orphanRemoval = true, mappedBy = "npc")
    private Map<String, Integer> skills;
    @OneToMany(orphanRemoval = true, mappedBy = "npc")
    private List<String> spells;
    @OneToMany(orphanRemoval = true, mappedBy = "npc")
    private List<String> perks;
    @OneToMany(orphanRemoval = true, mappedBy = "npc")
    private List<String> inventory;


}
