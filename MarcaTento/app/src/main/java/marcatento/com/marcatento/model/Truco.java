package marcatento.com.marcatento.model;

/**
 * Created by fernando on 24/11/17.
 */

public class Truco {
    private Integer pk_id;
    private Integer vencedor;
    private Integer pontosNos;
    private Integer pontosEles;
    private String duracao;

    public Truco(){ /*Construtor Vazio */}

    public Truco(Integer vencedor, Integer pontosNos, Integer pontosEles, String duracao){
        this.vencedor = vencedor;
        this.pontosNos = pontosNos;
        this.pontosEles = pontosEles;
        this.duracao = duracao;
    }


    public Truco(Integer pk_id, Integer vencedor, Integer pontosNos, Integer pontosEles, String duracao){
        this.pk_id = pk_id;
        this.vencedor = vencedor;
        this.pontosNos = pontosNos;
        this.pontosEles = pontosEles;
        this.duracao = duracao;
    }

    public Integer getPk_id(){
        return this.pk_id;
    }
    public void setPk_id(Integer pk_id){
        this.pk_id = pk_id;
    }

    public Integer getVencedor(){
        return this.vencedor;
    }
    public void setVencedor(Integer vencedor){
        this.vencedor = vencedor;
    }

    public Integer getPontosNos(){
        return this.pontosNos;
    }
    public void setPontosNos(Integer pontosNos){
        this.pontosNos = pontosNos;
    }

    public Integer getPontosEles(){
        return this.pontosEles;
    }
    public void setPontosEles(Integer pontosEles){
        this.pontosEles = pontosEles;
    }

    public String getDuracao(){
        return this.duracao;
    }
    public void setDuracao(String duracao){
        this.duracao = duracao;
    }
}
