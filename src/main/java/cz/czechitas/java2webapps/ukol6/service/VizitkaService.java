package cz.czechitas.java2webapps.ukol6.service;


import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VizitkaService {

    private VizitkaRepository vizitkaRepository;

    @Autowired
    public VizitkaService(VizitkaRepository repository) {
        this.vizitkaRepository = repository;
    }

    public Vizitka nova(){
        return new Vizitka();
    }

    public Vizitka pridat(Vizitka vizitka){
        vizitka.setId(null);
        vizitkaRepository.save(vizitka);
        return vizitka;
    }

    public Optional<Vizitka> detailPodleId(int id) {
        return vizitkaRepository.findById(id);
    }


    public Iterable<Vizitka> seznamVsech(){
        return vizitkaRepository.findAll();
    }


}
