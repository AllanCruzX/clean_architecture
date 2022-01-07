package escola;

import escola.academico.aplicacao.aluno.matricula.MatricularAluno;
import escola.academico.aplicacao.aluno.matricula.MatricularAlunoDto;
import escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import escola.gameficacao.aplicacao.GeraSeloAlunoNovato;
import escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {
	
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		
		MatricularAlunoDto dto = new MatricularAlunoDto(
				nome, cpf, email);
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new GeraSeloAlunoNovato(
				new RepositorioDeSelosEmMemoria()));
		
		MatricularAluno matricular = new MatricularAluno(
				new RepositorioDeAlunosEmMemoria(), publicador);
		
		matricular.executa(dto);
	}

}
