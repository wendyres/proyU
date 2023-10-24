package apifestivos.apifestivos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivos.apifestivos.entidades.Tipo;

@Repository
public interface RepositorioTipo extends JpaRepository<Tipo,Long>{
    
}

