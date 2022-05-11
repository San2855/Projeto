import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeitorDeArquivo {
    HashMap<String, Personagem> carregarPersonagem(String caminho) {

        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();

        File arquivo = new File(caminho);
        try {

            Scanner escaneador = new Scanner(arquivo);
            System.out.println("carregando personagens...");
            int i = 0;

            while (escaneador.hasNextLine()) {

                i++;

                escaneador.nextLine();
                String nome = escaneador.nextLine();

                escaneador.nextLine();
                int energia = Integer.parseInt(escaneador.nextLine());

                escaneador.nextLine();

                System.out.println("Personagem " + i);

                personagens.put(nome, new Personagem(nome, energia));

            }

            escaneador.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return personagens;
    }

    HashMap<String, Capitulo> carregarCapitulos(String caminho,
            Map<String, Personagem> dicionarioDePersonagens,
            Scanner escaneadorDoConsole) {
        HashMap<String, Capitulo> dicionárioCap = new HashMap<String, Capitulo>();

        File arquivo = new File(caminho);
        try {
            Scanner escaneadorDoArquivo = new Scanner(arquivo, "CESU8");

            System.out.println("Carregando Capítulos...");

            String linha = escaneadorDoArquivo.nextLine();
            while (escaneadorDoArquivo.hasNextLine()) {
                if (linha.equals("CAPITULO")
                        || linha.equals("CAPITULO_COM_IMAGEM")) {
                    escaneadorDoArquivo.nextLine(); // ID
                    String id = escaneadorDoArquivo.nextLine();
                    if (linha.equals("CAPITULO")) {
                        dicionárioCap.put(id,
                                new Capitulo(dicionarioDePersonagens, escaneadorDoConsole, escaneadorDoArquivo));
                    } else if (linha.equals("CAPITULO_COM_IMAGEM")) {
                        dicionárioCap.put(id,
                                new CapituloImagem(dicionarioDePersonagens, escaneadorDoConsole, escaneadorDoArquivo));
                    }
                    System.out.println("Capítulo " + id);
                    escaneadorDoArquivo.nextLine();
                } else if (linha.equals("ESCOLHA")) {
                    LerEscolha(dicionárioCap, escaneadorDoArquivo);
                }
                linha = escaneadorDoArquivo.nextLine();
            }
            escaneadorDoArquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dicionárioCap;
    }

    private void LerEscolha(
            HashMap<String, Capitulo> dicionárioCap,
            Scanner escaneadorDoArquivo) {
        escaneadorDoArquivo.nextLine(); // DE
        String idCapituloDe = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine(); // PARA
        String idCapituloPara = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine(); // TEXTO DIGITADO
        String textoDigitado = escaneadorDoArquivo.nextLine();
        escaneadorDoArquivo.nextLine(); // TEXTO DISPLAY
        String textoMostrado = escaneadorDoArquivo.nextLine();
        dicionárioCap.get(idCapituloDe).getEscolhas()
                .add(new Escolha(textoDigitado, textoMostrado, dicionárioCap.get(idCapituloPara)));
    }

}