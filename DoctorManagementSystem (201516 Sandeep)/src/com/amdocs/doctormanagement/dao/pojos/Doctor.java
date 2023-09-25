package com.amdocs.doctormanagement.dao.pojos;


public class Doctor implements Comparable<Doctor>{
	
	private int doctorId;
	private String doctorName;
	
	private String specialization;
	private String availableShift;
	private double fees;
		
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Doctor( String doctorName,  String specialization,
			double fees , String availableShift) {
		super();
	
		this.doctorName = doctorName;
		
		this.specialization = specialization;
		this.availableShift = availableShift;
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName +
			 ", specialization=" + specialization + ", availableShift=" + availableShift + ", fees=" + fees + "]";
	}

	@Override
	public int compareTo(Doctor o) {
		// TODO Auto-generated method stub
		return this.doctorName.compareTo(o.doctorName);
	}

	public int getId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getShift() {
		return availableShift;
	}

	public void setAvailableShift(String availableShift) {
		this.availableShift = availableShift;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	

	
}
