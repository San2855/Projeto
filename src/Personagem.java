/**
 * Classe que contém as informações dos personagens
 * Que são:
 * <ul>
 * <li>private String nome;
 * <li>private int energia;
 * <li>private int incremento;
 * </ul>
 */
public class Personagem {
  private String nome;
  private int energia;
  private int incremento;

  /**
   * Cria um personagem com os parâmetros dados
   * 
   * @param nome
   * @param energia
   */
  public Personagem(String nome, int energia) {
    this.nome = nome;
    this.energia = energia;
  }

  /**
   * Modifica a energia do personagem com o parâmetro dado
   * 
   * @param incremento
   */
  void addEnergia(int incremento) {
    this.energia += incremento;
    System.out.println("A energia de " + this.nome + " agora é " + this.energia);
  }

  /**
   * Cria um personagem com um parâmetro fixo
   * E o parametro nome é definido pelo usuário
   * 
   * @param nome
   */
  public Personagem(String nome) {
    this.nome = nome;
    this.energia = 10;
  }

  /**
   * Reseta a energia do personagem com a condição dada
   * 
   * @param energia
   */
  public void setEnergia(int energia) {
    this.energia = energia;
    if (energia < 0) {
      energia = 0;
    }
  }

  /**
   * @return o nome do personagem
   */
  public String getNome() {
    return this.nome;
  }

  /**
   * @return o incremento do personagem
   */
  public int getIncremento() {
    return incremento;
  }
}
