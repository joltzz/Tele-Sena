public class Pessoa
{
    //DEFININDO OS METODOS
    private String nome;
    private double Premiacao;
    private TeleSena[] teleSenasCompradas;

    //DEFININDO O LIMITE MAXIMO DE COMPRAS POR PESSOA(NO CASO 15)
    public Pessoa(String nome)
    {
        this.nome = nome;
        this.Premiacao = 0;
        teleSenasCompradas = new TeleSena[(int) ((Math.random( )*15)+1)];
    }
    //DEFININDO OS METODOS GET E SET
    public String getNome() {return this.nome;}

    public TeleSena[] getTeleSenasCompradas() {return this.teleSenasCompradas;}

    public double getValorPremiacao() {return this.Premiacao;}

    public void setPremiacao(double valor) {this.Premiacao = valor;}

    //PARA SABER O PREMIO DEPOIS/FINANCEIRO
    public void insereTeleSena()
    {
        for (int i=0; i<getTeleSenasCompradas().length; i++)
        {
            TeleSena t = new TeleSena(); // cria instancia de TeleSena
            this.teleSenasCompradas[i] = t; //adiciona a instancia na posicao i
        }
    }

}