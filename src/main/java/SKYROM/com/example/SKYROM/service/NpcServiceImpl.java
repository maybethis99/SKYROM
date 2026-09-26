package SKYROM.com.example.SKYROM.service;

import SKYROM.com.example.SKYROM.entity.DTO.Npc;
import SKYROM.com.example.SKYROM.entity.DTO.NpcSearchDto;
import SKYROM.com.example.SKYROM.entity.response.ApiResponse;
import SKYROM.com.example.SKYROM.entity.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import SKYROM.com.example.SKYROM.mappers.NpcMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import SKYROM.com.example.SKYROM.repository.NpcRepository;
import SKYROM.com.example.SKYROM.utils.NpcFactory;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements Npcservice {

    private final NpcRepository npcRepository;
    private final NpcMapper npcMapper;

    @Override
    public ApiResponse<PaginationResponse<NpcSearchDto>> findAll(Pageable pageable) {
        Page<NpcSearchDto> npcs = npcRepository.findAll(pageable).map(npcMapper::toSearchDto);

        return ApiResponse.ok(new PaginationResponse<>(
                npcs.getContent(),
                new PaginationResponse.Pagination(
                        npcs.getTotalElements(),
                        pageable.getPageSize(),
                        npcs.getNumber() + 1,
                        npcs.getTotalPages()
                )
        ));
    }

    @Override
    public Npc findById(Integer id) {
        return null;
    }

    @Override
    public Npc findByName(String name) {
        return null;
    }

}