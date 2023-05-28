/*
* @Autor: Darwin Neira Carrasco
* @Autor: Fabiola Tapara Quispe 
* @Autor: Angel Hincho Jove 
* @Descripcion:
*/

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface CreditCardInterface extends Remote {
  User getUserInformation(String numberCard) throws RemoteException, MyException;
  public void addCreditCard(String numberCard,User u) throws RemoteException, MyException;
  public void deposit(String numberCard,double amount) throws RemoteException, MyException;
  public void withdraw(String numberCard, double amount) throws RemoteException, MyException;
}

