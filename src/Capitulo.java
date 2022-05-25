import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe que armazena as informações de um capítulo
 * que são:
 * <ul>
 * <li>private String texto;
 * <li>protected ArrayList<Escolha> escolhas;
 * <li>private Personagem personagem1;
 * <li>private Personagem personagem2;
 * <li>private int variacaoEnergiaPersonagem1;
 * <li>private int variacaoEnergiaPersonagem2;
 * <li>protected Scanner escaneador;
 * </ul>
 */
public class Capitulo {
  private String texto;
  protected ArrayList<Escolha> escolhas;
  private Personagem personagem1;
  private Personagem personagem2;
  private int variacaoEnergiaPersonagem1;
  private int variacaoEnergiaPersonagem2;
  protected Scanner escaneador;

  /**
   * Método responsável por criar um capítulo dado os parâmetros
   * 
   * @param texto
   * @param personagem1
   * @param personagem2
   * @param variacaoEnergiaPersonagem1
   * @param variacaoEnergiaPersonagem2
   * @param escaneador
   */
  public Capitulo(String texto,
      Personagem personagem1,
      Personagem personagem2,
      int incrementoPersonagem1,
      int incrementoPersonagem2,
      Scanner escaneador) {
    this.texto = texto;
    this.personagem1 = personagem1;
    this.personagem2 = personagem2;
    this.variacaoEnergiaPersonagem1 = incrementoPersonagem1;
    this.variacaoEnergiaPersonagem2 = incrementoPersonagem2;
    this.escaneador = escaneador;
    this.escolhas = new ArrayList<Escolha>();
  }

  /**
   * Método responsável por construir um capítulo que recebe como parâmetro um
   * hashmap de personagens
   * 
   * @param personagens
   * @param escaneadorDoConsole
   * @param escaneador
   */
  public Capitulo(
      Map<String, Personagem> personagem,
      Scanner escaneadorDoConsole,
      Scanner escaneador) {
    this.lerCapitulos(personagem, escaneador);
    this.escaneador = escaneadorDoConsole;
    this.escolhas = new ArrayList<>();
  }

  /**
   * Método responsável por construir um capítulo "génerico"
   */
  protected Capitulo() {
    this.texto = "";
    this.escolhas = new ArrayList<Escolha>();
  }

  /**
   * Método responsável por ler o capítulo no arquivo txt que recebe os parâmetros
   * 
   * @param personagens
   * @param escaneador
   */
  protected void lerCapitulos(
      Map<String, Personagem> personagens,
      Scanner escaneador) {
    escaneador.nextLine(); // PERSONAGENS
    String idPerson1 = escaneador.nextLine();
    String idPerson2 = escaneador.nextLine();
    this.personagem1 = personagens.get(idPerson1);
    this.personagem2 = personagens.get(idPerson2);

    escaneador.nextLine(); // TEXTO

    String linha = escaneador.nextLine();
    this.texto = "";
    while (!linha.equals("VARIACOES")) {
      if (linha.equals(idPerson1)) {
        texto = texto + personagem1.getNome();

      } else if (linha.equals(idPerson2)) {
        texto = texto + personagem2.getNome();
      } else {
        texto = texto + linha;
      }
      linha = escaneador.nextLine();

    }

    this.variacaoEnergiaPersonagem1 = Integer.parseInt(escaneador.nextLine());
    this.variacaoEnergiaPersonagem2 = Integer.parseInt(escaneador.nextLine());

  }

  /**
   * Responsável por chamar o método mostrar
   */
  public void executar() {
    mostrar();

    if (getEscolhas().size() > 0) {

      int idEscolhaCap = escolher();
      escolhas.get(idEscolhaCap - 1).getproximo().executar();
    } else {
      System.out.println("CABOUSSE");
    }
  }

  /**
   * Responsável por mostrar o texto e as energias do capítulo
   */
  protected void mostrar() {
    System.out.println(texto);
    personagem1.addEnergia(variacaoEnergiaPersonagem1);
    personagem2.addEnergia(variacaoEnergiaPersonagem2);

    for (int i = 0; i < escolhas.size(); i++) {
      System.out.println("- " + escolhas.get(i).getTextoMostrado());
    }

    System.out.println();
    System.out.println(". . .");
    System.out.println();

  }

  private int escolher() {
    int opcaoEscolhida = 0;
    String escolha;
    boolean escolhaValida = false;

    while (!escolhaValida) {
      escolha = escaneador.nextLine();
      for (int i = 0; i < escolhas.size(); i++) {
        if (escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado())) {
          escolhaValida = true;
          opcaoEscolhida = i + 1;
        }
      }
      if (!escolhaValida) {
        System.out.println("A escolha digitada não válida, digite novamente");
      }
    }
    return opcaoEscolhida;
  }

  String getTexto(String texto) {
    return this.texto;
  }

  ArrayList<Escolha> getEscolhas() {
    return this.escolhas;
  }

  Personagem getPersonagem1() {
    return this.personagem1;
  }

  Personagem getPersonagem2() {
    return this.personagem2;
  }

  int getVariacaoEnergiaPersonagem1() {
    return this.variacaoEnergiaPersonagem1;
  }

  int getVariacaoEnergiaPersonagem2() {
    return this.variacaoEnergiaPersonagem2;
  }
}
