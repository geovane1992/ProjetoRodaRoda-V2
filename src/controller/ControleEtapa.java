package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.Etapa;
import model.Jogador;
import model.ParametrosIniciais;
import model.Roleta;

/** Declaração da classe ControleEtapa
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class ControleEtapa implements Observador{
    
    int etapa;
    static String letraSelecionada;
    static String palavraSelecionada;
    static List<String> listLetrasJaEscolhidas = new ArrayList<String>();
    static List<String> listPalavrasJaEscolhidas = new ArrayList<String>();
    static List<Jogador> listJogadores = new ArrayList<Jogador>();
    static String jogadorCorrente = "Jogador1";
    static List<String> listaPalavrasASeremDescobertas = new ArrayList<String>();
    static int qtdErrosJogador;
    static boolean terminouPalavras = false;
    static boolean validaSeLetraFoiEncontrada = true;
    static int posicaoJogadorCorrenteNaLista = 0;
    static EnumResultados valorSorteado = null;
    
    /** Construtor da classe ControleEtapa
     * @param etapa recebe o numero da etapa a ser realizada
     * @param obs recebe objeto observado
     */
    public ControleEtapa(int etapa, Observado obs){
        this.etapa = etapa;
        obs.incluirObservador(this);
    }

    /**Método que implementa atualização após receber letra de observador.
     * @param letra recebe letra enviada pelo observador.
     */
    @Override
    public void updateLetra(String letra) {
        letraSelecionada = letra;        
        
    }

     /**Método que implementa atualização após receber palavra de observador.
     * @param palavra  recebe palavra enviada pelo observador.
     */
    @Override
    public void updatePalavra(String palavra) {
        palavraSelecionada = palavra;
    }
    
    /** Método responsável por receber letra informada pelo jogador e adicionar a lista
     * de letras já escolhidas.
     * @param jogad recebe jogador corrente.
     */
    public static void jogadorEscolheLetra(String jogad){
        Scanner leitor = new Scanner(System.in);
        System.out.println(jogad + " informe uma letra!");
        String letraEscolhida = leitor.nextLine();
        letraSelecionada = letraEscolhida.toUpperCase();
        
        PalpiteLetra letra = new PalpiteLetra();
        Observador jogador = new ControleJogador(jogad, letra);
        letra.receberLetras(letraEscolhida.toUpperCase());
        listLetrasJaEscolhidas.add(letraEscolhida.toUpperCase());
    }
    
    /** Método responsável por receber palavra informada pelo jogador e adicionar a lista
     * de palavras já escolhidas.
     * @param jogad recebe jogador corrente.
     * @return lista de palavras já escolhidas pelo jogador
     */
    public static List<String> jogadorEscolhePalavras(String jogad){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe uma palavra!");
        String palavraEscolhida = leitor.nextLine();
        
        PalpitePalavra palavra = new PalpitePalavra();
        Observador jogador = new ControleJogador(jogad, palavra);
        palavra.receberPalavra(palavraEscolhida.toUpperCase());
        listPalavrasJaEscolhidas.add(palavraEscolhida.toUpperCase());
        
        return listPalavrasJaEscolhidas;
    }
    
    /** Método responsável por atualizar palavra esperada a cada letra infromada e 
     * armazenar os valores acumulados de cada jogador a cada rodada.
     * @param qtdPalavras recebe a quantidade de palavras da etapa.
     * @param  listaPalavrasEtapa recebe a lista de palavras da etapa
     * @return se letra foi ou nao foi encontrada
     */
    public static boolean mostraPalavrasAacertar(int qtdPalavras, List<String> listaPalavrasEtapa){
        
        System.out.println(listaPalavrasEtapa.get(1));
        System.out.println(listaPalavrasEtapa.get(2));
        System.out.println(listaPalavrasEtapa.get(3));
        validaSeLetraFoiEncontrada = false;
        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));

        for(int x = 1; x <= qtdPalavras; x++){
            String palavraOculta = "#";
                for(int i = 1; i < listaPalavrasEtapa.get(x).length(); i++){
                    palavraOculta = palavraOculta + "#";    
                }              
                
            listaPalavrasASeremDescobertas.add(palavraOculta);
            String s= listaPalavrasEtapa.get(x);
            char arr[]=s.toCharArray();
            for(int i=0;i<arr.length;i++){
                if(String.valueOf(arr[i]).equals(letraSelecionada)){
                    
                    StringBuilder String = new StringBuilder(listaPalavrasASeremDescobertas.get(x-1));
                    StringBuilder sb = String.replace(i, i+1, letraSelecionada);
                    listaPalavrasASeremDescobertas.remove(x-1);
                    listaPalavrasASeremDescobertas.add(x-1, sb.toString());
                    
                    switch(valorSorteado){
                        case PONTOS_1000:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao() + 1000);
                        break;
                        case PONTOS_500:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao() + 500);
                        break;
                        case PONTOS_400:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao() + 400);
                        break;
                        case PONTOS_200:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao() + 200);
                        break;
                        case PONTOS_100:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao() + 100);
                        break;
                        case PASSA_VEZ:
                            switch(listJogadores.size()){
                                case 2:
                                    if(jogadorCorrente.equals("Jogador1")){
                                        jogadorCorrente = "Jogador2";
                                    }
                               else if(jogadorCorrente.equals("Jogador2")){
                                        jogadorCorrente = "Jogador1";
                                    }
                                break;
                                case 3:
                                     if(jogadorCorrente.equals("Jogador1")){
                                        jogadorCorrente = "Jogador2";
                                    }
                               else if(jogadorCorrente.equals("Jogador2")){
                                        jogadorCorrente = "Jogador3";
                                    }
                               else if(jogadorCorrente.equals("Jogador3")){
                                        jogadorCorrente = "Jogador1";
                                    }
                                break;
                            }
                        break;
                        case PERDE_TUDO:
                            listJogadores.get(posicaoJogadorCorrenteNaLista-1).setPontuacao(0);
                        break;
                        
                    }
                    
                    validaSeLetraFoiEncontrada = true;

                }
            }
                
            System.out.println(listaPalavrasASeremDescobertas.get(x-1));
 
        }
        switch(qtdPalavras){
            case 1:
                if(!listaPalavrasASeremDescobertas.get(0).contains("#")){
                    terminouPalavras = true;
                    System.out.println(jogadorCorrente + " ganhou a etapa!");
                }
            break;
            case 2:
                if(!listaPalavrasASeremDescobertas.get(0).contains("#") && !listaPalavrasASeremDescobertas.get(1).contains("#")){
                    terminouPalavras = true;
                    System.out.println(jogadorCorrente + " ganhou a etapa!");
                }
            break;
            case 3:
                if(!listaPalavrasASeremDescobertas.get(0).contains("#") && !listaPalavrasASeremDescobertas.get(1).contains("#") && !listaPalavrasASeremDescobertas.get(2).contains("#")){
                    terminouPalavras = true;
                    System.out.println(jogadorCorrente + " ganhou a etapa!");
                }
            break;
        }

                 
//        if(Arrays.asList(listaPosicaoLetrasEncontradasPalavra1).contains(letraEscolhida)){
           

//        }
//                Iterator<String> iterator = listLetrasJaEscolhidas.iterator();
                
                // exibe os itens da lista usando um Iterator	
//                for(Iterator<String> it = listaPalavrasASeremDescobertas.iterator(); it.hasNext();){
//                  System.out.println(it.next());  
//                }
            System.out.println("O valor acumulado está em --> R$ " + listJogadores.get(posicaoJogadorCorrenteNaLista-1).getPontuacao());
            return validaSeLetraFoiEncontrada;
    }
  
    /** Método reisnsável por dar inicia a etapa.
     * @param paramtros recebe objeto com parametros iniciais do jogo
     * @param etapaAtual recebe o numero da etapa corrente.
     * @throws IOException usado para retornar exceções da leitura do arquivo de palavras. 
     */
    public static void iniciaEtapa(ParametrosIniciais paramtros, int etapaAtual) throws IOException{

     Iterator<String> it = listLetrasJaEscolhidas.iterator();
        while(it.hasNext()){
            if(it.next() != null){
                it.remove();
            }
        }
        
        Iterator<String> it2 = listPalavrasJaEscolhidas.iterator();
        while(it2.hasNext()){
            if(it2.next() != null){
                it2.remove();
            }
        }
        
        Iterator<String> it3 = listaPalavrasASeremDescobertas.iterator();
        while(it3.hasNext()){
            if(it3.next() != null){
                it3.remove();
            }
        }
     terminouPalavras = false;
     validaSeLetraFoiEncontrada = true;
     
     //-------------------------------------------------------------------------
    
    ArrayList<String> letrasEscolhidas = new ArrayList<>();
    Etapa etapa = new Etapa();
    Roleta roleta = new Roleta();
    etapa.setLstPalavras(LeitorArquivo.palavrasSorteadas());
    posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
    Scanner sc = new Scanner(System.in);
  
        System.out.println("\n\n ***** Etapa: " + etapaAtual + " --> DICA: " + etapa.getLstPalavras().get(0) + " ***** ");
        for(int x = 1; x <= paramtros.getQtdPalavras(); x++){
            String palavraOculta = "#";
                for(int i = 1; i < etapa.getLstPalavras().get(x).length(); i++){
                    palavraOculta = palavraOculta + "#";    
                } 
        listaPalavrasASeremDescobertas.add(palavraOculta);
            System.out.println(listaPalavrasASeremDescobertas.get(x-1));
        }
        
        for(int i = 0; i < paramtros.getQtdJogadores(); i++){
            Jogador jogador = new Jogador();
            jogador.setNome("Jogador" + (i+1));
            jogador.setPontuacao(0);
            listJogadores.add(jogador);
        }
     
        boolean validador = true; 
        boolean sair = false;

        while (terminouPalavras == false && sair == false) {

            if(validaSeLetraFoiEncontrada == true){
                valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                System.out.println("Valor sorteado foi --> " + valorSorteado + "\n");
                if(String.valueOf(valorSorteado).equals("PASSA_VEZ") || String.valueOf(valorSorteado).equals("PERDE_TUDO")){
                    switch(listJogadores.size()){
                                case 2:
                                    boolean val = false;
                                    if(jogadorCorrente.equals("Jogador1")){
                                        jogadorCorrente = "Jogador2";
                                        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
                                        valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                                        System.out.println("Valor sorteado foi --> " + valorSorteado + "\n");
                                        val = true;
                                    }
                               else if(jogadorCorrente.equals("Jogador2") && val == false){
                                        jogadorCorrente = "Jogador1";
                                        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
                                        valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                                        System.out.println("Valor sorteado foi --> " + valorSorteado + "\n");
                                    }
                                break;
                                case 3:
                                    boolean val1 = false;
                                    boolean val2 = false;
                                     if(jogadorCorrente.equals("Jogador1")){
                                        jogadorCorrente = "Jogador2";
                                        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
                                        valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                                        System.out.println("Valor sorteado foi --> " + valorSorteado + "\n");
                                        val1 = true;
                                    }
                               else if(jogadorCorrente.equals("Jogador2") && val1 == false){
                                        jogadorCorrente = "Jogador3";
                                        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
                                        valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                                        System.out.println("Valor sorteado foi --> " + valorSorteado + "\n");
                                        val2 = true;
                                    }
                               else if(jogadorCorrente.equals("Jogador3") && val1 == false && val2 == false){
                                        jogadorCorrente = "Jogador1";
                                        posicaoJogadorCorrenteNaLista = Integer.parseInt(jogadorCorrente.substring(7, 8));
                                        valorSorteado = roleta.roda(listJogadores.get(posicaoJogadorCorrenteNaLista -1));
                                        System.out.println("Valor sorteado foi --> " + valorSorteado);
                                    }
                                break;
                            }
                }
                jogadorEscolheLetra(jogadorCorrente);
                validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
//                jogadorEscolheLetra(jogadorCorrente);
                if(validador == true){
                        System.out.println("Deseja informar as palavras? \n"
                                         + "Informe 1 para Sim e 2 para não!" + "\n\n");
                        int resposta = Integer.parseInt(sc.nextLine());
                        if(resposta == 1){
                            List<String> palavrasDigitadas = new ArrayList<>();
                            palavrasDigitadas = jogadorEscolhePalavras(jogadorCorrente);
                            switch(paramtros.getQtdPalavras()){
                                case 1:
                                    if(etapa.getLstPalavras().get(1).equals(palavrasDigitadas.get(0))){
                                        System.out.println("Partida encerrada!"
                                                         + jogadorCorrente + " ganhou a etapa!");
                                        sair = true;
                                    }
                                    else{
                                        System.out.println("As palavras digitadas estão incorretas!");
                                    }
                                break;

                                case 2:
                                    if(etapa.getLstPalavras().get(1).equals(palavrasDigitadas.get(0)) && etapa.getLstPalavras().get(2).equals(palavrasDigitadas.get(1))){
                                        System.out.println("Partida encerrada!"
                                                         + jogadorCorrente + " ganhou a etapa!");
                                        sair = true;
                                    }
                                    else{
                                        System.out.println("As palavras digitadas estão incorretas!");
                                    }
                                break;

                                case 3:
                                    if(etapa.getLstPalavras().get(1).equals(palavrasDigitadas.get(0)) && etapa.getLstPalavras().get(2).equals(palavrasDigitadas.get(1))&& etapa.getLstPalavras().get(3).equals(palavrasDigitadas.get(2))){
                                        System.out.println("Partida encerrada!"
                                                         + jogadorCorrente + " ganhou a etapa!");
                                        sair = true;
                                    }
                                    else{
                                        System.out.println("As palavras digitadas estão incorretas!");
                                    }
                                break;
                            }

                        }
                }
            }
            else{
                switch(paramtros.getQtdJogadores()){
                    
                    case 1:
                        if(!listaPalavrasASeremDescobertas.get(0).contains("#")){
                            terminouPalavras = true;
                            System.out.println(jogadorCorrente + " ganhou a etapa!");
                        }
                        if(qtdErrosJogador < 3){
                            jogadorEscolheLetra(jogadorCorrente);
                            validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                            qtdErrosJogador = qtdErrosJogador + 1;
                        }
                        else{
                            System.out.println("Você perdeu, pratique mais!"); 
                            sair = true;
                        }
                       
                    break;
                    
                    case 2:
                        boolean jaPercorreuAnterior = false;
                         if(jogadorCorrente.equals(listJogadores.get(0).getNome())){ 
                             jogadorCorrente = listJogadores.get(1).getNome();
                             jogadorEscolheLetra(jogadorCorrente);
                             validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                             jaPercorreuAnterior = true;
                         }
                         if(jogadorCorrente.equals(listJogadores.get(1).getNome()) && jaPercorreuAnterior == false){    
                            jogadorCorrente = listJogadores.get(0).getNome();
                            jogadorEscolheLetra(jogadorCorrente);
                            validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                         }
                    break;
                        
                    case 3:
                        boolean jaPercorreuAnterior1 = false;
                        boolean jaPercorreuAnterior2 = false;
                         if(jogadorCorrente.equals(listJogadores.get(0).getNome()) && jaPercorreuAnterior1 == false){ 
                             validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                             if(validador == false){
                                jogadorCorrente = listJogadores.get(1).getNome();
                                jogadorEscolheLetra(jogadorCorrente);
                             }
                             jaPercorreuAnterior1 = true;
                         }
                         if(jogadorCorrente.equals(listJogadores.get(1).getNome()) && jaPercorreuAnterior1 == false){ 
                             validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                             if(validador == false){
                                jogadorCorrente = listJogadores.get(2).getNome();
                                jogadorEscolheLetra(jogadorCorrente); 
                             }
                             jaPercorreuAnterior2 = true;
                         }
                         if(jogadorCorrente.equals(listJogadores.get(2).getNome()) && jaPercorreuAnterior1 == false && jaPercorreuAnterior2 == false){ 
                             validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
                             if(validador == false){
                                jogadorCorrente = listJogadores.get(0).getNome();
                                jogadorEscolheLetra(jogadorCorrente);  
                             }
                         }
                    break;    
                }
              
            }
        }
 
    }
    
}
