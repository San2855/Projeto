public class Escolha {
  private String TextoDigitado;
  private String TextoMostrado;
  private Capitulo proximo;

  Escolha(String TextoDigitado, String TextoMostrado, Capitulo proximo) {
    this.TextoDigitado = TextoDigitado;
    this.TextoMostrado = TextoMostrado;
    this.proximo = proximo;
  }

  public String getTextoDigitado() {
    return this.TextoDigitado;
  }

  public String getTextoMostrado() {
    return this.TextoMostrado;
  }

  public Capitulo getproximo() {
    return this.proximo;
  }
}
