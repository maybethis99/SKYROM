-- V1__create_npc_table.sql
-- PostgreSQL

CREATE TABLE npc
(
    id                UUID PRIMARY KEY,

    name              VARCHAR(255)             NOT NULL,
    title             VARCHAR(255),

    race              VARCHAR(32)              NOT NULL,
    gender            VARCHAR(32)              NOT NULL,
    character_class   VARCHAR(32)              NOT NULL,

    level             INTEGER                  NOT NULL DEFAULT 1,
    experience        INTEGER                  NOT NULL DEFAULT 0,

    strength          INTEGER                  NOT NULL DEFAULT 10,
    intelligence      INTEGER                  NOT NULL DEFAULT 10,
    willpower         INTEGER                  NOT NULL DEFAULT 10,
    agility           INTEGER                  NOT NULL DEFAULT 10,
    speed             INTEGER                  NOT NULL DEFAULT 10,
    endurance         INTEGER                  NOT NULL DEFAULT 10,
    personality       INTEGER                  NOT NULL DEFAULT 10,
    luck              INTEGER                  NOT NULL DEFAULT 10,

    health            INTEGER                  NOT NULL DEFAULT 0,
    health_max        INTEGER                  NOT NULL DEFAULT 0,
    magicka           INTEGER                  NOT NULL DEFAULT 0,
    magicka_max       INTEGER                  NOT NULL DEFAULT 0,
    stamina           INTEGER                  NOT NULL DEFAULT 0,
    stamina_max       INTEGER                  NOT NULL DEFAULT 0,

    skills            JSONB                    NOT NULL DEFAULT '{}'::jsonb,
    spells            JSONB                    NOT NULL DEFAULT '[]'::jsonb,
    perks             JSONB                    NOT NULL DEFAULT '[]'::jsonb,
    inventory         JSONB                    NOT NULL DEFAULT '[]'::jsonb,
    gold              INTEGER                  NOT NULL DEFAULT 0,

    -- диапазоны характеристик
    CONSTRAINT chk_npc_level        CHECK (level >= 1),
    CONSTRAINT chk_npc_experience   CHECK (experience >= 0),
    CONSTRAINT chk_npc_gold         CHECK (gold >= 0),

    CONSTRAINT chk_npc_strength     CHECK (strength     BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_intelligence CHECK (intelligence BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_willpower    CHECK (willpower    BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_agility      CHECK (agility      BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_speed        CHECK (speed        BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_endurance    CHECK (endurance    BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_personality  CHECK (personality  BETWEEN 0 AND 1000),
    CONSTRAINT chk_npc_luck         CHECK (luck         BETWEEN 0 AND 1000),

    -- текущее значение не больше максимума
    CONSTRAINT chk_npc_health  CHECK (health  BETWEEN 0 AND health_max),
    CONSTRAINT chk_npc_magicka CHECK (magicka BETWEEN 0 AND magicka_max),
    CONSTRAINT chk_npc_stamina CHECK (stamina BETWEEN 0 AND stamina_max),

    CONSTRAINT chk_npc_health_max  CHECK (health_max  >= 0),
    CONSTRAINT chk_npc_magicka_max CHECK (magicka_max >= 0),
    CONSTRAINT chk_npc_stamina_max CHECK (stamina_max >= 0)

);

CREATE INDEX idx_npc_name            ON npc (name);
CREATE INDEX idx_npc_race            ON npc (race);
CREATE INDEX idx_npc_gender          ON npc (gender);
CREATE INDEX idx_npc_character_class ON npc (character_class);
CREATE INDEX idx_npc_level           ON npc (level);

-- GIN-индексы, если планируешь искать по содержимому
CREATE INDEX idx_npc_skills_gin    ON npc USING GIN (skills);
CREATE INDEX idx_npc_spells_gin    ON npc USING GIN (spells);
CREATE INDEX idx_npc_perks_gin     ON npc USING GIN (perks);
CREATE INDEX idx_npc_inventory_gin ON npc USING GIN (inventory);