package com.example.demo.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.IAccountRepository;

@Service
public class AccountService {
   
	@Autowired
	IAccountRepository iAccountRepository;
	
	public List<Account> getAll() {
		return iAccountRepository.findAll();
	}

	public Account getById(Integer id) {
		return iAccountRepository.getById(id);
	}

	public Optional<Account> findById(Integer id) {
		return iAccountRepository.findById(id);
	}

	public Account update(Account Account) {
		Integer id = Account.getId();
		if (id != null) {
			Optional<Account> AccountOp = iAccountRepository.findById(id);
			if (AccountOp.isPresent()) {
				iAccountRepository.save(Account);
				return iAccountRepository.save(Account);
			}
		}
		return null;
	}

	public Account add(Account Account) throws ParseException {
		Account.setId(null);
		return iAccountRepository.save(Account);
	}

	public Account delete(Integer id) {
		Optional<Account> Account = iAccountRepository.findById(id);
		if (Account.isPresent()) {
			iAccountRepository.deleteById(id);
			return Account.get();
		} else {
			return null;
		}
	}

	public void deleteList(List<Integer> list) {
//		List<Category> listCategories=iCategoryRepository.findAllById(list);
		iAccountRepository.deleteAllByIdInBatch(list);
	}
}
