package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.IPermissionIdList;
import com.springbootproject.dto.RoleIdListDto;
import com.springbootproject.entity.AssignPermission;
import com.springbootproject.entity.PermissionEntity;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.RolePermissionEntity;
import com.springbootproject.entity.RolePermissionId;
import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.repository.PermissionRepository;
import com.springbootproject.repository.RolePermissionRepo;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRoleRepo;
import com.springbootproject.service.RolePermissionService;

@Service
public class RolePermissionImpl  implements RolePermissionService{


	@Autowired
	private RoleReporsitory roleReporsitory;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private RolePermissionRepo rolePermissionRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Override
	public void addPermissionToRole(AssignPermission assignPermission) {
		ArrayList<RolePermissionEntity>list =new ArrayList<>();
		RoleEntity roleEntity=this.roleReporsitory.findById(assignPermission.getRoleId()).get();
		PermissionEntity permissionEntity=this.permissionRepository.findById(assignPermission.getPerId()).get();
		RolePermissionEntity permissionEntity2=new RolePermissionEntity();
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity, permissionEntity);
		permissionEntity2.setPk(rolePermissionId);
		list.add(permissionEntity2);
		this.rolePermissionRepo.saveAll(list);


	}


	@Override
	public List<RolePermissionEntity> getAllRolePermission() {

		return rolePermissionRepo.findAll();
	}

	@Override
	public  ArrayList<String> getPermissionByUserId(Integer userId){
		//ArrayList<RoleIdListDto>roleIdListDtos=this.userRoleRepo.findByTaskUserId(userId, RoleIdListDto.class);
		ArrayList<UserRoleEntity>roleIdListDtos=this.userRoleRepo.getRoleOfUser(userId);
		System.out.println("check roleslist"+roleIdListDtos);
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=0; i< roleIdListDtos.size(); i++) {
			list.add(roleIdListDtos.get(i).getTask().getRole().getId());
		}

		List<IPermissionIdList> rolesPermission = this.rolePermissionRepo.findPkPermissionByPkRoleIdIn(list, IPermissionIdList.class);
		ArrayList<String> permissions = new ArrayList<>();
System.out.println("permission1223"+permissions);
		for (IPermissionIdList element : rolesPermission) {

			permissions.add(element.getPkPermissionActionName());
			System.out.println("permission1223"+permissions);

		}
		System.out.println("permission"+ permissions);
		return permissions;

	}


}

