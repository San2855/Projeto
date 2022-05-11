import java.util.Map;
import java.util.Scanner;
public class App
{
    public static void main (String[] args)
    {
        Scanner escaneadorDoArquivo = new Scanner(System.in, "CP850");

        LeitorDeArquivo ler = new LeitorDeArquivo();
        Map<String, Personagem> dicionarioDePersonagens = ler.carregarPersonagem("rsc/Personagens.txt");
        for(Map.Entry<String, Personagem> p: dicionarioDePersonagens.entrySet());
     
        Map<String, Capitulo> dicionárioCap = ler.carregarCapitulos("rsc/Capitulos.txt", dicionarioDePersonagens, escaneadorDoArquivo);
        Capitulo raiz = dicionárioCap.get("raiz");
        raiz.executar();
        escaneadorDoArquivo.close();
    } 
} 