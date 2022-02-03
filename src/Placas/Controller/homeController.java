package Placas.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class homeController implements Initializable {

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
    private Label estadoLabel;

    @FXML
    private Label tipoLabel;

    @FXML
    private Label errorMensaje;

    @FXML
    private Label errorLabel;

    @FXML
    private Label edoMex;

    @FXML
    private Label sanLuis;

    @FXML
    private ImageView imgEscudo;


    @FXML
    void butttonInicio(MouseEvent event) {


        cadena = entradaUno.getText()+"-"+entradaDos.getText()+"-"+entradaTres.getText();
        System.out.println(cadena);
        //llenando array
        for (int i=0; i<cadena.length(); i++){
            list.add(cadena.substring(i,i+1));
        }
        sanLuis.setVisible(false);
        edoMex.setVisible(false);
        errorMensaje.setVisible(false);
        errorLabel.setText(" ");
        estadoLabel.setText(" ");
        tipoLabel.setText(" ");

        switch (list.get(0)){
            case "K":
                estado = "Estado de Mexico";
                q1(10,23);
                break;
            case "L":
                estado = "Estado de Mexico";
                q1(0,23);
                break;
            case "M":
                estado = "Estado de Mexico";
                q1(0,23);
                break;
            case "N":
                estado = "Estado de Mexico";
                q1(0,23);
                break;
            case "P":
                estado = "Estado de Mexico";
                q1(0,5);
                break;
            case "T":
                estado = "San Luis Potosi";
                q1(2,14);
                break;
            case "U":
                estado = "San Luis Potosi";
                q1(19,23);
                break;
            case "V":
                estado = "San Luis Potosi";
                q1(0,5);
                break;
            default:
                System.out.println("No esta dentro de Nuestro Rango");
                errorMensaje.setVisible(true);
                errorLabel.setText("No esta dentro de Nuestro Rango");
                list.clear();
        }

    }

    public void q1(int zice, int limit){
        String sms = "no esta dentro de nuestro rango";
        boolean error= true;
        //System.out.println("entro a q1  -->"+dicionario[6]);
        for (int i=zice; i<limit; i++){
            if (list.get(1).equals(dicionario[i])){
                System.out.println("Pasando a q2");
                error = false;
                q2();
                i=limit;
            }
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
            list.clear();
        }

        list.clear();
    }

    public void q2(){
        boolean error= true;

        for (int i=0; i<dicionario.length; i++){
            if (list.get(0).equals("K") || list.get(0).equals("T")){
                i = dicionario.length;
            }else {
                if (list.get(2).equals(dicionario[i])){
                    System.out.println("Pasando a q3");
                    error= false;
                    q3();
                    i= dicionario.length;
                }
            }

        }

        if (list.get(2).equals("-")){
            error = false;
            q10();
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
        }

    }

    public void q3(){
        boolean error= true;
        tipo = "AUTOMOVIL";
        if (list.get(3).equals("-")){
            error= false;
            System.out.println("PASANDO A 4");
            q4q5q6();
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
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
        }else{
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
        }

    }

    public void q7(){
        boolean error= true;
        if (list.get(7).equals("-")){
            System.out.println("pasando a 8");
            error= false;
            q8();
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
        }
        //System.out.println("llegue a q7 xd xd xd");
    }

    public void q8(){
        boolean error= true;
        for (int i=0; i<dicionario.length; i++){
            if (list.get(8).equals(dicionario[i])){
                if (list.size()==9){
                    System.out.println("pasando a 9");
                    error= false;
                    q9Aceptacion();
                }
                i= dicionario.length;
            }
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
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
            estadoLabel.setText(estado);
            tipoLabel.setText(tipo);
            if(estado.equals("Estado de Mexico")){
                edoMex.setVisible(true);
            }else{
                sanLuis.setVisible(true);
            }
        }else{
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");

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
        boolean error = true;
        tipo = "CAMION";
        try {
            int pos = Integer.parseInt(list.get(3));
            if (pos>=0 && pos<=9){
                error= false;
               q4q5q6();
            }
        }catch (Exception e){
            System.out.println("No se Acptan letras en esta area xd");
        }
        if(error){
            System.out.println("No esta dentro de Nuestro Rango");
            errorMensaje.setVisible(true);
            errorLabel.setText("No esta dentro de Nuestro Rango");
        }
    }
    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        imgEscudo.setImage(new Image("Recursos/ESCUDO4.png"));
    }

}
