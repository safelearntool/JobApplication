package com.fspring.JobApplication.Job.Impl;

import com.fspring.JobApplication.Job.Job;
import com.fspring.JobApplication.Job.JobRepository;
import com.fspring.JobApplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    //private Long nextId = 1L;

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        //return jobs;
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        //jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobId(Long id) {
//        for(Job j: jobs){
//            if(j.getId().equals(id)){
//                return j;
//            }
//        }
//        return null;
         return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while(iterator.hasNext()){
//            Job j = iterator.next();
//            if(j.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
//        for(Job j: jobs){
//            if(j.getId().equals(id)){
//                j.setTitle(updatedJob.getTitle());
//                j.setDescription(updatedJob.getDescription());
//                j.setMinSalary(updatedJob.getMinSalary());
//                j.setMaxSalary(updatedJob.getMaxSalary());
//                j.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;

            }
        return false;
    }
}
