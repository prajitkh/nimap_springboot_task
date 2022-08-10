package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.entity.UserRoleId;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.repository.UserRoleRepo;
import com.springbootproject.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private RoleReporsitory roleReporsitory;


	@Override
	public void editUserRole(AssignRole assignRole) {

		ArrayList<UserRoleEntity>roles=new ArrayList<>();
		User user= this.userRepo.findByEmail(assignRole.getEmail());
		RoleEntity role = roleReporsitory.findByName(assignRole.getRoleName());
		UserRoleId uri = new UserRoleId(user, role);
		UserRoleEntity ure = new UserRoleEntity();

		ure.setTask(uri);
		roles.add(ure);
		userRoleRepo.saveAll(roles);


	}


	@Override
	public List<UserRoleEntity> getAllUserRole(UserRoleEntity userRoleEntity) {
	List<UserRoleEntity> roleEntity= this.userRoleRepo.findAll();
		return roleEntity;
	}


}


///for simple way ---only show userid roleId
//	public User  userToRole(List<Integer> roleId, int id) {
//		User  user=this.userRepo.findById(id).orElseThrow();
//		System.out.println(user.getRoles());
//		for (Integer ids : roleId) {
//			Optional<RoleEntity> entity=roleRepository.findById(ids);
//			RoleEntity roleEntity=entity.get();
//
//
//			user.getRoles().add(roleEntity);
//		}
//
//		return userRepo.save(user);
//
//	}









