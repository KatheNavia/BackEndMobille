package co.edu.uniajc.vacunacion.controller;

import co.edu.uniajc.vacunacion.dto.UserDTO;
import co.edu.uniajc.vacunacion.model.UserModel;
import co.edu.uniajc.vacunacion.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping(path = "/save")
    @Operation(summary = "Insert user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public UserModel createUser(@RequestBody UserModel userModel){
        return usersService.createUser(userModel);
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public UserModel updateUser(@RequestBody UserModel userModel){
        return usersService.updateUser(userModel);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public void deleteUsers(@RequestParam(name = "id") Long id){
        usersService.deleteUsers(id);
    }

    @GetMapping(path = "/all")
    @Operation(summary = "Find all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public List<UserModel> findAllUsers(){
        return usersService.findAllUsers();
    }

    @GetMapping(path = "/getUser")
    @Operation(summary = "Find user by number document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public UserModel findByDocument(@RequestParam(name = "numberDocument")String numberDocument ){
        return usersService.findByNumberDocument(numberDocument);
    }

//    @PostMapping(path = "/login")
//    @Operation(summary = "login for user")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK", content = {
//                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
//            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
//    })
//    public UserDTO findUserAndPassword(@RequestBody UserModel userModel){
//        return usersService.login(userModel.getNumberDocument(), userModel.getPassword());
//    }

}
