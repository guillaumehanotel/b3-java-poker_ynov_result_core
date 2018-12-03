package ResultCore.controllers;

import ResultCore.entities.Result;
import ResultCore.entities.ResultStat;
import ResultCore.repositories.ResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(value = "/users/{userId}/stats", method = RequestMethod.GET)
        ResultStat getOneByUserId(@PathVariable Integer userId){
            ResultStat resultStat = new ResultStat();

            resultStat.setTotalMoneyWon(resultRepository.getMoneyWonSumByUserId(userId));
            resultStat.setNbGamePlayed(resultRepository.getNbGamePlayed(userId));
            resultStat.setNbRoundPlayed(resultRepository.getNbRoundPlayed(userId));
            resultStat.setNbRoundWon(resultRepository.getNbRoundWon(userId));
            resultStat.setBiggestPotWon(resultRepository.getBiggestPotWon(userId));

        return resultStat;
    }


    @RequestMapping(value = "/results", method = RequestMethod.POST)
    Result create(@RequestBody Result result) {
        log.info(result.toString());
        return resultRepository.save(result);
    }



}
