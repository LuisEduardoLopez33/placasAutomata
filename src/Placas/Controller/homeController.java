package Placas.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class homeController {

    private String cadena;
    private String[] dicionario = {"A","B","C","D","E","F","G","H","J","K","L","M","N","P","R","S","T","U","V","W","X","Y","Z"};
    List<String> list = new ArrayList<String>();
    String estado = "edoMex";
    String limite = "no";
    String tipo = "AUTOMOVIL";

    @FXML
    private TextField entradaUno;

    @FXML
    private TextField entradaDos;

    @FXML
    private TextField entradaTres;

    @FXML
    void butttonInicio(MouseEvent event) {


        cadena = entradaUno.getText()+"-"+entradaDos.getText()+"-"+entradaTres.getText();
        System.out.println(cadena);
        //llenando array
        for (int i=0; i<cadena.length(); i++){
            list.add(cadena.substring(i,i+1));
        }
//        System.out.println("Imprimiendo Array...");
//        for (int l=0; l< list.size(); l++){
//            System.out.println(list.get(l));
//        }



        switch (list.get(0)){
            case "K":
                q1(10,23);
                break;
            case "L":
                estado = "edoMex";
                q1(0,23);
                break;
            case "M":
                estado = "edoMex";
                q1(0,23);
                break;
            case "N":
                estado = "edoMex";
                q1(0,23);
                break;
            case "P":
                estado = "edoMex";
                q1(0,5);
                break;
            case "T":
                q1(2,14);
                break;
            case "U":
                estado = "SP";
                q1(20,23);
                break;
            case "V":
                estado = "SP";
                q1(0,5);
                break;
            default:
                System.out.println("No esta dentro de Nuestro Rango");
                list.clear();
        }

    }

    public void q1(int zice, int limit){
        String sms = "no esta dentro de nuestro rango";
        //System.out.println("entro a q1  -->"+dicionario[6]);
        for (int i=zice; i<limit; i++){
            if (list.get(1).equals(dicionario[i])){
                System.out.println("Pasando a q2");
                q2();
                i=limit;
                sms="";
            }else {

            }
        }

        System.out.println(sms);
        list.clear();
    }

    public void q2(){

        for (int i=0; i<dicionario.length; i++){
            if (list.get(2).equals(dicionario[i])){
                System.out.println("Pasando a q3");
                q3();
                i= dicionario.length;
            }
        }

        if (list.get(2).equals("-")){
            q10();
        }

    }

    public void q3(){
        tipo = "AUTOMOVIL";
        if (list.get(3).equals("-")){
            System.out.println("PASANDO A 4");
            q4q5q6();
        }
    }

    public void q4q5q6(){
        boolean status = false;
        boolean error = true;

        for (int i=4; i<7; i++){
            try {
                int pos = Integer.parseInt(list.get(i));
                if (pos>=0 && pos<=9){
                    status = true;
                }
            }catch (Exception e){
                System.out.println("No se Acptan letras en esta area xd");
                error = false;
            }

        }

        if (status && error){
            System.out.println("pasando a 7");
            q7();
        }

    }

    public void q7(){
        if (list.get(7).equals("-")){
            System.out.println("pasando a 8");
            q8();
        }
        //System.out.println("llegue a q7 xd xd xd");
    }

    public void q8(){
        for (int i=0; i<dicionario.length; i++){
            if (list.get(8).equals(dicionario[i])){
                System.out.println("pasando a 9");
                q9Aceptacion();
                i= dicionario.length;
            }
        }
    }

    public void q9Aceptacion(){
        boolean aceptacion = true;
        //System.out.println("Aceptaciion");
        if (tipo.equals("CAMION")){
            if (list.get(0).equals("M")){
                aceptacion = valid(0, 16);
            }
        }

        if (tipo.equals("AUTOMOVIL")){
            if (list.get(0).equals("L")){
                aceptacion = valid(6, 23);
            }
        }

        if (aceptacion){
            System.out.println("Estado: "+estado);
            System.out.println("Tipo de Veiculo: "+tipo);
        }
    }

    public boolean valid(int init, int finish){
        boolean aux = false;
        for (int i=init; i<finish; i++){
            if (list.get(1).equals(dicionario[i])){
                i=finish;
                 aux = true;
            }
        }
        return aux;
    }

    public void q10(){
        tipo = "CAMION";
        try {
            int pos = Integer.parseInt(list.get(3));
            if (pos>=0 && pos<=9){
               q4q5q6();
            }
        }catch (Exception e){
            System.out.println("No se Acptan letras en esta area xd");
        }
    }

}
