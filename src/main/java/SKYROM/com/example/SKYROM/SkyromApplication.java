package SKYROM.com.example.SKYROM;

import entity.DTO.Npc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import utils.NpcFactory;

import java.util.ArrayList;

@Slf4j
@SpringBootApplication
public class SkyromApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyromApplication.class, args);
	}

	@Bean
	public String create() {
		ArrayList<Npc> npcs = new ArrayList<Npc>();

		for (int i = 1; i <= 10; i++) {
			NpcFactory.createNpc();
		}
		for(Npc npc : npcs) {
			log.info(npc.name());
		}
		return "";
	}

}
