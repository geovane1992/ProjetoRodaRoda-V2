
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/** Declaração da classe LeitorArquivo
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class LeitorArquivo {
    
        /** Método responsável por sortear qual tema da etapa e por ler palavras do tema 
         * @throws IOException retornar erro da leitura do arquivo.
         * @return lista de palavras lidas.
         */
     	public static ArrayList ler() throws IOException{
            
            File tema = null;
            Random random = new Random();
            int aleatorio = random.nextInt(3) + 1;
            ArrayList<String> listapalavras = new ArrayList();;
            
            switch(aleatorio){
                case 1:
                    tema = new File("cidade.txt");
                    listapalavras.add("CIDADE");
                break;
                    
                case 2:
                    tema = new File("filme.txt");
                    listapalavras.add("FILME");
                break;
                    
                case 3:
                    tema = new File("profissao.txt");
                    listapalavras.add("PROFISSÃO");
                break;
                    
                default:
                    tema = new File("cidade.txt");
                    listapalavras.add("CIDADE");
                break;
            }

            BufferedReader entradaString = new BufferedReader(new InputStreamReader(new FileInputStream(tema), "UTF-8"));
       
	    String linha = entradaString.readLine();
	    
	    while(linha != null){

                listapalavras.add(linha);
                linha = entradaString.readLine();
            }
            
            entradaString.close();
            
            return listapalavras;

	}
        
        /**Método responsável por pegar apenas o tema e 3 palavras do total lidas 
         * do arquivo.
         * @throws IOException retorna erro da leitura do arquivo.
         * @return lista de palavras com tema na primeira posição.
         */
        public static ArrayList palavrasSorteadas() throws IOException{
            ArrayList<String> listaTodasPalavrasDoTema = new ArrayList();
            ArrayList<String> listaPalavrasSelecionasRodada = new ArrayList();

            listaTodasPalavrasDoTema = ler();
            listaPalavrasSelecionasRodada.add((String) listaTodasPalavrasDoTema.get(0)); // Usada para definir o tema
            listaPalavrasSelecionasRodada.add((String) listaTodasPalavrasDoTema.get(1));
            listaPalavrasSelecionasRodada.add((String) listaTodasPalavrasDoTema.get(2));
            listaPalavrasSelecionasRodada.add((String) listaTodasPalavrasDoTema.get(3));


            return listaPalavrasSelecionasRodada;
        }

}

