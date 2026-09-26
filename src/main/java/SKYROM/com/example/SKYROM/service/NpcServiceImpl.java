package service;

import entity.DTO.Npc;
import entity.DTO.NpcSearchDto;
import entity.response.ApiResponse;
import entity.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import mappers.NpcMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.NpcRepository;
import utils.NpcFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements Npcservice{

    private final NpcRepository npcRepository;
    private final NpcMapper npcMapper;

    @Override
    public ApiResponse<PaginationResponse<NpcSearchDto>> findAll(Pageable pageable) {
        Page<NpcSearchDto> npcs = npcRepository.findAllByDeletedFalse(pageable).map(npcMapper::toSearchDto);

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
        return npcRepository.findById(id).orElse(null);
    }

    @Override
    public Npc findByName(String name) {
        return NpcFactory.createNpc();
    }
}
