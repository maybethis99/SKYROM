package SKYROM.com.example.SKYROM.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SKYROM.com.example.SKYROM.entity.DTO.NpcSearchDto;
import SKYROM.com.example.SKYROM.entity.response.ApiResponse;
import SKYROM.com.example.SKYROM.entity.response.PaginationResponse;
import SKYROM.com.example.SKYROM.mappers.NpcMapper;
import SKYROM.com.example.SKYROM.repository.NpcRepository;
import SKYROM.com.example.SKYROM.service.NpcServiceImpl;
import SKYROM.com.example.SKYROM.utils.NpcFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${end.point.npc}")
public class NpcController  {

    private final NpcRepository npcRepository;
    private final NpcServiceImpl npcServiceImpl;
    private final NpcMapper npcMapper;

    @GetMapping("${end.point.all}")
    public ResponseEntity<ApiResponse<PaginationResponse<NpcSearchDto>>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "20") int limit
    ) {
        log.trace("getAll()");
        return ResponseEntity.ok(npcServiceImpl.findAll(PageRequest.of(page, limit)));
    }

    @GetMapping("${end.point.create}")
    public ResponseEntity<Void> create() {
        log.trace("create()");
           var k = NpcFactory.createNpc();
           var j = npcMapper.toEntity(k);
           log.info("create(): k={}, j={}", k, j);
           log.info(j.getName(), " ", j.getLevel());
           npcRepository.save(j);
        return null;
    }
}
