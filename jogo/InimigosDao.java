package jogo;

import java.util.ArrayList;

public class InimigosDao {
	
	ArrayList<Inimigos> tipos = new ArrayList <Inimigos> ();
	
	void salvar(Inimigos i)
	{
		tipos.add(i);
	}
	
	void exibir()
	{
		for(Inimigos ini: tipos)
		{
			System.out.println("Nome: " + ini.getNome()
							+"\nVidaMaxima: " + ini.getVidaMaxima()
							+"\nForça: " + ini.getAtaque()
							+"\nDefesa: " + ini.getAtaque()
							+"\n\n");
		}
	}
	void excluir(int cod)
	{
		cod--;
		tipos.remove(cod);
	}
	
	Inimigos buscar(int cod)
	{
		cod--;
		return tipos.get(cod);
	}
	
	void alterar(int cod, Inimigos ini)
	{
		cod--;
		tipos.set(cod, ini);
	}
	
}
