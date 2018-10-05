package lab4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class GrupoTest {

	private Grupo grupo1, grupo2, grupo3, grupo4;
	private Aluno aluno;
	
	@Before
	public void exemploGrupo() {
		this.grupo1 = new Grupo("Listas");
		this.grupo2 = new Grupo("Provas");
		this.grupo3 = new Grupo("Listas");
		this.grupo4 = new Grupo("LISTAS");
		this.aluno = new Aluno("123", "Euclides", "Computacao");
		this.grupo2.alocarAlunoEmGrupo(aluno);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGrupoNomeInvalidoVazio() {
		assertEquals("GRUPO INVÁLIDO!", this.grupo2 = new Grupo(""));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGrupoNomeInvalidoNulo() {
		assertEquals("GRUPO INVÁLIDO!", this.grupo2 = new Grupo(null));
	}
	
	@Test
	public void testAlocarAlunoEmGrupo() {
		assertEquals(true, this.grupo1.alocarAlunoEmGrupo(aluno));
	}
	
	@Test
	public void testAlocarMesmoAlunoEmGrupo() {
		assertEquals(true, this.grupo2.alocarAlunoEmGrupo(aluno));
	}
	
	@Test
	public void testGetNomeGrupo() {
		assertEquals("Listas", this.grupo1.getNomeGrupo());
	}
	
	@Test
	public void testGetAlunosAssociados() {
		assertEquals("* 123 - Euclides - Computacao" + System.lineSeparator(), this.grupo2.getAlunosAssociados());
	}
	
	@Test
	public void testGetAlunosAssociadosNenhum() {
		assertEquals("", this.grupo1.getAlunosAssociados());
	}
	
	@Test
	public void testHashCode() {
		assertEquals(this.grupo1.hashCode(), this.grupo3.hashCode());
	}
	
	@Test
	public void testEqualsIguais() {
		assertEquals(true, this.grupo1.equals(grupo3));
	}
	
	@Test
	public void testEqualsIguaisLetraMauiscula() {
		assertEquals(true, this.grupo1.equals(grupo4));
	}
	
	@Test
	public void testEqualsDiferentes() {
		assertEquals(false, this.grupo1.equals(grupo2));
	}
}
