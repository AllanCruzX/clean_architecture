package escola.gameficacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import escola.gameficacao.dominio.selo.RepositorioDeSelos;
import escola.gameficacao.dominio.selo.Selo;
import escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
		return this.selos
				.stream()
				.filter(s -> s.getCpfDoAluno().equals(cpf))
				.collect(Collectors.toList());
	}

}