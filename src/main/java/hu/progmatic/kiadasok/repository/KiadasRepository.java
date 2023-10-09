package hu.progmatic.kiadasok.repository;
import hu.progmatic.kiadasok.entity.Ember;
import hu.progmatic.kiadasok.entity.Kiadas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KiadasRepository extends JpaRepository<Kiadas, Integer> {

    List<Kiadas> findByEmber(Ember ember);

}
