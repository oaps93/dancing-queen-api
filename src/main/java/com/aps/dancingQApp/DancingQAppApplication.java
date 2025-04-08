package com.aps.dancingQApp;

import com.aps.dancingQApp.Exceptions.DClassException;
import com.aps.dancingQApp.Exceptions.InstructorException;
import com.aps.dancingQApp.Model.DClass;
import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Service.DClassService;
import com.aps.dancingQApp.Service.InstructorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@SpringBootApplication
public class DancingQAppApplication implements CommandLineRunner {

	@Autowired
	InstructorService instructorService;
	@Autowired
	DClassService dClassService;

	public static void main(String[] args) {
		SpringApplication.run(DancingQAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*DClass firstDClass = DClass.builder()
				.className("Contempo")
				.level("Fresher")
				.build();

		try {
			DClass dClass = dClassService.newDClass(firstDClass);

			*//*Set<DClass> dClasses = new CopyOnWriteArraySet<>();
			dClasses.add(dClass);

			Instructor firstInstructor = Instructor.builder()
					.name("Alfonso")
					.age("32")
					.classes(dClasses)
					.build();

			instructorService.newInstructor(firstInstructor);*//*
			
		*//*} catch (InstructorException e) {
			throw new RuntimeException(e);*//*
		} catch (DClassException e) {
			throw new RuntimeException(e);
		}*/

	}
}
