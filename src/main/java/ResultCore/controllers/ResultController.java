package ResultCore.controllers;

import ResultCore.entities.Result;
import ResultCore.exceptions.ResultNotFoundException;
import ResultCore.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(value = "/results/users/{userId}", method = RequestMethod.GET)
    Result getOneByUserId(@PathVariable Integer userId){
        return resultRepository.findByUserId(userId)
                               .orElseThrow(() -> new ResultNotFoundException(userId));
    }

    @RequestMapping(value = "/results/games/{gameId}", method = RequestMethod.GET)
    Result getOneByGameId(@PathVariable Integer gameId){
        return resultRepository.findByGameId(gameId)
                .orElseThrow(() -> new ResultNotFoundException(gameId));
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    Result create(@RequestBody Result result) {
        return resultRepository.save(result);
    }

}
