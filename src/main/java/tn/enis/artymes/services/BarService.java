package tn.enis.artymes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.artymes.model.Bar;
import tn.enis.artymes.repo.BarRepo;

@Service
public class BarService {
    private final BarRepo barRepo ;

    @Autowired
    public BarService (BarRepo barRepo) {
        this.barRepo = barRepo;
    }

    public Bar addBar(Bar bar){
        return barRepo.save(bar);
    }
    public Bar[] findAllBarsByPartIdOrderByRank(Long part_id){return barRepo.findAllBarsByPartIdOrderByRankAsc(part_id);}

}
