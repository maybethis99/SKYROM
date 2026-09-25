package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.NpcRepository;
import service.NpcServiceImpl;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${end.point.npc}")
public class NpcController  {

    private final NpcRepository npcRepository;
    private final NpcServiceImpl npcServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<Void> getAll() {
        log.trace("getAll()");
        npcServiceImpl.findAll();
        return ResponseEntity.ok().build();
    }
}
