import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * classe que herda da calsse capítulo
 */
public class CapituloImagem extends Capitulo {

  private String imagem;

  /**
   * Responsável por criar uma imagem por um texto ascii
   */
  public CapituloImagem(
      Map<String, Personagem> personagens,
      Scanner escaneadorDoConsole,
      Scanner escaneadorDoArquivo) {
    super();
    this.lerCapitulo(personagens, escaneadorDoArquivo);
    this.escaneador = escaneadorDoConsole;
    this.escolhas = new ArrayList<Escolha>();
  }

  protected void lerCapitulo(
      Map<String, Personagem> personagens,
      Scanner escaneadorDoArquivo)

  {
    super.lerCapitulos(personagens, escaneadorDoArquivo);

    escaneadorDoArquivo.nextLine();// IMAGEM
    String linha = escaneadorDoArquivo.nextLine();

    this.imagem = "";

    while (!linha.equals("IMAGEM_FIM")) {
      this.imagem = imagem + "\n" + linha;
      linha = escaneadorDoArquivo.nextLine();
    }
  }

  /**
   * Responsável por mostrar o texto do capítulo
   */
  protected void mostrar() {
    System.out.println(
        "_________________________________________________________________________________________________________________________________________");
    System.out.println(this.imagem);
    System.out.println(
        "_________________________________________________________________________________________________________________________________________");
    System.out.println();
    super.mostrar();
  }
}