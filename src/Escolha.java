public class Escolha {
  private String TextoDigitado;
  private String TextoMostrado;
  private Capitulo proximo;

  Escolha(String TextoDigitado, String TextoMostrado, Capitulo proximo) {
    this.TextoDigitado = TextoDigitado;
    this.TextoMostrado = TextoMostrado;
    this.proximo = proximo;
  }

  /**
   * @return TextoDigitado
   */
  public String getTextoDigitado() {
    return this.TextoDigitado;
  }

  /**
   * @return TextoMostrado
   */
  public String getTextoMostrado() {
    return this.TextoMostrado;
  }

  /**
   * @return proximo
   */
  public Capitulo getproximo() {
    return this.proximo;
  }
}
