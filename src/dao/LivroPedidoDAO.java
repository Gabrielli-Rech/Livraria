package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.LivroPedido;

public class LivroPedidoDAO {

    public void cadastrarLivroPedido(LivroPedido ip){
        String sql = "INSERT INTO livro_has_pedido(id_livro_has_pedido, qtd, precototal, livro_idlivro, pedido_idpedido) VALUES("
                + "" + ip.getId_has() + ","
                + "" + ip.getQntd() + ","
                + "" + ip.getPrecoTotal() + ","
                + "" + ip.getIdLivro() + ","
                + "" + ip.getIdPedido() + ")";
        
        Conexao.executar(sql);
    }
    
    public void editarLivroPedido(LivroPedido ip){
        String sql = "UPDATE livro_has_pedido SET "
                + "livro_idlivro = " + ip.getIdLivro() + ","
                + "pedido_idpedido = " + ip.getIdPedido() + ","
                + "qtd = " + ip.getQntd() + ","
                + "precototal = " + ip.getPrecoTotal() + ""
                + "WHERE id_livro_has_pedido = " + ip.getId_has();
        System.out.println(sql);
        Conexao.executar(sql);
        
        
    }
    
    public void excluirLivroPedido(int cod){
        String sql = "DELETE FROM livro_has_pedido WHERE id_livro_has_pedido = " + cod;
        Conexao.executar(sql);
    }
    
    public ArrayList<LivroPedido> carregarItensPedido(){
        ArrayList<LivroPedido> lista = new ArrayList();
        String sql = "SELECT livro_has_pedido.id_livro_has_pedido, livro_has_pedido.pedido_idpedido, livro.nome, livro.idlivro, livro_has_pedido.qtd, livro_has_pedido.precototal, pedido.idpedido FROM livro_has_pedido, livro, pedido"
                    + " WHERE livro_has_pedido.pedido_idpedido = pedido.idpedido AND livro_has_pedido.livro_idlivro = livro.idlivro"
                    + " ORDER BY id_livro_has_pedido";
        System.out.println("abcd");
        ResultSet rs = Conexao.consultar(sql);
        
        if(rs != null){
            try {
                int cont = 0;
                while(rs.next()){
                    int cod = rs.getInt("livro_has_pedido.id_livro_has_pedido");
                    String livro_nome = rs.getString("livro.nome");
                    int id_livro = rs.getInt("livro.idlivro");
                    int id_pedido = rs.getInt("pedido.idpedido");
                    int qtd = rs.getInt("livro_has_pedido.qtd");
                    double preco_total = rs.getDouble("livro_has_pedido.precototal");
                    
                    LivroPedido ip = new LivroPedido(cod,id_livro,id_pedido,qtd,livro_nome,preco_total, livro_nome);
                    lista.add(ip);
                    cont++;
                    
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }
}
