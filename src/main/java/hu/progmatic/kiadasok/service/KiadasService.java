package hu.progmatic.kiadasok.service;

import hu.progmatic.kiadasok.entity.Ember;
import hu.progmatic.kiadasok.entity.Kiadas;
import hu.progmatic.kiadasok.repository.KiadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiadasService {

    @Autowired
    private KiadasRepository kiadasRepository;

    public void addKiadas(Kiadas kiadas) {
        kiadasRepository.save(kiadas);
    }

    public List<Kiadas> findByEmber(Ember ember) {
        return kiadasRepository.findByEmber(ember);
    }

}
