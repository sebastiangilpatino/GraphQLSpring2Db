package bank.service;

import bank.data.AccountRepository;
import bank.domain.Account;
import bank.domain.AccountAdapter;
import bank.domain.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountDTO add(Long accountNumber, String accountHolderName) {
        AccountDTO accountDto = new AccountDTO(accountNumber, accountHolderName);
        Account account = AccountAdapter.getAccount(accountDto);
        accountRepository.save(account);
        return accountDto;
    }

    public Optional<AccountDTO> findByAccountNumber(long accountNumber) {
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        AccountDTO accountDTO = new AccountDTO();
        if (accOptional.isPresent()) {
            accountDTO = AccountAdapter.getAccountDTO(accOptional.get());
        }
        return Optional.of(accountDTO);
    }

    public AccountDTO delete(long accountNumber) {
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        AccountDTO accountDTO = new AccountDTO();
        if (accOptional.isPresent()) {
            accountRepository.delete(accOptional.get());
            accountDTO = AccountAdapter.getAccountDTO(accOptional.get());
        }
        return accountDTO;
    }

    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = AccountAdapter.getAccountDTOList(accounts);
        return accountDTOS;
    }

    public boolean deposit(long accountNumber, double amount) {
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        if (accOptional.isPresent()) {
            Account account = accOptional.get();
            account.deposit(amount);
            accountRepository.save(account);
            return true;
        }else{
            return false;
        }
    }

    public boolean withdraw(long accountNumber, double amount) {
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        if (accOptional.isPresent()) {
            Account account = accOptional.get();
            account.withdraw(amount);
            accountRepository.save(account);
            return true;
        }else{
            return false;
        }
    }
    }
