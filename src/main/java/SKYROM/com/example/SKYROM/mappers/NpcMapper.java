package SKYROM.com.example.SKYROM.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import SKYROM.com.example.SKYROM.entity.DTO.Npc;
import SKYROM.com.example.SKYROM.entity.DTO.NpcSearchDto;
import SKYROM.com.example.SKYROM.entity.entities.NpcEntity;

@Mapper(componentModel="spring")
public interface NpcMapper {
    NpcSearchDto toDto(Npc npc);
    
    @Mapping(target = "id", ignore = true)
    NpcEntity toEntity(Npc npc);


    NpcSearchDto toSearchDto(NpcEntity npc);
}
