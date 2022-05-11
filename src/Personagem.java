
public class Personagem {
  private String nome;
  private int energia;
  private int incremento;

  public Personagem(String nome, int energia) {
    this.nome = nome;
    this.energia = energia;
  }

  void addenergia(int incremento) {
    this.energia += incremento;
    System.out.println("A energia de " + this.nome + " agora é " + this.energia);
  }

  public Personagem(String nome) {
    this.nome = nome;
    this.energia = 10;
  }

  public void setEnergia(int energia) {
    this.energia = energia;
    if (energia < 0) {
      energia = 0;
    }
  }

  public String getNome() {
    return this.nome;
  }

  public int getincremento() {
    return incremento;
  }
}
