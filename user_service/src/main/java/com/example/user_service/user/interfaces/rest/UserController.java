package com.example.user_service.user.interfaces.rest;

import com.example.user_service.user.domain.model.aggregates.User;
import com.example.user_service.user.domain.model.querys.GetUserById;
import com.example.user_service.user.domain.services.UserCommandService;
import com.example.user_service.user.domain.services.UserQueryService;
import com.example.user_service.user.interfaces.rest.resource.CreateUserResource;
import com.example.user_service.user.interfaces.rest.resource.LoginResource;
import com.example.user_service.user.interfaces.rest.resource.UserResource;
import com.example.user_service.user.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.example.user_service.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "Users", description = "Users")
public class UserController {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService=userCommandService;
        this.userQueryService=userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource>createUser(@RequestBody CreateUserResource createUserResource){
        var createUserCommand= CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);
        var userId=userCommandService.handle(createUserCommand);
        if(userId==0L) return ResponseEntity.badRequest().build();
        var getUserByIdQuery=new GetUserById(userId);
        var user= userQueryService.handle(getUserByIdQuery);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        var userResource= UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResource> login (@RequestBody LoginResource loginResource){
        var user = userQueryService.getByEmailAndPassword(loginResource.email(), loginResource.password());
        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserResource>getUserById(@PathVariable Long userId){
        var getUserIdQuery=new GetUserById(userId);
        var user= userQueryService.handle(getUserIdQuery);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userResource=UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @GetMapping
    public List<User> getAll(){return userQueryService.getAllUsers();}
}
