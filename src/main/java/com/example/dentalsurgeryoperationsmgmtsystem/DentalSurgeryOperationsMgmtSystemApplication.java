package com.example.dentalsurgeryoperationsmgmtsystem;

import com.example.dentalsurgeryoperationsmgmtsystem.model.*;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.AppointmentRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.DentistRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.PatientRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.repository.SurgeryRepository;
import com.example.dentalsurgeryoperationsmgmtsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DentalSurgeryOperationsMgmtSystemApplication implements CommandLineRunner {
	private AddressService addressService;
	private DentistRepository dentistRepository;
	private PatientRepository patientRepository;
	private SurgeryRepository surgeryRepository;
	private AppointmentRepository appointmentRepository;

	public DentalSurgeryOperationsMgmtSystemApplication(AddressService addressService, DentistRepository dentistRepository, PatientRepository patientRepository, SurgeryRepository surgeryRepository, AppointmentRepository appointmentRepository) {
		this.addressService = addressService;
		this.dentistRepository = dentistRepository;
		this.patientRepository = patientRepository;
		this.surgeryRepository = surgeryRepository;
		this.appointmentRepository = appointmentRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(DentalSurgeryOperationsMgmtSystemApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {

			var address1 = new Address(1, "100N 4th street", "Fairfield", "IA", 52557);
			addressService.addAddress(address1);
			var address2 = new Address(2, "200N 5th street", "Austin", "TX", 52558);
			addressService.addAddress(address2);
			var address3 = new Address(3, "300N 6th street", "Chicago", "IL", 52559);
			addressService.addAddress(address3);
			var address4 = new Address(4, "400N 7th street", "Lax", "VA", 52560);
			addressService.addAddress(address4);

			//Patients
			var gillian = new Patient(1L, "Gillian White", "2248445958", address1, null);
			patientRepository.save(gillian);
			var jill = new Patient(2L, "Jill Bell", "2248445959", address2, null);
			patientRepository.save(jill);
			var ian = new Patient(3L, "Ian MacKay", "2248445960", address3, null);
			patientRepository.save(ian);
			var john = new Patient(4L, "John Walker", "2248445961", address4, null);
			patientRepository.save(john);

			//dentists
			var tony = new Dentist(1L, "tony", "Eric", "224-833-5849", null);
			dentistRepository.save(tony);
			var helen = new Dentist(2L, "Helen", "Pearson", "224-833-5850", null);
			dentistRepository.save(helen);
			var robin = new Dentist(3L, "Robin", "Plevin", "224-833-5851", null);
			dentistRepository.save(robin);
			var alex = new Dentist(4L, "Alex", "Johnson", "224-833-5852", null);
			dentistRepository.save(alex);


			//Surgeries
			var S10 = new Surgery(1L, "S10", "23474774", "S10@gmail.com", address1, null);
			surgeryRepository.save(S10);
			var S11 = new Surgery(2L, "S11", "23474775", "S11@gmail.com", address2, null);
			surgeryRepository.save(S11);
			var S12 = new Surgery(3L, "S12", "23474776", "S12@gmail.com", address3, null);
			surgeryRepository.save(S12);
			var S13 = new Surgery(4L, "S13", "23474777", "S13@gmail.com", address4, null);
			surgeryRepository.save(S13);


			//Appointments
			var appointment1 = new Appointment(1L, "active", LocalDate.of(2023, 10, 14), gillian, tony, S10);
			appointmentRepository.save(appointment1);
			var appointment2 = new Appointment(2L, "Cancelled", LocalDate.of(2023, 10, 15), jill, helen, S11);
			appointmentRepository.save(appointment2);
			var appointment3 = new Appointment(3L, "Cancelled", LocalDate.of(2023, 10, 16), ian, robin, S12);
			appointmentRepository.save(appointment3);
			var appointment4 = new Appointment(4L, "active", LocalDate.of(2023, 10, 17), john, alex, S13);
			appointmentRepository.save(appointment4);

		}

}
