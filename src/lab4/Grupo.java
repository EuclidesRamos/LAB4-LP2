package lab4;

import java.util.HashSet;

/**
 * Classe respons�vel por armazenar todas as informa��es acerca de um objeto do tipo Grupo.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Grupo {
	
	/**
	 * Atributo respons�vel por armazenar o nome do grupo em forma de String.
	 */
	private String nomeGrupo;
	
	/**
	 * Conjunto respons�vel por armazenar todos os alunos que fazem parte do grupo de estudo.
	 */
	private HashSet<Aluno> alunosAssociados;
	
	/**
	 * Construtor respons�vel por contruir um objeto do tipo Grupo. Al�m de criar um conjunto para armazenar os alunos que fazem parte desse grupo.
	 * 
	 * @param nomeGrupo - Caso o nome do grupo seja nulo ou vazio, � lan�ada uma exce��o.
	 */
	public Grupo(String nomeGrupo) {
		if (nomeGrupo.trim().equals("") || nomeGrupo.equals(null)) {
			throw new IllegalArgumentException("GRUPO INV�LIDO!");
		}
		this.nomeGrupo = nomeGrupo;
		this.alunosAssociados = new HashSet<>();
	}
	
	/**
	 * M�todo respons�vel por alocar um novo aluno no grupo desejado. N�o h� repeti��o de alunos nos grupos de estudo.
	 * 
	 * @param aluno
	 * @return
	 */
	public boolean alocarAlunoEmGrupo(Aluno aluno) {
		for (Aluno a : alunosAssociados) {
			if (a.getMatricula().equals(aluno.getMatricula())) {
				return true;
			}
		}
		alunosAssociados.add(aluno);
		return true;
	}
	
	/**
	 * M�todo respons�vel por retornar o nome do grupo de estudos.
	 * 
	 * @return
	 */
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	
	/**
	 * M�todo respons�vel por retornar os alunos que fazem parte do grupo de estudos em forma de String.
	 * 
	 * @return
	 */
	public String getAlunosAssociados() {
		String saida = "";
		for (Aluno a : alunosAssociados) {
			saida += "* " + a.toString() + System.lineSeparator();
		}
		return saida;
	}

	/**
	 * M�todo respons�vel por criar e retornar um valor �nico para cada Objeto do tipo Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.toLowerCase().hashCode());
		return result;
	}

	/**
	 * M�todo respons�vel por comparar se dois objetos do tipo Grupo s�o iguais. A compara��o � realizada atrav�s do nome do grupo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Grupo outroGrupo = (Grupo) obj;
		if (this.nomeGrupo.toLowerCase().equals(outroGrupo.nomeGrupo.toLowerCase())) {
			return true;
		}
		return false;
	}
}
