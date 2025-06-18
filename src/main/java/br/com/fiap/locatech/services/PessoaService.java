package br.com.fiap.locatech.services;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoas(int page, int size) {
        var offset = (page - 1) * size;
        return this.pessoaRepository.findAll(size, offset);
    }

    public Optional<Pessoa> findPessoaById(Long id) {
        return this.pessoaRepository.findById(id);
    }

    public void savePessoa(Pessoa pessoa) {
        var savedPessoa = this.pessoaRepository.save(pessoa);
        Assert.state( savedPessoa == 1, "Erro ao salvar Pessoa "+pessoa.getNome());
    }


    public  void updatePessoa(Pessoa pessoa, long id) {
        var update = this.pessoaRepository.update(pessoa, id);
        if( update == 0) throw new RuntimeException("Nenhum Pessoa encontrada para ser atualizada");
    }

    public void deletePessoa(Long id) {
        var delete = this.pessoaRepository.delete(id);
        if(delete == 0) throw new RuntimeException("Nenhuma pessoa encontrada para ser deletada");
    }
}
