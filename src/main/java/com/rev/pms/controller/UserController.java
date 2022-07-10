package com.rev.pms.controller;

import com.rev.pms.annonations.Authorized;
import com.rev.pms.dao.ProductDAO;
import com.rev.pms.model.Product;
import com.rev.pms.model.Role;
import com.rev.pms.model.User;
import com.rev.pms.services.AuthorizationService;
import com.rev.pms.services.ProductService;
import com.rev.pms.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    User user;

    @Autowired
    Product product;

    @Autowired
    UserService userService;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    private AuthorizationService authorizationService;

    boolean result;

    // Add user
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity = null;
        LOGGER.trace("TRACE - Save user started the execution");
        LOGGER.debug("DEBUG - Save user started the execution");
        LOGGER.info("INFO - Save user started the execution");
        LOGGER.warn("WARN - Save user started the execution");
        LOGGER.error("ERROR - Save user started the execution");

        if (userService.isUserExists(user.getUserId())) {
            LOGGER.warn("User with user id: "+user.getUserId()+ " already exists");
            responseEntity = new ResponseEntity<String>
                    ("Cannot save because user with user id :" + user.getUserId() + " already exists", HttpStatus.CONFLICT);   //409
        } else {
            result = userService.addUser(user);
            if (result) {
                responseEntity = new ResponseEntity<String>
                        ("Successfully Saved user ID: " + user.getUserId(), HttpStatus.OK);        //200
                LOGGER.info("User with user id: "+user.getUserId()+ " saved successfully");
            }
        }
        return responseEntity;
    }


    // Get all users
    @Authorized(allowedRoles = {Role.ADMIN})
    @GetMapping     //localhost:8082/users
    public ResponseEntity<List<User>> getUsers(){
        ResponseEntity responseEntity = null;
        List<User> users = new ArrayList<User>();
        users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // Get user by userId
    //@Authorized(allowedRoles = {Role.ADMIN})
    @GetMapping("{uId}")     //localhost:8082/users/{uId}
    public ResponseEntity<User> getUser(@PathVariable("uId") int userId) {
        System.out.println("Fetching details for user id  :" + userId);
        //call the methods to fetch user details of this user id
        ResponseEntity responseEntity = null;

        User user1 = new User();
        if (userService.isUserExists(userId)) {
            user1 = userService.getUser(userId);
            responseEntity = new ResponseEntity<User>(user1, HttpStatus.OK);   //409
        } else {
            responseEntity = new ResponseEntity<User>
                    (user1, HttpStatus.NO_CONTENT);        //204
        }

        return responseEntity;
    }
    //@Authorized(allowedRoles = {Role.ADMIN})
    @PutMapping             //localhost:8099/users, @PutMapping used for "Update"
    public ResponseEntity<String> updateUser(@RequestBody User user){
        ResponseEntity responseEntity = null;
        System.out.println("Updating details of :" + user);
        boolean result = userService.updateUser(user);
        responseEntity = new ResponseEntity<String>("Successfully updated your user: " + user.getUserId(), HttpStatus.OK);
        return responseEntity;
    }


    //@Authorized(allowedRoles = {Role.ADMIN})
    @DeleteMapping ("{uId}")         //localhost:8099/users, @DeleteMapping used for "Delete"
    public ResponseEntity<String> userDelete(@PathVariable("uId")int userId){
        System.out.println("Deleting details  by user id  :" + userId);
        ResponseEntity<String> responseEntity;
        if (!(userService.isUserExists(userId))) responseEntity = new ResponseEntity<String>
                ("Cannot delete as id doesn't exist", HttpStatus.NO_CONTENT);
        else {
            if (userService.deleteUser(userId)) responseEntity = new ResponseEntity<String>
                    (userId + " deleted", HttpStatus.OK);
            else responseEntity = new ResponseEntity<String>
                    (" Cannot delete, something went wrong", HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }

}
