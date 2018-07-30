package com.recruitmentPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recruitmentPortal.modal.Applicant;
import com.recruitmentPortal.modal.Job;
import com.recruitmentPortal.repository.JobRepository;
import com.recruitmentPortal.service.ApplicantService;
import com.recruitmentPortal.service.JobService;

@RestController
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="jobs/{jobId}/apply")
	public void applyJob(@PathVariable String jobId, @RequestBody Applicant applicant) {
		//Job job = new Job();
		Job job = jobRepository.findOne(jobId);
		applicant.setJob(job);
		applicantService.applyJob(applicant);
	}
	
	@RequestMapping("jobs/{jobId}/applications/{id}")
	public Applicant getApplication(@PathVariable String id) {
		return applicantService.getApplication(id);
	}
	 
	@RequestMapping(method=RequestMethod.PUT, value="jobs/{jobId}/applications/{id}")
	public void updateApplication(@PathVariable String id,@RequestBody Applicant applicant) {
		applicantService.updateApplication(applicant);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="jobs/{jobId}/applications/{id}")
	public void deleteApplication(@PathVariable String id) {
		applicantService.deleteApplication(id);
	}
}
