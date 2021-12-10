public class Principal
{
    public static void main(String[] args) {
        ControleTeleSena controle = new ControleTeleSena();
        //começo do programa

        //criação dos nomes dos participantes
        String [] nomes = { "Renato", "Doga10", "Bressan", "Marcelo Moreno","Ramiro", "Barcos", "Luan" , "Bolaños", "Arthur", "Grohe",
                "Kannemann", "Geromito", "Maicon", "Pará" ,"Leo Moura" , "Paulo Nunes", "Jardel", "Danrlei", "Tarciso", "Ronaldinho"};

        for (int i = 0; i < 20; i++) {
            Pessoa participante = new Pessoa(nomes[i]); //cria as instâncias
            participante.insereTeleSena(); //
            controle.InserePessoa(participante);
            controle.AumentaQuantidadeVendida(participante);
        }

        //geração dos numeros da tele sena
        ControleTeleSena.Sorteados = new int[60];
        ControleTeleSena.GeraNumerosSorteados(ControleTeleSena.Sorteados);


        //impressao dos numeros que foram gerados
        System.out.println(" [--------------------------------- BEM-VINDOS A TELE SENA ------------------------------------]");
        System.out.printf("\t%58s\t%36s", "SORTEIO DOS NÚMEROS PREMIADOS!", "\n");
        //tempo de pausa do sistema
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}


        for (int i = 0; i<25; i++ )
        {
            if (i == 0)
                System.out.printf("%9s", ControleTeleSena.Sorteados[i] + "  ");
            else
                System.out.print(ControleTeleSena.Sorteados[i] + "  ");
            //tempo de pausa do sistema
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
        System.out.println("\n *--------------------------------------------------------------------------------------------------------*");


        //calculando...
        controle.CalculaValorTotalVendas();
        controle.CalculaPremio();
        controle.CalculaLucro();


        //verificador para caso haja algum ganhador nessa rodada
        Pessoa[] ganhadores = controle.verificaGanhardor(); //GUARDA OS GANHADORES
        double premioGanhador = controle.getValorPremio() / ControleTeleSena.quantGanhador; // VALOR TOTAL E DIVIDIDO PELA QTDD DE GANHADORES

        for (Pessoa p : ganhadores)
        {
            if (p != null)
            {	//impressao do ganhador da tele sena
                System.out.println("\n\n ####################################################################################################\\_");
                System.out.printf("|\t%52s\t%44s", "GANHADOR(A): " + p.getNome(), "|\n");
                System.out.printf("|\t%52s\t%44s", "PRÊMIO: R$" + premioGanhador, "|\n");
                System.out.println(" ######################################################################################################\n");

                p.setPremiacao(premioGanhador); //muda o valor do prêmio do ganhador
            }
        }

        //tempo de pausa do sistema
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}
        MenuDeOpcoes(controle);

    }    /*
     * metodo para imprimir o menu de opções do usuario
     * a primeira imprime as infos dos arreys de todas tele senas
     * a segunda imprime infos adicionais
     * terminar o sistema
     */
    public static void MenuDeOpcoes(ControleTeleSena controle)
    {
        System.out.println("\n +------------------------ MENU -------------------------+");
        System.out.printf("| %10s\t%4s", "1 - Ver as Tele Senas de todos os participantes", "\n");
        System.out.printf("| %10s\t%20s", "2 - Imprimir informacoes adicionais", "|\n");
        System.out.printf("| %8s\t%44s", "3 - Finalizar", "|\n");
        System.out.println(" ---------------------------------------------------------");
        int opcao = Teclado.leInt();

        //menu de verificação das opções digitadas
        switch (opcao) {
            //verificação caso numero for 1
            case 1:
                for (Pessoa p : controle.getParticipantes())
                {

                    System.out.println(" =========================================================================================================");
                    System.out.println(p.getNome());

                    for (int i=0; i<p.getTeleSenasCompradas().length; i++) //imprimir todas as tele senas compradas
                    {
                        System.out.println(p.getTeleSenasCompradas()[i]);

                    }

                }
                //tempo de pausa do sistema
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}

                MenuDeOpcoes(controle);
                break;
            //verificação caso numero for 2
            case 2:
                controle.ImprimirInformacoes();
                MenuDeOpcoes(controle);
                break;
            //verificação caso numero for 3
            case 3:
                System.out.printf("|\t%58s\t%36s", "OBRIGADO!", "\n");
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }
}