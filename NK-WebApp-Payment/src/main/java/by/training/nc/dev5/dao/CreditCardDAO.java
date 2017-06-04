package by.training.nc.dev5.dao;

import java.util.Collection;

import by.training.nc.dev5.entities.CreditCard;

public interface CreditCardDAO {
	  int insertCreditCard(CreditCard pCreditCard);
	  boolean deleteCreditCard(CreditCard pCreditCard);
	  CreditCard findCreditCard(String  pCreditCardId);
	  boolean updateCreditCard(CreditCard pCreditCard);
	  Collection<CreditCard> selectCreditCards();
}
