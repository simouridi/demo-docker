package com.minty.demodocker.service;

import com.minty.demodocker.entities.Role;
import com.minty.demodocker.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService = new RoleServiceImpl(roleRepository);


    @Test
    @DisplayName("Testing addRole")
    void addRoleTest() {
        Role roleRequest = Role.builder().roleName("TEST").build();
        Role roleResponse = Role.builder().roleId(1L).roleName("TEST").build();
        Mockito.when(roleRepository.save(any(Role.class))).thenReturn(roleResponse);
        Role target = roleService.addRole(roleRequest);
        Assertions.assertNotNull(target);
        Assertions.assertEquals(1L, target.getRoleId());
        Assertions.assertEquals("TEST", target.getRoleName());
    }

    @Test
    @DisplayName("Testing getRole")
    void getRoleTest() {
        Role roleResponse = Role.builder().roleId(1L).roleName("TEST").build();
        Mockito.when(roleRepository.findById(any(Long.class))).thenReturn(Optional.of(roleResponse));
        Role target = roleService.getRole(any(Long.class));
        Assertions.assertNotNull(target);
        Assertions.assertEquals(1L, target.getRoleId());
        Assertions.assertEquals("TEST", target.getRoleName());
    }

    @Test
    @DisplayName("Testing getRoleByRoleName")
    void getRoleByRoleNameTest() {
        
        Role roleResponse = Role.builder().roleId(1L).roleName("TEST").build();
        Mockito.when(roleRepository.findByRoleName(any(String.class))).thenReturn(Optional.of(roleResponse));
        Role target = roleService.getRoleByRoleName("Test");
        Assertions.assertNotNull(target);
        Assertions.assertEquals(1L, target.getRoleId());
        Assertions.assertEquals("TEST", target.getRoleName());
    }

    @Test
    @DisplayName("Testing ")
    void updateRoleTest() {
    }

    @Test
    @DisplayName("Testing ")
    void deleteRoleTest() {
    }

    @Test
    @DisplayName("Testing ")
    void getRoleListTest() {
    }
}