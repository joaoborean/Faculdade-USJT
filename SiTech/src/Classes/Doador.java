package Classes;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Doador {

    private String nome;
    private String CPF;
    private String sexo;
    private String tiposanguineo;
    private String celular;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void inserir() throws SQLException {

        String sql = "INSERT INTO doador (nome, CPF, sexo, tiposanguíneo, celular, email)"
                + "VALUES (?, ?, ?, ?,?,?)";
        System.out.println(sql);

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 
            ps.setString(1, nome);
            ps.setString(2, CPF);
            ps.setString(3, sexo);
            ps.setString(4, tiposanguineo);
            ps.setString(5, celular);
            ps.setString(6, email);
            ps.execute();

            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro !!!");
        }
    }

    public void Delete() throws SQLException {
        String sql = "Delete From Doador where CPF =?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            /* teste para ver se puxa*/
            //System.out.println("CPF" + CPF);
            ps.setString(1, CPF);
            ps.execute();
            System.out.println("Perfil Deletado!");
        } catch (Exception e) {
            System.out.println("Erro, NÃ£o foi possivel deletar!");
        }

    }

    public void Atualizar() throws SQLException {
        String sql = "update Doador SET nome=?, celular=? ,email=? WHERE CPF=?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, celular);
            ps.setString(4, CPF);
            ps.execute();

            System.out.println("Atualizão Feita!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }

    public void Tabela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
