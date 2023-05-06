package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Laptop;
import com.example.obrestdatajpa.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//crear Laptop

		Laptop laptop = new Laptop(null, "HP", "15-ef2514la", 2023, 350000.00, true);

		// guardar Laptop

		repository.save(laptop);

		// recuperar laptop

		System.out.println("numero de laptops en base " + repository.findAll().size());
	}

}
