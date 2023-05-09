package com.example.hopitalweb;

import com.example.hopitalweb.entities.Patient;
import com.example.hopitalweb.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
@SpringBootApplication

public class HopitalwebApplication implements CommandLineRunner {
    private PatientRepository patientRepository;

    public HopitalwebApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HopitalwebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Patient patient1 = Patient.builder()   //create objects using builder
                .id(null)
                .nom("meryem")
                .dateDeNaissance(new Date())
                .malade(true)
                .score(155645)
                .build();
        Patient patient2 = Patient.builder()   //create objects using builder
                .id(null)
                .nom("said")
                .dateDeNaissance(new Date())
                .malade(true)
                .score(1622)
                .build();
        Patient patient3 = Patient.builder()   //create objects using builder
                .id(null)
                .nom("ahmed")
                .dateDeNaissance(new Date())
                .malade(true)
                .score(185)
                .build();
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);*/


    }
}
