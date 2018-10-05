package lab4;

import java.util.Scanner;

/**
 * Classe principal. Respons�vel pelo tratamento de entradas e exibi��o de sa�das.
 * 
 * @author Euclides Ramos - 117210377
 *
 */
public class Main {
	
	/**
	 * Atributo do tipo Scanner, respons�vel por ler entradas do usu�rio.
	 */
	private static Scanner in = new Scanner(System.in);
	
	/**
	 * Atributo respons�vel por armazenar todas as informa��es do Sistema (cadastro de alunos, cadastro de grupos de estudo, aloca��o de alunos em grupos de estudo, 
	 * cadastro de alunos que responderam perguntas no quadro).
	 */
	private static Sistema sistema = new Sistema();
	
	/**
	 * M�todo principal. Respons�vel pela leitura de entradas, processamento e exibi��o de sa�das.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Menu();
		char opcao = in.next().charAt(0);
		in.nextLine();
		
		while (opcao != 'O') {
			if (opcao == 'C') {
				cadastraNovoAluno();
			} else if (opcao == 'E') {
				exibeAluno();
			} else if (opcao == 'N') {
				cadastraGrupo();
			} else if (opcao == 'A') {
				alocaAlunoImprimeGrupo();
			} else if (opcao == 'R') {
				addAlunoRespondeuNoQuadro();
			} else if (opcao == 'I') {
				System.out.println(sistema.imprimeAlunosQueResponderam());
			} else {
				System.out.println("COMANDO INV�LIDO!" + System.lineSeparator());
			}
			Menu();
			opcao = in.next().charAt(0);
			in.nextLine();
		}
		System.exit(0);
		in.close();
	}
	
	/**
	 * M�todo respons�vel pela exibi��o do menu.
	 */
	private static void Menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!" + System.lineSeparator());
		System.out.print("Op��o> ");		
	}
	
	/**
	 * M�todo respons�vel por receber entradas acerca do cadastro de novos alunos no Sistema.
	 */
	private static void cadastraNovoAluno() {
		System.out.print("Matr�cula: ");
		String matricula = in.nextLine();
		
		System.out.print("Nome: ");
		String nome = in.nextLine();
		
		System.out.print("Curso: ");
		String curso = in.nextLine();
		
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (sistema.cadastraAluno(matricula, aluno)) {
			System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
		} else {
			System.out.println("MATR�CULA J� CADASTRADA!" + System.lineSeparator());
		}
	}
	
	/**
	 * M�todo respons�vel pela exibi��o de um aluno que j� est� cadastrado no Sistema.
	 */
	private static void exibeAluno() {
		System.out.print("Matr�cula: ");
		String matricula = in.nextLine();
		
		System.out.println(sistema.exibeAluno(matricula) + System.lineSeparator());
	}
	
	/**
	 * M�todo respons�vel por receber informa��es de um novo grupo de estudos e cadastr�-lo no Sistema.
	 */
	private static void cadastraGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = in.nextLine();
		
		Grupo grupo = new Grupo(nomeGrupo);
		
		if (!sistema.setGrupo(nomeGrupo, grupo)) {
			System.out.println("GRUPO J� CADASTRADO!" + System.lineSeparator());
		} else {
			System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
		}
	}
	
	/**
	 * M�todo respons�vel por alocar aluno em um grupo e imprimir alunor pertencentes a um determinado grupo.
	 */
	private static void alocaAlunoImprimeGrupo() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		
		char escolha = in.next().charAt(0);
		in.nextLine();

		if (escolha == 'A') {					
			System.out.print("Matr�cula: ");
			String matriculaAdd = in.nextLine();
			
			System.out.print("Grupo: ");
			String grupoAdd = in.nextLine();
			
			System.out.println(sistema.setAlunoGrupo(matriculaAdd, grupoAdd) + System.lineSeparator());
		} else if (escolha == 'I') {
			System.out.print("Grupo: ");
			String grupoImprimir = in.nextLine();
			
			System.out.println(sistema.imprimeGrupo(grupoImprimir) + System.lineSeparator());
		} else {
			System.out.println("COMANDO INV�LIDO!" + System.lineSeparator());
		}
	}
	
	/**
	 * M�todo respons�vel por adicionar ao Sistema alunos que responderam quest�es no quadro.
	 */
	private static void addAlunoRespondeuNoQuadro() {
		System.out.print("Matr�cula: ");
		String matriculaAluno = in.nextLine();
		
		if (sistema.addAlunoQueRespondeu(matriculaAluno)) {
			System.out.println("ALUNO REGISTRADO!" + System.lineSeparator());
		} else {
			System.out.println("ALUNO N�O CADASTRADO." + System.lineSeparator());
		}
	}
}
