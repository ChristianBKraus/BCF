package jupiterpa.bcf.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunRepository extends CrudRepository<Run, Long> {
    List<Run> findById(final String id);
}
