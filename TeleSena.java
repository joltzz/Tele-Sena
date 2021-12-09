public class TeleSena
{
    // DEFININDO OS METODOS
    private int[] Tabela1;
    private int[] Tabela2;
    private static double Venda;

    //DEFININDO A VENDA/QUANTIDADE DE NUMEROS POR TABELA
    public TeleSena()
    {
        TeleSena.Venda = 10.00;
        Tabela1 = new int[25];
        GeraTabela(Tabela1);
        Tabela2 = new int[25];
        GeraTabela(Tabela2);
    }
    //DEFININDO O MATH.RANDOM VAI GERAR OS NUMEROS DA TABELA E QUANTIDADE VENDIDA
    public void GeraTabela(int[] tabelas)
    {
        int i = 0;
        while (i < tabelas.length) {
            tabelas[i] = (int) ((Math.random() * 60) + 1);
            boolean x = false;
            for (int j = 0; j < i; j++) {
                if (tabelas[i] == tabelas[j]) {
                    x = true;
                    break;
                }
            }
            if (!x) {
                i++;
            }
        }
    }
    //DEFININDO OS METODOS GET/SET
    public int[] getTabelas1() {return this.Tabela1;}

    public int[] getTabelas2() {return this.Tabela2;}

    public double getValorVenda() {return TeleSena.Venda;}

    //METODO ToString
    public String toString()
    {
        String s = " > " ;
        for (int i = 0; i<25; i++)
        {
            s += this.Tabela1[i] + "  ";
        }
        s += "\n > ";
        for (int i = 0; i<25; i++)
        {
            s += this.Tabela2[i] + "  ";
        }
        s+= "\n";
        return s;
    }
}