package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.LivroPedido;
import model.Pedido;

public class PedidoController {
public int quantidadePedidos(){
        Pedido pd = new Pedido();
        ArrayList<Pedido> lista = new ArrayList();
        lista = pd.carregarPedidos();
        return lista.size();
    }
    
    public int PedidoAtual(){
        Pedido p = new Pedido();
        return p.pedidoAtual();
    }
    
    public void criarPedido(){
        // caso o ultimo pedido tenha o total 0, ele atualiza a data e usa ele, ao inves de criar um do zero; se não existir nenhum pedido no banco, ele cria um com id 0
        int cont =0;
        if(this.quantidadePedidos()<1){
            cont = 0;
            Pedido p = new Pedido();
            p.setId(cont);
            Pedido pd = new Pedido();
            pd.cadastrarPedido(p);
            
        }else{
            cont = this.quantidadePedidos();
            Pedido pd = new Pedido();
            ArrayList<Pedido> lista = pd.carregarPedidos();
            Pedido p = lista.get(lista.size()-1);
            if(p.getTotal() == 0){
                
            }else{
                Pedido pe = new Pedido();
                pe.setId(cont);

                pd.cadastrarPedido(pe);
            }
        
            
        }
    }
    
    public void EditarPedido(int cod,String cpf, String pagamento, double total, ArrayList<LivroPedido> array){
        if(pagamento == ""){
            JOptionPane.showMessageDialog(null, "Escolha a forma de pagamento");
        } else if(cod != 0){
            Pedido pm = new Pedido();
            pm.editarPedido(cpf,pagamento,total);
            this.criarPedido();
            LivroPedidoController ip = new LivroPedidoController();
            array.clear();
            
        }
    }
    
}
