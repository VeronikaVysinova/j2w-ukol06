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


    //pridani nove vizitky
    public Vizitka pridat(Vizitka vizitka){
        vizitka.setId(null);
        vizitkaRepository.save(vizitka);
        return vizitka;
    }

    //uprava vizitky
    public Vizitka upravit(Vizitka upravenaData) {
        Vizitka puvodni = vizitkaRepository.findById(upravenaData.getId())
                .orElseThrow(() -> new IllegalArgumentException("Vizitka nenalezena"));

        puvodni.setCeleJmeno(upravenaData.getCeleJmeno());
        puvodni.setObec(upravenaData.getObec());
        puvodni.setPsc(upravenaData.getPsc());
        puvodni.setFirma(upravenaData.getFirma());
        puvodni.setEmail(upravenaData.getEmail());
        puvodni.setTelefon(upravenaData.getTelefon());
        puvodni.setWeb(upravenaData.getWeb());

        return vizitkaRepository.save(puvodni);
    }

    public Optional<Vizitka> detailPodleId(int id) {
        return vizitkaRepository.findById(id);
    }


    public Iterable<Vizitka> seznamVsech(){
        return vizitkaRepository.findAll();
    }

    public void smazat(int id){
        vizitkaRepository.deleteById(id);
    }




}
