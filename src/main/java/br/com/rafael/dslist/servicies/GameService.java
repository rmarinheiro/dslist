package br.com.rafael.dslist.servicies;

import br.com.rafael.dslist.dto.GameDTO;
import br.com.rafael.dslist.dto.GameMinDTO;
import br.com.rafael.dslist.entities.Game;
import br.com.rafael.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> resultados = gameRepository.findAll();
        List<GameMinDTO> dto = resultados.stream().map(x-> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
        Game game = gameRepository.findById(gameId).get();
        GameDTO dto = new GameDTO(game);
        return dto;
    }
}
