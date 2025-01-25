package br.com.rafael.dslist.servicies;

import br.com.rafael.dslist.dto.GameListDTO;
import br.com.rafael.dslist.entities.GameList;
import br.com.rafael.dslist.projection.GameMinProjection;
import br.com.rafael.dslist.repositories.GameListRepository;
import br.com.rafael.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultados = gameListRepository.findAll();
        List<GameListDTO> dto = resultados.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> listaJogos = gameRepository.searchByList(listId);
        GameMinProjection obj = listaJogos.remove(sourceIndex);
        listaJogos.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, listaJogos.get(i).getId(), i);
        }
    }

}
