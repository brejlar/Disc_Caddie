package com.github.brejlar.jdbc.dao.disc;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.brejlar.model.Disc;
import com.github.brejlar.model.DiscStyle;

@Configuration
public class DiscRepositoryInitializer {

	@Bean
	public CommandLineRunner discRepoInit(DiscRepository discRepository) {
		Disc claymore = new Disc();
		Disc gauntlet = new Disc();
		Disc enforcer = new Disc();
		
		claymore.setBrand("Latitude 64");
		claymore.setDescriptionText("claymore text");
		claymore.setDiscId(12L);
		claymore.setModel("Claymore");
		claymore.setOwnerId("user0");
		claymore.setWeight(175);
		claymore.setStyle("Mid Range");
		
		gauntlet.setBrand("Dynamic Discs");
		gauntlet.setDescriptionText("Gauntlet text");
		gauntlet.setDiscId(12L);
		gauntlet.setModel("Gauntlet");
		gauntlet.setOwnerId("user0");
		gauntlet.setWeight(174);
		gauntlet.setStyle("Putter");

		enforcer.setBrand("Dynamic Discs");
		enforcer.setDescriptionText("enforcer text");
		enforcer.setDiscId(12L);
		enforcer.setModel("Enforcer");
		enforcer.setOwnerId("user0");
		enforcer.setWeight(175);
		enforcer.setStyle("Distance Driver");
		
		discRepository.save(gauntlet);
		discRepository.save(claymore);
		discRepository.save(enforcer);
		
		for(Disc disc : discRepository.findAll()) {
			LoggerFactory.getLogger(DiscRepositoryInitializer.class).info("Inserted " + disc);	
		}
		
		
		return null;
	}
}
