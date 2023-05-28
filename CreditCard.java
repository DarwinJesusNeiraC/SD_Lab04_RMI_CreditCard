/*
* @Autor: Darwin Neira Carrasco
* @Autor: Fabiola Tapara Quispe
* @Autor: Angel Hincho Jove
* @Descripcion:
*/

import java.util.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Remote;

public class CreditCard extends UnicastRemoteObject implements CreditCardInterface{

  HashMap<String,User> userData;

  public CreditCard() throws Exception{
    super();
    userData = new HashMap<>();
  }
  @Override
  public void deposit(String numberCard, double amount) throws RemoteException, MyException {
      // TODO Auto-generated method stub
    if(amount < 0){
      throw new MyException("Cantidad Invalida");
    }
    User u = userData.get(numberCard);
    System.out.println("saldo antes dentro de deposit: " + u.balance);
    u.deposit(amount);
    //u.balance += amount;
    System.out.println("saldo despues dentro de deposit: " + u.balance);
      
  }
  @Override
  public void withdraw(String numberCard, double amount) throws RemoteException, MyException {
      // TODO Auto-generated method stub
    User u = userData.get(numberCard);
    if(amount < 0 || amount > u.balance){
      throw new MyException("Cantidad Invalida");
    }
    System.out.println("saldo antes dentro de withdraw: " + u.balance);
    u.withdraw(amount);
    System.out.println("saldo despues dentro de withdraw: " + u.balance);
      
  }

  @Override
  public User getUserInformation(String numberCard) throws RemoteException, MyException{
    return userData.get(numberCard);
  }

  @Override
  public void addCreditCard(String numberCard, User u){
    userData.put(numberCard, u);
  }

}

