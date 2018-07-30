package com.recruitmentPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recruitmentPortal.modal.Job;
import com.recruitmentPortal.service.JobService;

@RestController
public class JobController {

	@Autowired
	private JobService jobService;
	
	@RequestMapping("/jobs")
	public List<Job> getAllJobd(){
		return jobService.getAllJobs();
	}
	
	@RequestMapping("/jobs/{id}")
	public Job getJob(@PathVariable String id) {
		return jobService.getJob(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/jobs")
	public void addJob(@RequestBody Job job) {
		jobService.addJob(job);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/jobs/{id}")
	public void updateJob(@RequestBody Job job, @PathVariable String id) {
		jobService.updateJob(job, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/jobs/{id}")
	public void deleteJob(@PathVariable String id) {
		jobService.deleteJob(id);
	}
	  
}
