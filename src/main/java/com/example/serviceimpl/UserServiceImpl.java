//package com.example.serviceimpl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.example.model.User;
//import com.example.repository.UserRepository;
//import com.example.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService{
//	
//	
//	
//	private UserRepository userRepository;
//	
//	public UserServiceImpl(UserRepository userRepository) {
//		
//		this.userRepository=userRepository;
//	}
//
//	@Override
//	public User createUser(User user) {
//		User ur=userRepository.save(user);
//		return ur;
//	}
//
//	@Override
//	public User getById(Long id) {
//		User ur=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User doesn't exists at this ID"));
//		return ur;
//	}
//
//	@Override
//	public List<User> getAll() {
//		List<User> users=userRepository.findAll();
//		return users;
//	}
//	
//	@Override
//	public void deleteById(Long id) {
//		userRepository.deleteById(id);
//		
//	}
//
//	@Override
//	public User updateById(Long id,User us) {
//		User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User doesn't exists"));
//		if(user!=null) {
//			if(us.getEmail()!=null) {
//				user.setEmail(us.getEmail());
//			}
//			
//			if(us.getEmail()!=null) {
//				user.setName(us.getName());
//			}
//			
//			if(us.getEmail()!=null) {
//				user.setPassword(us.getPassword());
//			}
//			
//			if(us.getEmail()!=null) {
//				user.setRole(us.getRole());
//			}
//			
//			
//			return userRepository.save(user);
//		}
//		return null;
//	}
//
//
//	
//	
//	
//
//}


package com.example.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository=userRepository;
	}

	@Override
	public User createUser(User user) {
		User ur=userRepository.save(user);
		return ur;
	}

	@Override
	public User getById(String email,String password) {
		User ur=userRepository.findByEmailAndPassword(email, password);
		return ur;
	}

	@Override
	public List<User> getAll() {
		List<User> users=userRepository.findAll();
		return users;
	}
	
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateById(Long id,User us) {
		User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User doesn't exists"));
		if(user!=null) {
			if(us.getEmail()!=null) {
				user.setEmail(us.getEmail());
			}
			
			if(us.getEmail()!=null) {
				user.setName(us.getName());
			}
			
			if(us.getEmail()!=null) {
				user.setPassword(us.getPassword());
			}
			
			if(us.getEmail()!=null) {
				user.setRole(us.getRole());
			}
			
			
			return userRepository.save(user);
		}
		return null;
	}


	
	
	

}

