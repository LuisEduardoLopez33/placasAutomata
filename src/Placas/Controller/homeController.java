package Placas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class homeController {

    private String cadena;
    private String[] dicionario = {"A,B,C,D,E,F,G,H,J,K,L,M,N,P,R,S,T,U,V,W,X,Y,Z"};
    List<String> list = new ArrayList<String>();

    @FXML
    private TextField entradaUno;

    @FXML
    private TextField entradaDos;

    @FXML
    private TextField entradaTres;

    @FXML
    void butttonInicio(MouseEvent event) {
        String estado = "edoMex";
        String limite = "no";

        cadena = entradaUno.getText()+"-"+entradaDos.getText()+"-"+entradaTres.getText();
        System.out.println(cadena);
        for (int i=0; i<cadena.length(); i++){
            list.add(cadena.substring(i,i+1));
        }
        System.out.println("Imprimiendo Array...");
        for (int l=0; l< list.size(); l++){
            System.out.println(list.get(l));
        }

        switch (list.get(0)){
            case "L":
                limite = "G";
                break;
            case "M":
                estado = "edoMex";
                limite = "A";
                break;
            case "N":
                estado = "edoMex";
                limite = "A";
                break;
            case "P":

                break;
            default:
                System.out.println("No esta dentro de Nuestro Rango");
                list.clear();
        }

    }

    public void q1(){
        list.remove(0);

        String[] letras = {"L,M,N,P"};
    }

    public void q2(){
        String[] letras = {"A,B,C,D,E,F,G,H,J,K,L,M,"};

        //LGA-001-A	-	PEZ-999-Z
    }

}
