package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import model.Livro;

public class LivroDAO {
public void cadastrarLivro(Livro Livro){
        
            String sql = "INSERT INTO Livro (idLivro, nome, preco) VALUES ("
                + "'" + Livro.getCodigo() + "',"
                + "'" + Livro.getNome()+ "',"
                + "" + Livro.getPreco() + ")"
                + "" + Livro.getGenero() + ")";

            Conexao.executar(sql);
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
        
    }
    
    //public void  editar(int cod){
        //String sql = "UPDATE Livro SET"
                //+ " nome = '" + cod.getNome() + "',"
               // + "preco = " +cod.getPreco() + ""
                //+ "WHERE idLivro = " +cod.getCodigo();
        
       // Conexao.executar(sql);
    //}
    
    public ArrayList<Livro> getLivro(){
        ArrayList<Livro> lista = new ArrayList();
        String sql = "SELECT idLivro,nome, preco FROM Livro ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                while(rs.next()){
                    int codigo = rs.getInt("idLivro");
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");
                    Livro prod = new Livro(codigo, nome, preco, nome);
                    lista.add(prod);
                }
            } catch(Exception e){
                
            }
        }
        return lista;
    }
    
    public  void excluir(Livro p){
        String sql = "DELETE FROM Livro WHERE idLivro = " + p.getCodigo();
        Conexao.executar(sql);
    }
}
