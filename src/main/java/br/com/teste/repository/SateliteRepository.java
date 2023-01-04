package br.com.teste.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.model.bd.Satelite;

@Repository
public interface SateliteRepository extends JpaRepository<Satelite, Long>{

	public Page<Satelite> findAll(Pageable paginacao);

}
