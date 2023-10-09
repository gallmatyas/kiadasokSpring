package hu.progmatic.kiadasok.service;
import hu.progmatic.kiadasok.entity.Ember;
import hu.progmatic.kiadasok.repository.EmberRepository;
import hu.progmatic.kiadasok.repository.KiadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmberService {

    @Autowired
    private EmberRepository emberRepository;

    @Autowired
    private KiadasRepository kiadasRepository;

    public List<Ember> findAll() {
        return emberRepository.findAll();
    }

    public Ember findById(int id) {
        Optional<Ember> result = emberRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Nincs ilyen id-val rendelkező ember az " +
                    "adatbázisban " + id);
        }
    }

    public void save(Ember ember) {
        emberRepository.save(ember);
    }

}
