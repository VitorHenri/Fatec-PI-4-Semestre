package com.SchoolSchedule.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SchoolSchedule.demo.entities.User;
import com.SchoolSchedule.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> op =userRepository.findById(id);
		return op.get();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id,User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
	}
	
	public void updateData(User entity,User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setFuncao(obj.getFuncao());
		entity.setRegistroEscolar(obj.getRegistroEscolar());
		entity.setSenha(entity.getSenha());
	}
	
}
