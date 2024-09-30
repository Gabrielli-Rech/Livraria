package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.LivroDAO;
import dao.LivroPedidoDAO;

public class LivroPedido {
static int cont = 0;
    private int id_has;
    private int id;
    private int idPedido;
    private int idLivro;
    private int qntd;
    private String Livro_nome;
    private double precoTotal;
    private String genero;

    public LivroPedido(int id_has,  int idPedido, int idLivro, int qntd, String Livro_nome, double precoTotal, String genero) {
        this.id_has = id_has;
        this.idPedido = idPedido;
        this.idLivro = idLivro;
        this.qntd = qntd;
        this.Livro_nome = Livro_nome;
        this.precoTotal = precoTotal;
        this.genero = genero;
        boolean verificador;
        
        
    }
    
    public LivroPedido(){
        
    }

    

    public int getId_has() {
        return id_has;
    }

    public void setId_has(int id_has) {
        this.id_has = id_has;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public String getLivro_nome() {
        return Livro_nome;
    }

    public void setLivro_nome(String Livro_nome) {
        this.Livro_nome = Livro_nome;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
        public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void AtualizarLivroPedido(LivroPedido ip){
        LivroPedidoDAO ipd = new LivroPedidoDAO();
        ipd.editarLivroPedido(ip);
        
    }
    
    public int indiceLivroPedido(){
        LivroPedidoDAO ip = new LivroPedidoDAO();
        ArrayList<LivroPedido> lista = ip.carregarItensPedido();
        
        int indice = lista.size();
        int ind =0;
        if(indice<1) {
            ind = 0;
        } else {
            for(LivroPedido ipl : lista){
                
                    ind = ipl.getId_has()+1;
                
            }
        }
        return ind;
        
    }
    
        public void registrarLivroPedido(Livro p1){
        LivroPedido ip = new LivroPedido();
        Pedido p = new Pedido();
        int ind = this.indiceLivroPedido();
        
        
        ip.setIdPedido(p.pedidoAtual());
        ip.setPrecoTotal(p1.getPreco());
        ip.setIdLivro(p1.getCodigo());
        ip.setQntd(1);
        ip.setId_has(ind);
        ip.setId(cont);
        LivroPedidoDAO ipd = new LivroPedidoDAO();
        ipd.cadastrarLivroPedido(ip);
        cont++;
    }
        
        public boolean VerificarLivroPedido(int cod){
            boolean verificador = false;
            LivroDAO pd = new LivroDAO();
            ArrayList<Livro> lista = pd.getLivro();
            for(Livro p: lista){
                if(p.getCodigo() == cod){
                    verificador = true;
                }
            }
            if(verificador == false){
                JOptionPane.showMessageDialog(null, "Livro não registrado");
            }
            
            
            return verificador;
            
            
        }
        
        
        
        
        public void removerLinhas(DefaultTableModel model){
        cont = 0;
        
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
    }
        
        public double removerLivroPedido(int cod, ArrayList<LivroPedido> array, DefaultTableModel model){
            LivroPedido selecionado = array.get(cod);
            double valor = selecionado.getPrecoTotal();
            array.remove(cod);
            LivroPedidoDAO ipd = new LivroPedidoDAO();
            ipd.excluirLivroPedido(selecionado.getId_has());
            
            return valor;
        }
}
