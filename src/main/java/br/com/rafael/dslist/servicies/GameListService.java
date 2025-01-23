package br.com.rafael.dslist.servicies;

import br.com.rafael.dslist.dto.GameListDTO;
import br.com.rafael.dslist.entities.GameList;
import br.com.rafael.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> resultados = gameListRepository.findAll();
        List<GameListDTO> dto = resultados.stream().map(x-> new GameListDTO(x)).toList();
        return dto;
    }

}
