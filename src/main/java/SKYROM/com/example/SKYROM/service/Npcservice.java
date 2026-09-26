package service;

import entity.DTO.Npc;
import entity.DTO.NpcSearchDto;
import entity.response.ApiResponse;
import entity.response.PaginationResponse;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public interface Npcservice {

    public ApiResponse<PaginationResponse<NpcSearchDto>> findAll(Pageable pageable);

    public Npc findById(Integer id);

    public Npc findByName(String name);
}
