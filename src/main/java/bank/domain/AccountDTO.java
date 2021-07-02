package bank.domain;


import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
	private long accountNumber;
	private Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
	private String accountHolder;
	private double balance;

	public AccountDTO(long accountNumber, String accountHolder) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}

	public AccountDTO() {
	}

	public void addEntry(AccountEntryDTO entryDto){
		entryList.add(entryDto);
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Collection<AccountEntryDTO> getEntryList() {
		return entryList;
	}

	public void setEntryList(Collection<AccountEntryDTO> entryList) {
		this.entryList = entryList;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
}
