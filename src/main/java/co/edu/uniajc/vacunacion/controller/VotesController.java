package co.edu.uniajc.vacunacion.controller;

import co.edu.uniajc.vacunacion.model.VoteModel;
import co.edu.uniajc.vacunacion.service.VotesService;
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
@RequestMapping("/votes")
public class VotesController {

    private VotesService votesService;

    @Autowired
    public VotesController(VotesService votesService){
        this.votesService = votesService;
    }

    @PostMapping(path = "/save")
    @Operation(summary = "Insert vote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = VoteModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public VoteModel createVote(@RequestBody VoteModel voteModel){
        return votesService.createVote(voteModel);
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update vote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = VoteModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public VoteModel updateVote(@RequestBody VoteModel voteModel) {
        return votesService.updateVote(voteModel);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete vote by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = VoteModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public void deleteVote(@RequestParam(name = "id") Long id){
        votesService.deleteVote(id);
    }

    @GetMapping(path = "/all")
    @Operation(summary = "Find all vote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = VoteModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public List<VoteModel> findAllVotes(){
        return votesService.findAllVotes();
    }

}
