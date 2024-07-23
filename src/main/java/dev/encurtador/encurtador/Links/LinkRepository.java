package dev.encurtador.encurtador.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Links, Long>{


    Links findByUrlEncurtada(String urlEncurtada);

}
