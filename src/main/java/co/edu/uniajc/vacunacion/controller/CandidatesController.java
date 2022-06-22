package co.edu.uniajc.vacunacion.controller;

import co.edu.uniajc.vacunacion.model.CandidateModel;
import co.edu.uniajc.vacunacion.service.CandidatesService;
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
@RequestMapping("/candidates")
public class CandidatesController {

    private CandidatesService candidatesService;

    @Autowired
    public CandidatesController(CandidatesService candidatesService){
        this.candidatesService = candidatesService;
    }

    @PostMapping(path = "/save")
    @Operation(summary = "Insert candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CandidateModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public CandidateModel createCandidate(@RequestBody CandidateModel candidateModel){
        return candidatesService.createCandidate(candidateModel);
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CandidateModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public CandidateModel updateCandidate(@RequestBody CandidateModel candidateModel) {
        return candidatesService.updateCandidate(candidateModel);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete candidate by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CandidateModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public void deleteCandidate(@RequestParam(name = "id") Long id){
        candidatesService.deleteCandidate(id);
    }

    @GetMapping(path = "/all")
    @Operation(summary = "Find all candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CandidateModel.class))
            }),
            @ApiResponse(responseCode = "400", description = "Something Went Wrong", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
    })
    public List<CandidateModel> findAllCandidates(){
        return candidatesService.findAllCandidates();
    }

}
