package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.NpcRepository;
import service.NpcServiceImpl;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${end.point.npc}")
public class NpcController  {

    private final NpcRepository npcRepository;
    private final NpcServiceImpl npcServiceImpl;

    @GetMapping("${end.point.all}")
    public ResponseEntity<Void> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "20") int limit
    ) {
        log.trace("getAll()");
        npcServiceImpl.findAll(PageRequest.of(page, limit));
        return ResponseEntity.ok().build();
    }
}
