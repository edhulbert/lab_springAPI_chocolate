package com.bnta.chocolate;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ChocolateApplicationTests {

	@Autowired
	ChocolateRepository chocolateRepository;

	@Autowired
	EstateRepository estateRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindChocolatesWithPercentageOver60() {
		List<Chocolate> found = chocolateRepository.findChocolateByCocoaPercentageGreaterThan(60);
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	public void canFindChocolatesWithPercentageOver50() {
		List<Chocolate> found = chocolateRepository.findChocolateByCocoaPercentageGreaterThan(50);
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindChocolatesWithPercentageAfterAddedTo() {
		Chocolate newChocolate = new Chocolate("Super Dark", 80 ,estateRepository.getById(1L));
		chocolateRepository.save(newChocolate);
		List<Chocolate> found = chocolateRepository.findChocolateByCocoaPercentageGreaterThan(75);
		assertThat(found.size()).isEqualTo(1);
	}
	
}
