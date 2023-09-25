//interface
package com.amdocs.doctormanagement.dao;

import java.util.List;

import com.amdocs.doctormanagement.dao.pojos.Doctor;
import com.amdocs.doctormanagement.exception.DoctorNotFoundException;

 public interface DoctorDAO {
	
	int addDoctor(Doctor doctor);

	int deleteDoctor(int doctorId)throws DoctorNotFoundException;

	boolean updateDoctorFees(int doctorId, double fees)throws DoctorNotFoundException;

	List<Doctor> showAllDoctors();

	List<Doctor> searchBySpecialization(String specialization)throws DoctorNotFoundException;

	List<Doctor> searchByFeesAndShift(String availableShift)throws DoctorNotFoundException;

	int countDoctorsByShift(String availableShift) throws DoctorNotFoundException;

	
}
