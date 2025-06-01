package jogo;

public class Inimigos {
	private String nome;
	private Integer vidaMaxima;
	private Integer vida;
	private Integer ataque;
	private Integer defesa;
	
	Inimigos(){}
	
	public Inimigos(String nome, Integer vidaMaxima, Integer ataque, Integer defesa) {
		super();
		this.nome = nome;
		this.vidaMaxima = vidaMaxima;
		this.ataque = ataque;
		this.defesa = defesa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVidaMaxima() {
		return vidaMaxima;
	}
	public void setVidaMaxima(Integer vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	public Integer getVida() {
		return vida;
	}
	public void setVida(Integer vida) {
		this.vida = vida;
	}
	public Integer getAtaque() {
		return ataque;
	}
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	public Integer getDefesa() {
		return defesa;
	}
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
}

