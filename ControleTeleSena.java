public class ControleTeleSena
{
    private Pessoa[] participantes;
    private int QuantidadeParticipantes;
    private int QuantidadeVendida;
    private double valorTotalVendas;
    private double Premio;
    private double lucro;
    static int[] Sorteados;
    static int quantGanhador;
    static boolean Ganhador;

    public ControleTeleSena()
    {
        participantes = new Pessoa[20];
        this.QuantidadeVendida = 0;
        this.valorTotalVendas = 0;
        this.Premio = 0;
        this.lucro = 0;

    }

    public Pessoa[] getParticipantes() {return this.participantes;}

    public int getQuantidadeVendida() {return this.QuantidadeVendida;}

    public double getValorTotalVendas() {return this.valorTotalVendas;}

    public double getValorPremio() {return this.Premio;}

    public double getLucro() {return this.lucro;}


    //METODO QUE AUMENTA A QUANTIDADE DE TELE SENAS VENDIDAS
    public void AumentaQuantidadeVendida(Pessoa p1) {this.QuantidadeVendida += p1.getTeleSenasCompradas().length;}

    //METODO QUE CALCULA O VALOR TOTAL DE VENDAS
    public void CalculaValorTotalVendas() {valorTotalVendas = QuantidadeVendida * 10.00;}

    //METODO QUE CALCULA O VALOR DO PREMIO
    public void CalculaPremio() {this.Premio = valorTotalVendas * 0.8;}

    //METODO QUE CALCULA O VALOR DO LUCR0
    public void CalculaLucro() {this.lucro = valorTotalVendas - this.Premio;}

    //ARRAY RESPONSAVEL POR INSERIR AS PESSOAS NO PARTICIPANTES
    public void InserePessoa(Pessoa p) {participantes[QuantidadeParticipantes] = p; QuantidadeParticipantes++;}

    public void ImprimirInformacoes()
    {
        System.out.println("\n ---------------------------------------------------------");
        System.out.printf("|\t%9s\t%19s", "* VALOR DE VENDAS: R$" +  this.valorTotalVendas, "|\n");
        System.out.printf("|\t%9s\t%11s", "* QUANTIDADES VENDIDAS: " +  this.QuantidadeVendida + " Tele Senas", "|\n");
        System.out.printf("|\t%9s\t%19s", "* VALOR DA PREMIAÇÃO: R$" +  this.Premio, "|\n");
        System.out.printf("|\t%7s\t%27s", "* LUCRO TOTAL: R$" +  this.lucro, "|\n");
        System.out.println(" ---------------------------------------------------------");


    }

    //METODO PARA GERAR OS NUMEROS SORTEADOS
    public static void GeraNumerosSorteados(int[] Sorteados)
    {

        int i = 0;
        while (i < 60) {
            Sorteados[i] = (int) ((Math.random() * 60) + 1);
            boolean x = false;
            for (int j = 0; j < i; j++) {
                if (Sorteados[i] == Sorteados[j]) {
                    x = true;
                    break;
                }
            }
            if (!x) {
                i++;
            }
        }

    }

    //MÉTODO QUE VERIFICA QUEM É O GANHADOR DA TELE SENA.
    public Pessoa[] verificaGanhardor()
    {
        int imprimirErro = 1; // VARIAVEL AUX PARA IMPRIMIR "NENHUM VENCEDOR, SERA FEITO UM NOVO SORTEIO"
        Pessoa[] ganhadores = new Pessoa[20];
        Ganhador = false;
        int quantVezesTentadas = 0; //  VARIAVEL AUX PARA ARMAZENAR O NUMERO DE VEZES TENTADAS E IR AUMENTANDO A QUANTIDADE QUE FOR NECESSARIA DE NUMEROS SORTEADOS ESCOLHIDOS

        while (!Ganhador) {
            for (Pessoa p : participantes) {
                int a = 0;
                for (TeleSena ts : p.getTeleSenasCompradas()) {
                    a = 0;
                    for (int n : ts.getTabelas1()) { // FOR PARA PERCORRER A TABELA 1 DE CADA TELE SENA
                        for (int i = 0; i < 25 + quantVezesTentadas; i++) {
                            if (Sorteados[i] == n) {
                                a++;
                                if (a == 25) //AO CHEGAR EM 25 ACERTOS, A PESSOA É DIRECIONADA PARA O ARRAY DE GANHADOR
                                {
                                    ganhadores[quantGanhador] = p;
                                    quantGanhador++;
                                    Ganhador = true;
                                }
                            }
                        }
                    }
                    a = 0;
                    for (int n : ts.getTabelas2()) { // FOR PARA PERCORRER A TABELA 2 DE CADA TELE SENA
                        for (int i = 0; i < 25 + quantVezesTentadas; i++) {
                            if (Sorteados[i] == n) {
                                a++;
                                if (a == 25) {
                                    ganhadores[quantGanhador] = p;
                                    quantGanhador++;
                                    Ganhador = true;
                                }
                            }
                        }
                    }
                }
            }
            quantVezesTentadas++;
            // CASO NAO ACHE GANHADOR IMPRIME A MENSAGEM E IMPRIME OS NOVOS NUMEROS SORTEADOS
            if (!ControleTeleSena.Ganhador)
            {
                while ( imprimirErro == 1) //IMPRIMIR APENAS UMA VEZ A MENSAGEM
                {

                    System.out.printf("\n\t%34s\t%36s", "NENHUM VENCEDOR, SERA FEITO UM NOVO SORTEIO", "|\n");
                    System.out.println(" +-------------------------------------------------------------------------------------------------------+");

                    //pausa de sistema
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {}
                    imprimirErro++;
                }

                //pausa de sistema
                try {
                    Thread.sleep(500);
                } catch (Exception e) {}
                System.out.print("  " + Sorteados[25 + quantVezesTentadas] );


            }
        }
        return ganhadores; //retorna os vencedores
    }



}




