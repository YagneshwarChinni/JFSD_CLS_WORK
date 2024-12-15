package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public String addstudent(Student s) {
		repository.save(s);
		return "Student added successfully";
	}

	@Override
	public String updatestudent(Student s) {
		// TODO Auto-generated method stub
		Optional<Student> obj = repository.findById(s.getId());
		if (obj.isPresent()) {
			Student st = obj.get();
			st.setName(s.getName()); 
			st.setAge(s.getAge());
			st.setContact(s.getContact());
			st.setDepartment(s.getDepartment());
			st.setGender(s.getGender());
			st.setEmail(s.getEmail());

			repository.save(st);
			return "Student details updated succesfully..!";
		} else
			return "Oops..student not found";

	}

	@Override
	public String deletestudent(int sid) {
		// TODO Auto-generated method stub
		Optional<Student> object = repository.findById(sid);
		String msg = null;
		if (object.isPresent()) {
			Student s = object.get();
			repository.delete(s);
			msg = "Student deleted successfully";
		} else {
			msg = "Student ID Not Found";
		}
		return msg;
	}

	@Override
	public Student viewstudetnbyid(int sid) {
		// TODO Auto-generated method stub

		return repository.findById(sid).get();
	}

	@Override
	public List<Student> viewallstudents() {
		return (List<Student>) repository.findAll();
	}

}
