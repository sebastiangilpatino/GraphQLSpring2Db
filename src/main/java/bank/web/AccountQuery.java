package bank.web;

import bank.domain.Account;
import bank.domain.AccountDTO;
import bank.service.AccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AccountQuery implements GraphQLQueryResolver {
    @Autowired
    private AccountService accountService;

    public Optional<AccountDTO> getAccount(Long accountNumber){
        return accountService.findByAccountNumber(accountNumber);
    }

    public List<AccountDTO> getAccounts(){
        return accountService.findAll();
    }
}
