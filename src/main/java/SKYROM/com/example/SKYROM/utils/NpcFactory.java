package utils;

import com.github.javafaker.Faker;
import entity.DTO.Npc;
import entity.enums.CharacterClass;
import entity.enums.Gender;
import entity.enums.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NpcFactory {

    public static Npc createNpc() {
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String title = faker.funnyName().name();
        Race race = faker.options().option(Race.values());
        Gender gender = faker.options().option(Gender.values());
        CharacterClass characterClass = faker.options().option(CharacterClass.values());

        int level = faker.number().numberBetween(1, 100);
        int experience = faker.number().numberBetween(0, 100_000);

        int strength     = faker.number().numberBetween(1, 100);
        int intelligence = faker.number().numberBetween(1, 100);
        int willpower    = faker.number().numberBetween(1, 100);
        int agility      = faker.number().numberBetween(1, 100);
        int speed        = faker.number().numberBetween(1, 100);
        int endurance    = faker.number().numberBetween(1, 100);
        int personality  = faker.number().numberBetween(1, 100);
        int luck         = faker.number().numberBetween(1, 100);

        int healthMax   = 50 + endurance * 2;
        int magickaMax  = 50 + intelligence * 2;
        int staminaMax  = 50 + endurance * 2;

        int health  = faker.number().numberBetween(1, healthMax);
        int magicka = faker.number().numberBetween(0, magickaMax);
        int stamina = faker.number().numberBetween(0, staminaMax);

        Map<String, Integer> skills = new HashMap<>();
        int skillCount = faker.number().numberBetween(5, 10);
        for (int i = 0; i < skillCount; i++) {
            String skill = faker.options().option(
                    "Одноручное", "Двуручное", "Лук", "Разрушение",
                    "Восстановление", "Иллюзия", "Скрытность", "Взлом",
                    "Алхимия", "Кузнечное дело", "Зачарование"
            );
            skills.put(skill, faker.number().numberBetween(5, 100));
        }

        List<String> spells;
        if (faker.number().randomDouble(0, 1, 5) > 0) {
            faker.<String>options()
                    .option("Огненный шар", "Ледяной шип", "Исцеление", "Невидимость", "Свет");
            spells = List.of("Огненный шар", "Исцеление");
        } else {
            spells = List.of();
        }

        List<String> perks = List.of(
                faker.options().option("Стальные кулаки", "Ловкость", "Мастер клинка", "Пиромант")
        );

        List<String> inventory = List.of(
                faker.options().option("Меч", "Щит", "Зелье здоровья", "Факел", "Верёвка"),
                faker.options().option("Хлеб", "Сы р", "Мясо", "Яблоко")
        );

        int gold = faker.number().numberBetween(0, 10_000);

        return Npc.builder()
                .id(UUID.randomUUID())
                .name(name)
                .title(title)
                .race(race)
                .gender(gender)
                .characterClass(characterClass)
                .level(level)
                .experience(experience)

                .strength(strength)
                .intelligence(intelligence)
                .willpower(willpower)
                .agility(agility)
                .speed(speed)
                .endurance(endurance)
                .personality(personality)
                .luck(luck)

                .health(health)
                .healthMax(healthMax)
                .magicka(magicka)
                .magickaMax(magickaMax)
                .stamina(stamina)
                .staminaMax(staminaMax)

                .skills(skills)
                .spells(spells)
                .perks(perks)
                .inventory(inventory)
                .gold(gold)
                .build();
    }
}
