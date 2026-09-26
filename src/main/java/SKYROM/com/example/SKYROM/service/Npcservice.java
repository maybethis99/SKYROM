package SKYROM.com.example.SKYROM.service;

import SKYROM.com.example.SKYROM.entity.DTO.Npc;
import SKYROM.com.example.SKYROM.entity.DTO.NpcSearchDto;
import SKYROM.com.example.SKYROM.entity.response.ApiResponse;
import SKYROM.com.example.SKYROM.entity.response.PaginationResponse;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public interface Npcservice {

    public ApiResponse<PaginationResponse<NpcSearchDto>> findAll(Pageable pageable);

    public Npc findById(Integer id);

    public Npc findByName(String name);
}
