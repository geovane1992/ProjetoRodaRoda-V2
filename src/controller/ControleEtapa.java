package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.Etapa;
import model.Jogador;
import model.ParametrosIniciais;

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
    
    public ControleEtapa(int etapa, Observado obs){
        this.etapa = etapa;
        obs.incluirObservador(this);
    }

    @Override
    public void updateLetra(String letra) {
        letraSelecionada = letra;
        
    }

    @Override
    public void updatePalavra(String palavra) {
        palavraSelecionada = palavra;
    }
    
    public static void jogadorEscolheLetra(String jogad){
        Scanner leitor = new Scanner(System.in);
        System.out.println(jogad + " informe uma letra!");
        String letraEscolhida = leitor.nextLine();
        letraSelecionada = letraEscolhida;
        
        PalpiteLetra letra = new PalpiteLetra();
        Observador jogador = new ControleJogador(jogad, letra);
        letra.receberLetras(letraEscolhida);
        listLetrasJaEscolhidas.add(letraEscolhida);
    }
    
    public static List<String> jogadorEscolhePalavras(String jogad){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe uma palavra!");
        String palavraEscolhida = leitor.nextLine();
        
        PalpitePalavra palavra = new PalpitePalavra();
        Observador jogador = new ControleJogador(jogad, palavra);
        palavra.receberPalavra(palavraEscolhida);
        listPalavrasJaEscolhidas.add(palavraEscolhida);
        
        return listPalavrasJaEscolhidas;
    }
    
    public static boolean mostraPalavrasAacertar(int qtdPalavras, List<String> listaPalavrasEtapa){
        
        System.out.println(listaPalavrasEtapa.get(1));
        System.out.println(listaPalavrasEtapa.get(2));
        System.out.println(listaPalavrasEtapa.get(3));
        validaSeLetraFoiEncontrada = false;

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
            return validaSeLetraFoiEncontrada;
    }
  
    
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
    etapa.setLstPalavras(LeitorArquivo.palavrasSorteadas());
    Scanner sc = new Scanner(System.in);
  
        System.out.println("***** Etapa: " + etapaAtual + " --> DICA: " + etapa.getLstPalavras().get(0) + " ***** ");
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
                jogadorEscolheLetra(jogadorCorrente);
                validador = mostraPalavrasAacertar(paramtros.getQtdPalavras(), etapa.getLstPalavras());
//                jogadorEscolheLetra(jogadorCorrente);
                
                System.out.println("Deseja informar as palavras? \n"
                                 + "Informe 1 para Sim e 2 para não!");
                int resposta = sc.nextInt();
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
