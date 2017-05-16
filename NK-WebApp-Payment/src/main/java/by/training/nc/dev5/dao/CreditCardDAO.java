package by.training.nc.dev5.dao;

import java.util.Collection;

import by.training.nc.dev5.entities.CreditCard;

public interface CreditCardDAO {
	  void insertCreditCard(CreditCard pCreditCard);
	  void deleteCreditCard(CreditCard pCreditCard);
	  CreditCard findCreditCard(String  pCreditCardId);
	  void updateCreditCard(CreditCard pCreditCard);
	  Collection<CreditCard> selectCreditCards();
}
