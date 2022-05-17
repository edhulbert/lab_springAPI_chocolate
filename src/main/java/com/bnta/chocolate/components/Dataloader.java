package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("Rabot Estate", "St Lucia");
        estateRepository.save(estate1);

        Estate estate2 = new Estate("Maui Ku'ia","USA");
        estateRepository.save(estate2);

        Chocolate chocolate1 = new Chocolate("Marcial", 70 ,estate1);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("Dark Chocolate",70,estate2);
        chocolateRepository.save(chocolate2);

        Chocolate chocolate3 = new Chocolate("Maui Mokka Cappuccino",55,estate2);
        chocolateRepository.save(chocolate3);
    }
}
