package com.app.SpringSecurityDemo;

import com.app.SpringSecurityDemo.persistence.entity.PermissionEntity;
import com.app.SpringSecurityDemo.persistence.entity.RoleEntity;
import com.app.SpringSecurityDemo.persistence.entity.RoleEnum;
import com.app.SpringSecurityDemo.persistence.entity.UserEntity;
import com.app.SpringSecurityDemo.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOP)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			/*CREATE USERS*/
			UserEntity userChris = UserEntity.builder()
					.username("chris")
					.password("$2a$10$TFwne3nYOvya7SPMKg7HC.3L2LP2BRoJAphbZuNywzdfgb8D0UEIq")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userJose = UserEntity.builder()
					.username("jose")
					.password("$2a$10$TFwne3nYOvya7SPMKg7HC.3L2LP2BRoJAphbZuNywzdfgb8D0UEIq")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userPedro = UserEntity.builder()
					.username("pedro")
					.password("$2a$10$TFwne3nYOvya7SPMKg7HC.3L2LP2BRoJAphbZuNywzdfgb8D0UEIq")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userAimy = UserEntity.builder()
					.username("aimy")
					.password("$2a$10$TFwne3nYOvya7SPMKg7HC.3L2LP2BRoJAphbZuNywzdfgb8D0UEIq")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userChris, userJose, userPedro, userAimy));
		};
	}
}
