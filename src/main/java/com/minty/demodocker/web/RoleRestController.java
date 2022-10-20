package com.minty.demodocker.web;

import com.minty.demodocker.entities.Role;
import com.minty.demodocker.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleRestController {
    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @PostMapping("/roles")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.addRole(role), HttpStatus.CREATED);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }

    @GetMapping("/getRoleByRoleName/{roleName}")
    public ResponseEntity<Role> getRoleByRoleName(@PathVariable(name = "roleName") String roleName){
        return new ResponseEntity<>(roleService.getRoleByRoleName(roleName), HttpStatus.OK);
    }

    @PutMapping("/roles")
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.updateRole(role), HttpStatus.OK);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable(name = "id") Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoleList(){
        return new ResponseEntity<>(roleService.getRoleList(), HttpStatus.OK);
    }



}
