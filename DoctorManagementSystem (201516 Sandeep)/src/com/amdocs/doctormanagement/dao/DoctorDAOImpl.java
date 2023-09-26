//Implementation
package com.amdocs.doctormanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.doctormanagement.dao.pojos.Doctor;
import com.amdocs.doctormanagement.exception.DoctorNotFoundException;

public class DoctorDAOImpl implements DoctorDAO{
	
	 private static int nextDoctorId = 0;
	List<Doctor> doctorList=new ArrayList<>();

	@Override
	public int addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		++nextDoctorId;
		doctor.setDoctorId(nextDoctorId);
		doctorList.add(doctor);
		return doctor.getId();
	}

	@Override
	public int deleteDoctor(int doctorId) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		
		for(Doctor doctor:doctorList)
		{
			if(doctor.getId()==doctorId)
			{
				doctorList.remove(doctor);
				return 1;
			}			
		}
		return 0 ;
	}

	@Override
	public boolean updateDoctorFees(int doctorId, double fees)throws DoctorNotFoundException {
		for(Doctor doctor:doctorList)
		{
			if(doctor.getId()==doctorId)
			{				
				//doctorList.remove(doctor);
				int indexof=doctorList.indexOf(doctor);
				doctor.setFees(fees);
				doctorList.set(indexof, doctor);
				return true;
			}			
		}
		return false;
	}

	@Override
	public List<Doctor> showAllDoctors() {
		return doctorList;
	}

	@Override
	public List<Doctor> searchBySpecialization(String specialization)throws DoctorNotFoundException {
		List<Doctor> doctortempList=new ArrayList<>();
		for(Doctor doctor:doctorList)
		{
			if(doctor.getSpecialization().equals(specialization))
			{				
				doctortempList.add(doctor);
			}			
		}
		return doctortempList;
	}

	@Override
	public List<Doctor> searchByFeesAndShift(String availableShift) {
		List<Doctor> doctortempList=new ArrayList<>();
		for(Doctor doctor:doctorList)
		{
			if(doctor.getShift().equals(availableShift))
			{				
				doctortempList.add(doctor);
			}			
		}
		return doctortempList;
	}

	@Override
	public int countDoctorsByShift(String availableShift) throws DoctorNotFoundException{
		List<Doctor> doctortempList=new ArrayList<>();
		for(Doctor doctor:doctorList)
		{
			if(doctor.getShift().equals(availableShift))
			{				
				doctortempList.add(doctor);
			}			
		}
		
		return doctortempList.size();
	}

}
