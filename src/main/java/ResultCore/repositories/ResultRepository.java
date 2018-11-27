package ResultCore.repositories;

import ResultCore.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    Optional<Result> findByUserId(Integer userId);
    Optional<Result> findByGameId(Integer userId);

}
