/*
* @Autor: Darwin Neira Carrasco
* @Autor: Fabiola Tapara Quispe
* @Autor: Angel Hincho Jove
* @Descripcion:
*/

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteSide {
  public static void main(String [] args) throws RemoteException{
    Scanner scan = new Scanner(System.in);
    try{
      Registry registry = LocateRegistry.getRegistry("localhost", 1100);
      CreditCardInterface ci = (CreditCardInterface) registry.lookup("card");
      ci.addCreditCard("123456",new User("123456",2000));
      User u = ci.getUserInformation("123456");
      System.out.println("saldo actual: " + u.balance);
      ci.deposit("123456", 500.0);
      u = ci.getUserInformation("123456");
      System.out.println("saldo actual despues de deposito: " + u.balance);
      ci.withdraw("123456", 200.0);
      u = ci.getUserInformation("123456");
      System.out.println("saldo actual despues de retiro: " + u.balance);

    }
    catch(RemoteException er){
      System.out.println("RemoteException");
      System.out.println(er);
    }
    catch(MyException me){
      System.out.println("MyException");
      System.out.println(me);
    }
    catch(NotBoundException be){
      System.out.println("NotBoundException");
      System.out.println(be);
    }
  }
}

