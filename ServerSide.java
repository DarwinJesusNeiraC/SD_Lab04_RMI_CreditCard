/*
* @Autor: Darwin Neira Carrasco
* @Autor: Fabiola Tapara Quispe
* @Autor: Angel Hincho Jove
* @Descripcion:
*/

import java.rmi.Naming;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServerSide {
  public static void main(String [] args){
    try{
      CreditCardInterface c = new CreditCard();
      Registry registry = LocateRegistry.createRegistry(1100);
      registry.bind("card", c);
    }
    catch(Exception e){
      System.out.println("Trouble "+e);
    }
  }
}
