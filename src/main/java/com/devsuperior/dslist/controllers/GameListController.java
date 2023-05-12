package com.devsuperior.dslist.controllers;

import java.util.List;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.dto.ReplacementDto;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDto body) {
      gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
