package com.recruitmentPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentPortal.modal.Applicant;
import com.recruitmentPortal.repository.ApplicantRepository;

@Service	//Marks as Business service
public class ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;

	public void applyJob(Applicant applicant) {
		applicantRepository.save(applicant);
	}

	public Applicant getApplication(String id) {
		return applicantRepository.findOne(id);
	}

	public void updateApplication(Applicant applicant) {
		applicantRepository.save(applicant);
	}
	
	public void deleteApplication(String id) {
		applicantRepository.delete(id);
	}
}
