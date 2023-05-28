/*
* @Autor: Darwin Neira Carrasco
* @Autor: Fabiola Tapara Quispe
* @Autor: Angel Hincho Jove
* @Descripcion:
*/

import java.io.Serializable;
public class User implements Serializable{
  double balance;
  String cardNumber;

  User(String cardNumber, double balance){
    this.cardNumber = cardNumber;
    this.balance = balance;
  }

  public void deposit(double amount){
    this.balance += amount;
  }

  public void withdraw(double amount){
    this.balance -= amount;
  }

}

