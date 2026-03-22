package services;

import model.Fornecedor;
import org.springframework.stereotype.Service;
import repositories.FornecedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor criar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public boolean deletarPorId(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            return false;
        }
        fornecedorRepository.deleteById(id);
        return true;
    }
}