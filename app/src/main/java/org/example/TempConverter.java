package org.example;

import java.util.Scanner;

public class TempConverter {
    private Double conversao;
    private String tipoConversao;

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        if (tipoConversao.isBlank()){
            throw new IllegalArgumentException("O tipo de conversão não pode estar vazio");
        }else if(tipoConversao.equals("FAHRENHEIT")|| tipoConversao.equals("CELSIUS") ) {
            this.tipoConversao = tipoConversao;
        }else{
            throw new IllegalArgumentException("O tipo de conversão escolhido não é válido. Tente novamente");
        }
    }

    public Double getConversao() {
        return conversao;
    }

    public void setConversao(Double conversao) {
        if(conversao == null || conversao.equals(0.0)){
            throw new IllegalArgumentException();
        }else if (tipoConversao.equals("FAHRENHEIT")){
            if ((conversao * 1.8) + 32 < -459.67) {
                throw new IllegalArgumentException("O valor informado está sendo convertido para abaixo do zero absoluto, tente novamente com outro valor");
            }else{
                this.conversao = (conversao * 1.8) + 32;

            }
        } else if (tipoConversao.equals("CELSIUS")) {
            if ((conversao-32)/ 1.8 < -273.15){
                throw new IllegalArgumentException("O valor informado está sendo convertido para abaixo do zero absoluto, tente novamente com outro valor");
            }else {
                this.conversao = (conversao-32)/ 1.8;
            }
        }else{
            throw new IllegalArgumentException("O tipo de conversão é inválido, tente novamente");
        }
    }

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);

        TempConverter converter =  new TempConverter();

        while(converter.getTipoConversao() == null) {
            System.out.println("Escolhe o tipo de conversão a ser feito (CELSIUS ou FAHRENHEIT)");
            converter.setTipoConversao(leitor.next().toUpperCase());
        }

        while(converter.getConversao() == null){
            System.out.println("Digite o valor a ser convertido");
            converter.setConversao(leitor.nextDouble());
        }

        System.out.println("A temperatura convertida é de: " + converter.getConversao() + " " + converter.getTipoConversao());

        leitor.close();
    }

}
