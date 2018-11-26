package ResultCore.controllers;

import ResultCore.entities.Result;
import ResultCore.exceptions.ResultNotFoundException;
import ResultCore.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    List<Result> getAll() {
        return resultRepository.findAll();
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    Result create(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    @RequestMapping(value = "/results/{userId}", method = RequestMethod.GET)
    Result getOne(@PathVariable Integer userId){
        return resultRepository.findByUserId(userId).orElseThrow(() -> new ResultNotFoundException(userId));
    }

    @RequestMapping(value = "/results/{userId}", method = RequestMethod.PUT)
    Result update(@RequestBody Result newResult, @PathVariable Integer userId){
        return resultRepository.findByUserId(userId)
                .map(result -> {
                    result.setUserId(newResult.getUserId());
                    result.setNbGamesPlayed(newResult.getNbGamesPlayed());
                    result.setNbGamesWon(newResult.getNbGamesWon());
                    result.setNbRoundPlayed(newResult.getNbRoundPlayed());
                    result.setNbRoundWon(newResult.getNbRoundWon());
                    result.setBiggestPotWon(newResult.getBiggestPotWon());
                    result.setTotalEarnedMoney(newResult.getTotalEarnedMoney());
                    return resultRepository.save(result);
                }).orElseGet(() -> {
                    newResult.setUserId(userId);
                    return resultRepository.save(newResult);
                });
    }

    @RequestMapping(value = "/results/{userId}", method = RequestMethod.DELETE)
    void delete(@PathVariable Integer userId) {
        resultRepository.deleteByUserId(userId);
    }


}
