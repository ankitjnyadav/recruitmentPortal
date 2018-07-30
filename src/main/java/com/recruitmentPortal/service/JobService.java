package com.recruitmentPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentPortal.modal.Job;
import com.recruitmentPortal.repository.JobRepository;

@Service	//Marks as Business service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	
	public List<Job> getAllJobs(){
		List<Job> job= new ArrayList<>();
		jobRepository.findAll().forEach(job::add);
		return job;
	}

	public Job getJob(String id) {
		return jobRepository.findOne(id);
	}
	
	public void addJob(Job job) {
		jobRepository.save(job);
	}

	public void updateJob(Job job, String id) {
		jobRepository.save(job);
	}
	public void deleteJob(String id) {
		jobRepository.delete(id);
	}

}


