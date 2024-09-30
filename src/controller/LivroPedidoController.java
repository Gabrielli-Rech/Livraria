package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Livro;
import model.LivroPedido;

public class LivroPedidoController {
static int cont = 0;
    //DefaultTableModel model
    public LivroPedido cadastrarLivroPedido(int cod, ArrayList<LivroPedido> array){
        boolean verificador = false;
        
        LivroPedido ip = new LivroPedido();
        Livro pi = new Livro();
        ArrayList<Livro> lista = pi.getLivro();

        
        for(Livro p : lista){
            if(p.getCodigo() == cod){
                PedidoController pc = new PedidoController();
                ip.setId_has(this.indiceLivroPedido());
                ip.setLivro_nome(p.getNome());
                ip.setQntd(1);
                ip.setPrecoTotal(p.getPreco());
                ip.setIdLivro(p.getCodigo());
                ip.registrarLivroPedido(p);
                
            //String[] coluna = {"","","","",""};
            //coluna[0] = String.valueOf(cont);
            //coluna[1] = String.valueOf(ip.getIdLivro());
            //coluna[2] = String.valueOf(ip.getLivro_nome());
            //coluna[3] = String.valueOf(1);
            //coluna[4] = String.valueOf(ip.getPrecoTotal());
            //model.addRow(coluna);
            array.add(ip);
            verificador = true;

            
            
        }

        }
        
        if(!verificador){
                JOptionPane.showMessageDialog(null, "nenhum Livro cadastrado com esse codigo");
                ip = null;
        }
        return ip;
        
    }
    
    
    public void atualizarLivroPedido(LivroPedido ip){
        LivroPedido ipm = new LivroPedido();
        ipm.AtualizarLivroPedido(ip);
        
        
        
    }
    
    public int indiceLivroPedido(){
        LivroPedido ip = new LivroPedido();
        int indice = ip.indiceLivroPedido();
        return indice;
    }
    
    public void removerLinhas(DefaultTableModel model){
        cont = 0;
        
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
    }
    
    public void atualizarTabela(DefaultTableModel model, ArrayList<LivroPedido> array){
        this.removerLinhas(model);
        for(LivroPedido p : array){
            String[] coluna = {"","","","",""};
            coluna[0] = String.valueOf(cont);
            coluna[1] = String.valueOf(p.getIdLivro());
            coluna[2] = String.valueOf(p.getLivro_nome());
            coluna[3] = String.valueOf(p.getQntd());
            coluna[4] = String.valueOf(p.getPrecoTotal());
            coluna[5] = String.valueOf(p.getGenero());
            model.addRow(coluna);
            cont++;
        }
    }
    
    public boolean VerificarLivroPedido(int cod){
        LivroPedido ip = new LivroPedido();
        return ip.VerificarLivroPedido(cod);
    }
    
    public double removerLivroPedido(int cod, ArrayList<LivroPedido> array, DefaultTableModel model){
                LivroPedido ip = new LivroPedido();
                double valor = ip.removerLivroPedido(cod, array, model);
                this.removerLinhas(model);
                this.atualizarTabela(model, array);
                
                return valor;
    }
    
    
}
