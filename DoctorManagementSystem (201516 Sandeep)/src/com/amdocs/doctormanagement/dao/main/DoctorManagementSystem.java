package com.amdocs.doctormanagement.dao.main;


import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import com.amdocs.doctormanagement.dao.DoctorDAO;
import com.amdocs.doctormanagement.dao.DoctorDAOImpl;
import com.amdocs.doctormanagement.dao.pojos.Doctor;
import com.amdocs.doctormanagement.exception.DoctorNotFoundException;



public class DoctorManagementSystem {
    
    public static void main(String[] args) throws DoctorNotFoundException {
        List<Doctor> doctors = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DoctorDAO dao=new DoctorDAOImpl();
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add new doctor");
            System.out.println("2. Update doctor fees");
            System.out.println("3. Delete doctor");
            System.out.println("4. View all doctors");
            System.out.println("5. Find doctor by specialization");
            System.out.println("6. Find doctors who’s fees is less than all doctors of given shift");
            System.out.println("7. Count number of doctors by shift");
            System.out.println("8. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    // Input doctor details and add a new doctor
                    System.out.println("Enter doctor name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter specialization:");
                    String specialization = scanner.nextLine();
                    System.out.println("Enter fees:");
                    double fees = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter shift (morning/evening):");
                    String shift = scanner.nextLine();
                    Doctor newDoctor = new Doctor(name,specialization, fees, shift);
                    dao.addDoctor(newDoctor);
                    System.out.println("Doctor added successfully.");
                    break;

                case 2:
                    // Update doctor fees
                    System.out.println("Enter doctor ID to update fees:");
                    int idToUpdate = scanner.nextInt();
                    boolean doctorFound = false;
                    
                    for (Doctor doctor : doctors) {
                        if (doctor.getId() == idToUpdate) {
                        	
                        	  System.out.println("Enter new fees:");
                              double newFees = scanner.nextDouble();
                              scanner.nextLine(); // Consume the newline character
                              dao.updateDoctorFees(idToUpdate, newFees);
                              System.out.println("Doctor fees updated successfully.");
                              break;
                        }
                    }

                    if (!doctorFound) {
                        System.out.println("No doctor with ID " + idToUpdate + " found.");
                        break;
                    }
                  

                case 3:
                    // Delete doctor
                    System.out.println("Enter doctor ID to delete:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    dao.deleteDoctor(idToDelete);
                    System.out.println("Doctor deleted successfully.");
                    break;

                case 4:
                    // View all doctors
                    List<Doctor> allDoctors = dao.showAllDoctors();
                  
                  
                    for (Doctor doctor : allDoctors) {
                        System.out.println(doctor);
                    }
                    break;

                case 5:
                    // Find doctor by specialization
                    System.out.println("Enter specialization to search:");
                    String searchSpecialization = scanner.nextLine();
                    List<Doctor> doctorsBySpecialization = dao.searchBySpecialization(searchSpecialization);
                    if (doctorsBySpecialization.isEmpty()) {
                        System.out.println("Doctor not available.");
                    } else {
                        for (Doctor doctor : doctorsBySpecialization) {
                            System.out.println(doctor);
                        }
                    }
                    break;

                case 6:
                    // Find doctors with lower fees by shift
                    System.out.println("Enter shift to search (morning/evening):");
                    String searchShift = scanner.nextLine();
                    List<Doctor> doctorsWithLowerFees = dao.searchByFeesAndShift(searchShift);
                    if (doctorsWithLowerFees.isEmpty()) {
                        System.out.println("No doctors with lower fees found.");
                    } else {
                        System.out.println("Doctors with lower fees:");
                        for (Doctor doctor : doctorsWithLowerFees) {
                            System.out.println(doctor);
                        }
                    }
                    break;

                case 7:
                    // Count number of doctors by shift
                    System.out.println("Enter shift to count (morning/evening):");
                    String countShift = scanner.nextLine();
                    int count = dao.countDoctorsByShift(countShift);
                    System.out.println("Number of doctors in " + countShift + " shift: " + count);
                    break;

                case 8:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
