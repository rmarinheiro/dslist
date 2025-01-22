package br.com.rafael.dslist.repositories;

import br.com.rafael.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
