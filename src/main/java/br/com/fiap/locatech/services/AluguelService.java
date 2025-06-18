package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    AluguelService(AluguelRepository aluguelRepository) {

        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> findAllAlugueis(int page, int size) {
        var offset = (page - 1) * size;
        return this.aluguelRepository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelById(Long id) {
        return this.aluguelRepository.findById(id);
    }

    public void saveAluguel(Aluguel aluguel) {
        var savedAluguel = this.aluguelRepository.save(aluguel);
        Assert.state( savedAluguel == 1, "Erro ao salvar aluguel "+aluguel.getPessoaId());
    }


    public  void updateAluguel(Aluguel aluguel, long id) {
        var update = this.aluguelRepository.update(aluguel, id);
        if( update == 0) throw new RuntimeException("Nenhum aluguel encontrado para ser atualizado");
    }

    public void deleteAluguel(Long id) {
        var delete = this.aluguelRepository.delete(id);
        if(delete == 0) throw new RuntimeException("Nenhuma aluguel encontrado para ser deletado");
    }
}
