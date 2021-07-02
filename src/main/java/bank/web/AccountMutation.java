package bank.web;

import bank.domain.Account;
import bank.domain.AccountDTO;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMutation implements GraphQLMutationResolver {

    @Autowired
    private AccountService accountService;

    public AccountDTO deleteAccount(Long accountnumber){
        return accountService.delete(accountnumber);
    }

    public AccountDTO addAccount(Long accountNumber, String accountHolderName){
        return accountService.add(accountNumber,accountHolderName);
    }

    public boolean deposit(Long accountnumber, Double amount){
        return accountService.deposit(accountnumber,amount);
    }

    public boolean withdraw(Long accountnumber, Double amount){
        return accountService.withdraw(accountnumber,amount);
    }

}
