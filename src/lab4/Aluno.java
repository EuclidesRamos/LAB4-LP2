package lab4;

/**
 * Classe respons�vel por armazenar todas as informa��es acerca de um determinado aluno.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Aluno {

	/**
	 * Atributo respons�vel por armazenar a matr�cula do aluno.
	 */
	private String matricula;
	
	/**
	 * Atributo respons�vel por armazenar o nome do aluno.
	 */
	private String nome;
	
	/**
	 * Atributo respons�vel por armazenar o curso do aluno.
	 */
	private String curso;
	
	/**
	 * Construtor respons�vel por construir um objeto do tipo Aluno, com matr�cula, nome e curso associados a ele.
	 * 
	 * @param matricula -> Caso a matr�cula seja nula ou vazia � lan�ada uma exce��o.
	 * @param nome -> Caso o nome seja nulo ou vazio � lan�ada uma exce��o.
	 * @param curso -> Caso o curso seja nulo ou vazio � lan�ada uma exce��o.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula.trim().equals("") || matricula.equals(null)) {
			throw new IllegalArgumentException("MATR�CULA INV�LIDA!");
		} else if (nome.trim().equals("") || nome.equals(null)) {
			throw new IllegalArgumentException("NOME INV�LIDO!");
		} else if (curso.trim().equals("") || curso.equals(null)) {
			throw new IllegalArgumentException("CURSO INV�LIDO!");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		
	}
	
	/**
	 * M�todo respons�vel por retornar a matr�cula do aluno.
	 * 
	 * @return
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * M�todo respons�vel por retornar uma String contendo todas as informa��es do aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * M�todo respons�vel por criar e retornar um valor �nico para cada Objeto do tipo Aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * M�todo respons�vel por comparar se dois objetos do tipo Aluno s�o iguais. A compara��o � realizada atrav�s da matr�cula do aluno.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		Aluno outroAluno = (Aluno) obj;
		if (this.matricula.equals(outroAluno.matricula)) {
			return true;
		}
		return false;
	}
}
