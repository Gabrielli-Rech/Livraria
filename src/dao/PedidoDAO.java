package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Pedido;

public class PedidoDAO {
Pedido pedido;
    
    public void cadastrarPedido(Pedido p){
        String sql = "INSERT INTO pedido(idpedido, tipo_pagamento, cpf, total) VALUES ("
                + "" + p.getId() + ","
                + "'"+ p.getTipoPagamento() +"',"
                + "'" + p.getCpf() + "',"
                + "" + p.getTotal() + ")";
        Conexao.executar(sql);
    }
    
    public void editarPedido(Pedido p){
        String sql = "UPDATE pedido SET"
                + " tipo_pagamento = '" + p.getTipoPagamento() +"',"
                + " cpf = '" + p.getCpf() + "',"
                + " data = now(),"
                + " total = " + p.getTotal() + ""
                + " WHERE pedido.idpedido = " + p.getId();
        Conexao.executar(sql);
    }
    public void excluir(int cod ){
        String sql = "DELETE FROM pedido WHERE pedido.idpedido = " + cod;
        Conexao.executar(sql);
    }
    public ArrayList<Pedido> carregarPedidos(){
        ArrayList<Pedido> lista = new ArrayList();
        String sql = "SELECT idpedido, tipo_pagamento, cpf, total, data FROM pedido";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try {
                while(rs.next()){
                    int codigo = rs.getInt("idpedido");
                    String pagamento = rs.getString("tipo_pagamento");
                    String cpf = rs.getString("cpf");
                    double total = rs.getDouble("total");
                    String data = rs.getString("data");
                    Pedido p = new Pedido(codigo, pagamento, cpf, total, data);
                    lista.add(p);
                    
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }
}
