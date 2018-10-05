package lab4;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Classe respons�vel pelo Sistema. Armazena informa��es com Alunos, Grupos de estudos e alunos que responderam perguntas no quadro.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Sistema {
	
	/**
	 * Mapa respons�vel por armazenar os alunos cadastrados no Sistema. A chave � a matr�cula do aluno e o valor � um objeto do tipo Aluno.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Mapa respons�vel por armazenar os grupos de estudos cadastrados no Sistema. A chave � o nome do grupo de estudos e o valor � um objeto do tipo Grupo.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Lista respons�vel por armazenar os alunos que responderam quest�es no quadro. A sequ�ncia � importante.
	 */
	private ArrayList<Aluno> quemRespondeu;
	
	/**
	 * Construtor respons�vel por construir objetos do tipo Sistema. Cria dois mapas e uma lista.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.quemRespondeu = new ArrayList<>();
	}
	
	/**
	 * M�todo respons�vel por cadastrar alunos no sistema, armazenando esses objetos em um mapa. Caso o aluno seja novo para o Sistema retornar� "true", 
	 * caso o aluno j� esteja cadastrado no Sistema, retornar� "false".
	 * 
	 * @param matricula
	 * @param aluno
	 * @return
	 */
	public boolean cadastraAluno(String matricula, Aluno aluno) {
		if (procuraAluno(matricula) == null) {
			this.alunos.put(matricula, aluno);
			return true;
		}
		return false;
	}

	/**
	 * M�todo respons�vel por exibir as informa��es contidas em um objeto Aluno. Atr�ves da matr�cula, a busca � realizada. Caso o aluno n�o esteja cadastrado no 
	 * Sistema, retornar� "ALUNO N�O CADASTRADO.". Caso ele esteja cadastrado, retornar� o toString() desse objeto.
	 * 
	 * @param matricula
	 * @return
	 */
	public String exibeAluno(String matricula) {
		if (procuraAluno(matricula) != null) {
			return "Aluno: " + this.alunos.get(matricula).toString();
		}
		return "ALUNO N�O CADASTRADO.";
	}
	
	/**
	 * M�todo respons�vel por cadastrar grupos de estudos no Sistema. Atrav�s do nome do grupo, � realizado uma pesquisa no Sistema. Caso o grupo j� exista, 
	 * retornar� "false", caso o grupo ainda n�o esteja cadastrado no Sistema, retornar� "true".
	 * 
	 * @param nome
	 * @param grupo
	 * @return
	 */
	public boolean setGrupo(String nome, Grupo grupo) {
		if (procuraGrupo(nome) == null) {
			this.grupos.put(nome.toLowerCase(), grupo);
			return true;
		}
		return false;
	}

	/**
	 * Met�do respons�vel por adicionar um determinado aluno em um determinado grupo de estudo. Alunos podem participar de mais de um grupo de estudos.
	 * 
	 * @param matriculaAdd -> matr�cula do aluno a ser adicionado
	 * @param grupoAdd -> nome do grupo a ser incrementado por um novo aluno.
	 * @return
	 */
	public String setAlunoGrupo(String matricula, String nomeGrupo) {
		
		Aluno alunoAdd = null;
		Grupo grupoAdd = null;
		String saida = "ALUNO ALOCADO!";
		
		if (procuraAluno(matricula) != null && procuraGrupo(nomeGrupo) != null) {
			alunoAdd = this.alunos.get(matricula);
			grupoAdd = this.grupos.get(nomeGrupo.toLowerCase());
		}
		if (procuraAluno(matricula) == null && procuraGrupo(nomeGrupo) == null) {
			saida = "ALUNO E GRUPO N�O CADASTRADOS.";
		} else if (procuraAluno(matricula) == null) {
			saida = "ALUNO N�O CADASTRADO.";
		} else if (procuraGrupo(nomeGrupo) == null){
			saida = "GRUPO N�O CADASTRADO.";
		}
		if (saida.endsWith("!")) {
			grupoAdd.alocarAlunoEmGrupo(alunoAdd);
		}
		return saida;
	}
	
	/**
	 * M�todo respons�vel por imprimir os participantes de um determinado grupo de estudo. Caso o grupo n�o exista, retornar� "GRUPO N�O CADASTRADO.".
	 * 
	 * @param nomeGrupo -> nome do grupo a ser impresso.
	 * @return
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (procuraGrupo(nomeGrupo) != null) {
			String saida = "Alunos do grupo " + this.grupos.get(nomeGrupo.toLowerCase()).getNomeGrupo() + ":" + System.lineSeparator();
			return saida + this.grupos.get(nomeGrupo.toLowerCase()).getAlunosAssociados();
		}
		return "GRUPO N�O CADASTRADO.";
	}
	
	/**
	 * M�todo respons�vel por adiconar alunos que responderam perguntas no quadro. � poss�vel adicionar o mesmo aluno v�rias vezes.
	 * 
	 * @param matricula -> matr�cula do aluno a ser adicionado.
	 * @return
	 */
	public boolean addAlunoQueRespondeu(String matricula) {
		if (procuraAluno(matricula) != null) {
			this.quemRespondeu.add(this.alunos.get(matricula));
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo respons�vel por imprimir todos os alunos que responderam quest�es no quadro. Nesse caso, a sequ�ncia � importante e deve ser considerada.
	 * 
	 * @return
	 */
	public String imprimeAlunosQueResponderam() {
		String saida = "Alunos:" + System.lineSeparator();
		for (int i = 0; i < quemRespondeu.size(); i++) {
			saida += (i + 1) + ". " + quemRespondeu.get(i).toString() + System.lineSeparator();
		}
		return saida;
	}
	
	/**
	 * M�todo respons�vel por verificar a entrada do usu�rio, lan�ar exce��es, quando necess�rio, e procurar algum aluno no Sistema, a partir da matr�cula.
	 * 
	 * @param matricula
	 * @return
	 */
	private Aluno procuraAluno(String matricula) {
		if (matricula.trim().equals("") || matricula.equals(null)) {
			throw new IllegalArgumentException("MATR�CULA INV�LIDA!");
		}
		return this.alunos.get(matricula);
	}
	
	/**
	 * M�todo respons�vel por verificar a entrada do usu�rio, lan�ar exce��es, quando necess�rio, e procurar algum grupo de estudos no Sistema, a partir do seu nome.
	 * 
	 * @param nomeGrupo
	 * @return
	 */
	private Grupo procuraGrupo(String nomeGrupo) {
		if (nomeGrupo.trim().equals("") || nomeGrupo.equals(null)) {
			throw new IllegalArgumentException("GRUPO INV�LIDO!");
		}
		return this.grupos.get(nomeGrupo.toLowerCase());
	}
}
