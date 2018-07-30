package com.recruitmentPortal.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Job {

	@Id
	//@GeneratedValue
	String jobId;
	String post, exp, location;
	@JsonManagedReference
	@OneToMany(targetEntity=Applicant.class,mappedBy="job",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Applicant> applicant;

	
	public List<Applicant> getApplicant() {
		return applicant;
	}
	public void setApplicant(List<Applicant> applicant) {
		this.applicant = applicant;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	

	
	
}
