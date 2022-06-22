package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.VoteModel;
import co.edu.uniajc.vacunacion.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesService {

    private final VotesRepository votesRepository;

    @Autowired
    public VotesService(VotesRepository votesRepository){
        this.votesRepository = votesRepository;
    }

    public VoteModel createVote(VoteModel voteModel) {
        return this.votesRepository.save(voteModel);
    }

    public VoteModel updateVote(VoteModel voteModel) {
        return this.votesRepository.save(voteModel);
    }

    public void deleteVote(Long id) {
        this.votesRepository.deleteById(id);
    }

    public List<VoteModel> findAllVotes() {
        return this.votesRepository.findAll();
    }

}
