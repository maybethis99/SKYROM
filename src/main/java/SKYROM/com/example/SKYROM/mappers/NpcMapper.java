package mappers;
import entity.DTO.Npc;
import entity.DTO.NpcSearchDto;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface NpcMapper {
    NpcSearchDto toDto(Npc npc);
    Npc toEntity(NpcSearchDto dto);

    NpcSearchDto toSearchDto(Npc npc);
}
