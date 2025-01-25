package br.com.rafael.dslist.controller;

import br.com.rafael.dslist.dto.GameListDTO;
import br.com.rafael.dslist.dto.GameMinDTO;
import br.com.rafael.dslist.dto.ReplacementDTO;
import br.com.rafael.dslist.servicies.GameListService;
import br.com.rafael.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void  move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
      gameListService.move(listId,body.getSourceIndex(),body.getDestinationIndex());
    }

}
