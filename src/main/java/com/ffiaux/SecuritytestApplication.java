package com.ffiaux;

import com.ffiaux.model.User;
import com.ffiaux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuritytestApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecuritytestApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		userRepository.deleteAll();
		userRepository.save(new User("ffiaux", "ffiaux", "Fernando", "Fiaux"));
		userRepository.save(new User("hedwards", "hedwards", "Honey", "Edwards"));
		userRepository.save(new User("sturner", "sturner", "Sydney", "Turner"));
		userRepository.save(new User("hsteward", "hsteward", "Harold", "Stewart"));
	}
}
