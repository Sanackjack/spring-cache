package com.example.springcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;

@Service
public class StudentService {
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("neww");
		return new Student(id,"Sajal" ,"V");
		
	}

	@CacheEvict(value = "student", allEntries = true)
	public void evictAllCacheValues() {}
}
