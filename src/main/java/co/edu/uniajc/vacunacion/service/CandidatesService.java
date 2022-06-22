package co.edu.uniajc.vacunacion.service;

import co.edu.uniajc.vacunacion.model.CandidateModel;
import co.edu.uniajc.vacunacion.repository.CandidatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesService {

    private final CandidatesRepository candidatesRepository;

    @Autowired
    public CandidatesService(CandidatesRepository candidatesRepository){
        this.candidatesRepository = candidatesRepository;
    }

    public CandidateModel createCandidate(CandidateModel candidateModel) {
        return this.candidatesRepository.save(candidateModel);
    }

    public CandidateModel updateCandidate(CandidateModel candidateModel) {
        return this.candidatesRepository.save(candidateModel);
    }

    public void deleteCandidate(Long id) {
        this.candidatesRepository.deleteById(id);
    }

    public List<CandidateModel> findAllCandidates() {
        return this.candidatesRepository.findAll();
    }

}
