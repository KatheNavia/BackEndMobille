package co.edu.uniajc.vacunacion.controller;

import co.edu.uniajc.vacunacion.dto.EnfermeroDTO;
import co.edu.uniajc.vacunacion.dto.UserDTO;
import co.edu.uniajc.vacunacion.model.EnfermeroModel;
import co.edu.uniajc.vacunacion.model.UserModel;
import co.edu.uniajc.vacunacion.service.LoginService;
import co.edu.uniajc.vacunacion.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping(path = "/authentication")
    @Operation(summary = "login for user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public UserDTO findUserAndPassword(@RequestBody UserModel userModel){
        return usersService.login(userModel.getNumberDocument(), userModel.getPassword());
    }

}
